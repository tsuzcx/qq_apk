package com.tencent.mobileqq.emosm.favroaming;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.format.Time;
import android.util.DisplayMetrics;
import android.view.View;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadPoolParams;
import com.tencent.mobileqq.app.utils.DiySecureFileHelper;
import com.tencent.mobileqq.core.util.EmotionForEmoGroupUtil;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.EmoticonFromGroupEntity;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.emosm.api.IEmoticonFromGroupDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.filemanager.api.IFMToastUtil;
import com.tencent.mobileqq.nearby.api.IHotChatUtil;
import com.tencent.mobileqq.pic.api.IPicFlash;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.SecUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import mqq.app.Foreground;
import mqq.os.MqqHandler;

public class EmoticonFromGroupManager
  implements IEmoticonFromGroupManager
{
  private static Executor f;
  private final List<Integer> a = Arrays.asList(new Integer[] { Integer.valueOf(-2000), Integer.valueOf(-1035), Integer.valueOf(-2006) });
  private final List<Integer> b = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(3000) });
  private BaseQQAppInterface c;
  private Context d;
  private IEmoticonFromGroupDBManagerService<EmoticonFromGroupEntity> e;
  private Handler.Callback g = new EmoticonFromGroupManager.1(this);
  private Handler h = new Handler(Looper.getMainLooper(), this.g);
  
  static
  {
    ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
    localThreadPoolParams.poolThreadName = "groupemostore_pool";
    localThreadPoolParams.corePoolsize = 2;
    localThreadPoolParams.maxPooolSize = 2;
    localThreadPoolParams.priority = 5;
    localThreadPoolParams.queue = new LinkedBlockingQueue();
    localThreadPoolParams.keepAliveTime = 10;
    f = ThreadManager.newFreeThreadPool(localThreadPoolParams);
  }
  
  public EmoticonFromGroupManager() {}
  
  public EmoticonFromGroupManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.c = paramBaseQQAppInterface;
    this.d = this.c.getApp();
    this.e = ((IEmoticonFromGroupDBManagerService)this.c.getRuntimeService(IEmoticonFromGroupDBManagerService.class));
  }
  
  private String e(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      String str = this.c.getCurrentAccountUin();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
      localStringBuilder.append(DiySecureFileHelper.a(str));
      localStringBuilder.append(paramString);
      localStringBuilder.append(".jpg");
      return localStringBuilder.toString();
    }
    return "";
  }
  
  public int a()
  {
    return (this.d.getResources().getDisplayMetrics().widthPixels - ScreenUtil.dip2px(11.0F) * 2 - ScreenUtil.dip2px(2.0F) * 2) / 3;
  }
  
  public int a(URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (1 == paramURLDrawable.getStatus()))
    {
      String str = paramURLDrawable.getURL().toString();
      if (AbsDownloader.hasFile(str))
      {
        Object localObject = AbsDownloader.getFile(str);
        str = null;
        if (localObject != null) {
          str = SecUtil.getFileMd5(((File)localObject).getAbsolutePath());
        }
        if ((str != null) && (!"".equals(str)))
        {
          localObject = this.c.getCurrentAccountUin();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(AppConstants.SDCARD_IMG_FAVORITE);
          localStringBuilder.append(DiySecureFileHelper.a((String)localObject));
          localStringBuilder.append(str);
          localStringBuilder.append(".jpg");
          str = localStringBuilder.toString();
          try
          {
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("addEmoticonToServer urldrawable status: ");
              ((StringBuilder)localObject).append(paramURLDrawable.getStatus());
              QLog.i("Emo.onUploadPic", 2, ((StringBuilder)localObject).toString());
            }
            paramURLDrawable.saveTo(str);
            int i = EmotionForEmoGroupUtil.a(this.d, str);
            return i;
          }
          catch (IOException paramURLDrawable)
          {
            paramURLDrawable.printStackTrace();
            QLog.d("EmoticonFromGroup_Manager", 1, paramURLDrawable, new Object[0]);
          }
        }
      }
    }
    return -1;
  }
  
  public long a(String paramString, int paramInt)
  {
    SimpleDateFormat localSimpleDateFormat;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localSimpleDateFormat = null;
        } else {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
      }
      else {
        localSimpleDateFormat = new SimpleDateFormat("MM月dd日");
      }
    }
    else {
      localSimpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
    }
    if (localSimpleDateFormat != null) {
      try
      {
        long l = localSimpleDateFormat.parse(paramString).getTime();
        return l;
      }
      catch (ParseException paramString)
      {
        paramString.printStackTrace();
      }
    }
    return 0L;
  }
  
  public Drawable a(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable != null) && (paramInt >= 0))
    {
      paramInt *= 2;
      if (paramDrawable.getOpacity() != -1) {
        localObject = Bitmap.Config.ARGB_8888;
      } else {
        localObject = Bitmap.Config.RGB_565;
      }
      Object localObject = Bitmap.createBitmap(paramInt, paramInt, (Bitmap.Config)localObject);
      Canvas localCanvas = new Canvas((Bitmap)localObject);
      paramDrawable.setBounds(0, 0, paramInt, paramInt);
      paramDrawable.draw(localCanvas);
      return new BitmapDrawable(BaseImageUtil.a((Bitmap)localObject, ((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight()));
    }
    return null;
  }
  
  public Drawable a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity, int paramInt1, int paramInt2, Drawable paramDrawable)
  {
    for (;;)
    {
      try
      {
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        if (65537 == paramInt1)
        {
          localURLDrawableOptions.mRequestWidth = paramInt2;
          localURLDrawableOptions.mRequestHeight = paramInt2;
          paramDrawable = new StringBuilder();
          paramDrawable.append(paramEmoticonFromGroupEntity.thumbURL);
          paramDrawable.append("?noRound");
          paramDrawable = new URL(paramDrawable.toString());
        }
        else if (1 == paramInt1)
        {
          if (paramEmoticonFromGroupEntity.gifImg) {
            localURLDrawableOptions.mPlayGifImage = true;
          }
          if (paramDrawable != null)
          {
            localURLDrawableOptions.mLoadingDrawable = paramDrawable;
            localURLDrawableOptions.mFailedDrawable = paramDrawable;
          }
          paramDrawable = new URL(paramEmoticonFromGroupEntity.bigURL);
        }
        else
        {
          if (!QLog.isColorLevel()) {
            break label195;
          }
          QLog.i("EmoticonFromGroup_Manager", 2, "URLString get type error!");
          break label195;
        }
        if (paramDrawable != null)
        {
          paramDrawable = URLDrawable.getDrawable(paramDrawable, localURLDrawableOptions);
          if (paramEmoticonFromGroupEntity.msg != null) {
            paramDrawable.setTag(paramEmoticonFromGroupEntity.msg);
          }
          return paramDrawable;
        }
      }
      catch (MalformedURLException paramEmoticonFromGroupEntity)
      {
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Manager", 2, "group emo new URL error!");
        }
        paramEmoticonFromGroupEntity.printStackTrace();
      }
      return null;
      label195:
      paramDrawable = null;
    }
  }
  
  public EmoticonFromGroupEntity a(MessageRecord paramMessageRecord)
  {
    EmoticonFromGroupEntity localEmoticonFromGroupEntity = new EmoticonFromGroupEntity();
    localEmoticonFromGroupEntity.troopUin = paramMessageRecord.frienduin;
    localEmoticonFromGroupEntity.fromType = paramMessageRecord.istroop;
    localEmoticonFromGroupEntity.timestamp = paramMessageRecord.time;
    localEmoticonFromGroupEntity.msgseq = paramMessageRecord.shmsgseq;
    MessageForPic localMessageForPic = (MessageForPic)paramMessageRecord;
    boolean bool;
    if ((localMessageForPic.imageType != 3) && (localMessageForPic.imageType != 2000)) {
      bool = false;
    } else {
      bool = true;
    }
    localEmoticonFromGroupEntity.gifImg = bool;
    localEmoticonFromGroupEntity.md5 = localMessageForPic.md5;
    paramMessageRecord = (IPicHelper)QRoute.api(IPicHelper.class);
    Object localObject = null;
    paramMessageRecord = paramMessageRecord.getURL(localMessageForPic, 65537, null);
    if (paramMessageRecord == null) {
      paramMessageRecord = null;
    } else {
      paramMessageRecord = paramMessageRecord.toString();
    }
    localEmoticonFromGroupEntity.thumbURL = paramMessageRecord;
    paramMessageRecord = ((IPicHelper)QRoute.api(IPicHelper.class)).getURL(localMessageForPic, 1, null);
    if (paramMessageRecord == null) {
      paramMessageRecord = localObject;
    } else {
      paramMessageRecord = paramMessageRecord.toString();
    }
    localEmoticonFromGroupEntity.bigURL = paramMessageRecord;
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "addBaseInfoToEmoticonFromGroupEntity");
    }
    return localEmoticonFromGroupEntity;
  }
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).queryMsgItemByShmsgseq(this.c, paramString, paramInt, paramLong);
  }
  
  public String a(long paramLong)
  {
    Time localTime1 = new Time();
    localTime1.set(paramLong);
    long l = System.currentTimeMillis();
    Time localTime2 = new Time();
    localTime2.set(l);
    String str;
    if (l >= paramLong)
    {
      l -= paramLong;
      str = null;
      if (0L < l)
      {
        if (localTime1.year == localTime2.year)
        {
          double d1 = l;
          Double.isNaN(d1);
          int i = (int)Math.ceil(d1 / 86400000.0D) - 1;
          if (i == 0) {
            str = HardCodeUtil.a(2131902083);
          }
          for (;;)
          {
            return str;
            if (1 == i) {
              str = HardCodeUtil.a(2131902074);
            } else if (7 > i) {
              switch (localTime1.weekDay)
              {
              default: 
                return null;
              case 6: 
                str = HardCodeUtil.a(2131902110);
                break;
              case 5: 
                str = HardCodeUtil.a(2131902102);
                break;
              case 4: 
                str = HardCodeUtil.a(2131902078);
                break;
              case 3: 
                str = HardCodeUtil.a(2131902096);
                break;
              case 2: 
                str = HardCodeUtil.a(2131902082);
                break;
              case 1: 
                str = HardCodeUtil.a(2131902119);
                break;
              case 0: 
                str = HardCodeUtil.a(2131902095);
                break;
              }
            } else {
              str = a(paramLong, 1);
            }
          }
        }
        return a(paramLong, 0);
      }
    }
    else
    {
      str = a(paramLong, 0);
    }
    return str;
  }
  
  public String a(long paramLong, int paramInt)
  {
    String str = null;
    SimpleDateFormat localSimpleDateFormat;
    if (paramInt != 0)
    {
      if (paramInt != 1)
      {
        if (paramInt != 2) {
          localSimpleDateFormat = null;
        } else {
          localSimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        }
      }
      else {
        localSimpleDateFormat = new SimpleDateFormat("M月d日");
      }
    }
    else {
      localSimpleDateFormat = new SimpleDateFormat("y年M月d日");
    }
    if (localSimpleDateFormat != null) {
      str = localSimpleDateFormat.format(new Date(paramLong));
    }
    return str;
  }
  
  public String a(String paramString1, int paramInt, String paramString2)
  {
    long l = a(paramString1, 2);
    paramString1 = new StringBuilder();
    paramString1.append(a(l));
    paramString1.append(paramString2);
    paramString1.append("(");
    paramString1.append(paramInt);
    paramString1.append(")");
    return paramString1.toString();
  }
  
  public void a(Context paramContext, MessageForPic paramMessageForPic, View paramView)
  {
    if (paramMessageForPic == null) {
      return;
    }
    ((IEmosmService)QRoute.api(IEmosmService.class)).enterBigPicPreview(paramContext, paramMessageForPic, paramView);
  }
  
  public void a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    this.e.update2DB(paramEmoticonFromGroupEntity, 2);
  }
  
  protected void a(MessageForPic paramMessageForPic, MessageRecord paramMessageRecord)
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).copyBaseInfoFromMixedToPic(paramMessageForPic, paramMessageRecord);
  }
  
  public void a(List<MessageRecord> paramList)
  {
    if (!e()) {
      return;
    }
    if ((this.e.getDBCacheSize() < 600) && (this.e.getAddedEmoCacheDataSize() < 300))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        Integer localInteger = Integer.valueOf(localMessageRecord.msgtype);
        if ((this.a.contains(localInteger)) && (!((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(localMessageRecord)) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(localMessageRecord)))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("filterMessageByType type: ");
            localStringBuilder.append(localInteger);
            QLog.i("EmoticonFromGroup_Manager", 2, localStringBuilder.toString());
          }
          this.e.updateDBCache(localMessageRecord);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("EmoticonFromGroup_Manager", 1, "over max limit.");
    }
  }
  
  public boolean a(String paramString)
  {
    Object localObject = (IFavroamingDBManagerService)this.c.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "call getEmoticonDataList from EmoticonFromGroupManager.filterFavoriteEmoticonAfterDownload");
    }
    localObject = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    ArrayList localArrayList = new ArrayList();
    boolean bool2 = false;
    if ((localObject != null) && (!((List)localObject).isEmpty()))
    {
      int i = 0;
      while (i < ((List)localObject).size())
      {
        if ((TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(i)).RomaingType)) || (!"needDel".equals(((CustomEmotionData)((List)localObject).get(i)).RomaingType))) {
          localArrayList.add(((List)localObject).get(i));
        }
        i += 1;
      }
    }
    boolean bool1 = bool2;
    if (!localArrayList.isEmpty())
    {
      localObject = localArrayList.iterator();
      do
      {
        bool1 = bool2;
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
      } while (!paramString.equals(((CustomEmotionData)((Iterator)localObject).next()).md5));
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("filterFavoriteEmoticonAfterDownload ");
        ((StringBuilder)localObject).append(paramString);
        QLog.i("EmoticonFromGroup_Manager", 2, ((StringBuilder)localObject).toString());
      }
      bool1 = true;
    }
    return bool1;
  }
  
  public boolean a(List<CustomEmotionData> paramList, String paramString)
  {
    paramString = d(paramString);
    if (!paramList.isEmpty())
    {
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        if (paramString.equals(((CustomEmotionData)paramList.next()).md5))
        {
          if (QLog.isColorLevel()) {
            QLog.i("EmoticonFromGroup_Manager", 2, "filter favorite true.");
          }
          return true;
        }
      }
    }
    return false;
  }
  
  public String b(long paramLong, int paramInt)
  {
    return a(paramLong * 1000L, paramInt);
  }
  
  public List<EmoticonFromGroupEntity> b()
  {
    return this.e.getEmoDataForShow();
  }
  
  public Map<String, List<EmoticonFromGroupEntity>> b(List<EmoticonFromGroupEntity> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      TreeMap localTreeMap = new TreeMap(new EmoticonFromGroupManager.2(this));
      Iterator localIterator = paramList.iterator();
      for (;;)
      {
        paramList = localTreeMap;
        if (!localIterator.hasNext()) {
          break;
        }
        paramList = (EmoticonFromGroupEntity)localIterator.next();
        String str = b(paramList.timestamp, 2);
        if (localTreeMap.containsKey(str))
        {
          ((List)localTreeMap.get(str)).add(paramList);
        }
        else
        {
          ArrayList localArrayList = new ArrayList();
          localArrayList.add(paramList);
          localTreeMap.put(str, localArrayList);
        }
      }
    }
    paramList = null;
    return paramList;
  }
  
  public void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    this.e.deleteDataFromCache(paramEmoticonFromGroupEntity);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    if (d(paramMessageRecord)) {
      this.e.deleteCacheAndDB(paramMessageRecord);
    }
  }
  
  public void b(String paramString)
  {
    if (this.c != null)
    {
      MqqHandler localMqqHandler = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.c);
      if (localMqqHandler != null)
      {
        Object localObject2 = null;
        Object localObject1 = c();
        if (localObject1 == null)
        {
          QLog.e("EmoticonFromGroup_Manager", 1, "save to WY, datas is null.");
          return;
        }
        Iterator localIterator = ((List)localObject1).iterator();
        do
        {
          localObject1 = localObject2;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject1 = (EmoticonFromGroupEntity)localIterator.next();
        } while (!paramString.equals(((EmoticonFromGroupEntity)localObject1).md5));
        if (localObject1 != null)
        {
          if (((EmoticonFromGroupEntity)localObject1).msg != null)
          {
            if ((!((IEmosmService)QRoute.api(IEmosmService.class)).isFlashPicMsg(((EmoticonFromGroupEntity)localObject1).msg)) && (!((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(((EmoticonFromGroupEntity)localObject1).msg)))
            {
              ((IEmosmService)QRoute.api(IEmosmService.class)).saveAioMedia2Weiyun(this.c, ((EmoticonFromGroupEntity)localObject1).msg, new WeiyunCallbackImpl(localMqqHandler));
              this.h.sendEmptyMessage(1);
              return;
            }
            ((IFMToastUtil)QRoute.api(IFMToastUtil.class)).toastError(2131889580);
            return;
          }
          QLog.e("EmoticonFromGroup_Manager.msgnull", 1, "save2WY msg is null.");
          return;
        }
        if (QLog.isColorLevel()) {
          QLog.i("EmoticonFromGroup_Manager", 2, "save2WY, tarEmo is null.");
        }
      }
    }
  }
  
  public MessageForPic c(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return null;
    }
    MessageRecord localMessageRecord = a(paramEmoticonFromGroupEntity.troopUin, paramEmoticonFromGroupEntity.fromType, paramEmoticonFromGroupEntity.msgseq);
    if (localMessageRecord != null)
    {
      if ((localMessageRecord instanceof MessageForPic)) {
        return (MessageForPic)localMessageRecord;
      }
      if (f(localMessageRecord))
      {
        Iterator localIterator = e(localMessageRecord).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (MessageRecord)localIterator.next();
          if ((localObject instanceof MessageForPic))
          {
            localObject = (MessageForPic)localObject;
            if (((MessageForPic)localObject).md5.equals(paramEmoticonFromGroupEntity.md5))
            {
              a((MessageForPic)localObject, localMessageRecord);
              return localObject;
            }
          }
        }
      }
    }
    return null;
  }
  
  public List<EmoticonFromGroupEntity> c()
  {
    return this.e.getEmoDataShowing();
  }
  
  public void c(MessageRecord paramMessageRecord)
  {
    b(paramMessageRecord);
  }
  
  public void c(List<EmoticonFromGroupEntity> paramList)
  {
    this.e.update2DB(paramList, 2);
  }
  
  public boolean c(String paramString)
  {
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext())
    {
      localObject = (EmoticonFromGroupEntity)localIterator.next();
      if ((paramString.equals(((EmoticonFromGroupEntity)localObject).md5)) && (((EmoticonFromGroupEntity)localObject).status != 0))
      {
        paramString = (String)localObject;
        break label61;
      }
    }
    paramString = null;
    label61:
    Object localObject = Message.obtain();
    ((Message)localObject).what = 2;
    ((Message)localObject).obj = paramString;
    this.h.sendMessage((Message)localObject);
    int i = this.e.getCountOfSpare();
    boolean bool = true;
    if (i < 1) {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("isSuccess: ");
      paramString.append(bool);
      QLog.i("EmoticonFromGroup_Manager", 2, paramString.toString());
    }
    return bool;
  }
  
  public int d()
  {
    Object localObject = (IFavroamingDBManagerService)this.c.getRuntimeService(IFavroamingDBManagerService.class);
    if (QLog.isColorLevel()) {
      QLog.i("EmoticonFromGroup_Manager", 2, "Call getEmoticonDataList from getFavEmoCount.");
    }
    localObject = ((IFavroamingDBManagerService)localObject).getEmoticonDataList();
    int k = 0;
    int j = 0;
    int i = k;
    if (localObject != null)
    {
      i = k;
      if (!((List)localObject).isEmpty()) {
        for (i = 0; j < ((List)localObject).size(); i = k)
        {
          if (!TextUtils.isEmpty(((CustomEmotionData)((List)localObject).get(j)).RomaingType))
          {
            k = i;
            if ("needDel".equals(((CustomEmotionData)((List)localObject).get(j)).RomaingType)) {}
          }
          else
          {
            k = i + 1;
          }
          j += 1;
        }
      }
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("emoCount: ");
      ((StringBuilder)localObject).append(i);
      QLog.i("EmoticonFromGroup_Manager", 2, ((StringBuilder)localObject).toString());
    }
    return i;
  }
  
  public String d(String paramString)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (AbsDownloader.hasFile(paramString)))
    {
      paramString = AbsDownloader.getFile(paramString);
      if (paramString != null) {
        return SecUtil.getFileMd5(paramString.getAbsolutePath());
      }
    }
    return "";
  }
  
  public void d(List<EmoticonFromGroupEntity> paramList)
  {
    this.e.deleteDataFromCache(paramList);
  }
  
  public boolean d(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    Activity localActivity = Foreground.getTopActivity();
    if (localActivity == null)
    {
      QLog.e("EmoticonFromGroup_Manager", 1, "activity is null.");
      return false;
    }
    if (this.e.getCountOfSpare() < 1)
    {
      if (300 == FavEmoConstant.a)
      {
        QQToast.makeText(this.d, 2131886259, 0).show(2131299920);
      }
      else if (144 == FavEmoConstant.a)
      {
        paramEmoticonFromGroupEntity = new EmoticonFromGroupManager.3(this, localActivity);
        if (localActivity != null)
        {
          paramEmoticonFromGroupEntity = DialogUtil.a(localActivity, 0, HardCodeUtil.a(2131902099), localActivity.getString(2131886258), HardCodeUtil.a(2131902097), HardCodeUtil.a(2131902121), paramEmoticonFromGroupEntity, paramEmoticonFromGroupEntity);
          if (paramEmoticonFromGroupEntity != null) {
            paramEmoticonFromGroupEntity.show();
          }
        }
      }
      return false;
    }
    this.e.decreaseCountOfSpare();
    e(paramEmoticonFromGroupEntity);
    QQToast.makeText(this.d, 2, 2131888879, 0).show(2131299920);
    return true;
  }
  
  public boolean d(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (this.b.contains(Integer.valueOf(paramMessageRecord.istroop)))
      {
        bool1 = bool2;
        if (this.a.contains(Integer.valueOf(paramMessageRecord.msgtype))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  protected List<MessageRecord> e(MessageRecord paramMessageRecord)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).getMsgElemListForMessageForMixedMsg(paramMessageRecord);
  }
  
  public void e(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    if (paramEmoticonFromGroupEntity == null) {
      return;
    }
    Object localObject = (URLDrawable)a(paramEmoticonFromGroupEntity, 1, -1, null);
    if (localObject == null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("get drawable failed: ");
      ((StringBuilder)localObject).append(paramEmoticonFromGroupEntity);
      QLog.e("EmoticonFromGroup_Manager", 1, ((StringBuilder)localObject).toString());
      return;
    }
    if (1 != ((URLDrawable)localObject).getStatus())
    {
      this.e.getUploadDrawableList().add(localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new EmoticonFromGroupManager.6(this, (URLDrawable)localObject));
      ((URLDrawable)localObject).startDownload();
    }
    else
    {
      this.e.getUploadDrawableList().remove(localObject);
      f.execute(new EmoticonFromGroupManager.7(this, (URLDrawable)localObject));
    }
    paramEmoticonFromGroupEntity.status = 0;
  }
  
  public void e(List<EmoticonFromGroupEntity> paramList)
  {
    if (!paramList.isEmpty()) {
      QQToast.makeText(this.d, 2, 2131888879, 0).show(2131299920);
    }
    f.execute(new EmoticonFromGroupManager.5(this, paramList));
  }
  
  public boolean e()
  {
    Object localObject = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValue(DPCNames.vip_individuation.name());
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      if ((localObject != null) && (localObject.length >= 8) && ("0".equals(localObject[7]))) {
        return false;
      }
    }
    return true;
  }
  
  public void f()
  {
    ThreadManager.post(new EmoticonFromGroupManager.4(this), 5, null, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init mEmoManager.mCountOfSpare:");
      localStringBuilder.append(this.e.getCountOfSpare());
      QLog.d("EmoticonFromGroup_Manager", 2, localStringBuilder.toString());
    }
  }
  
  protected boolean f(MessageRecord paramMessageRecord)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).isMessageForMixedMsg(paramMessageRecord);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager
 * JD-Core Version:    0.7.0.1
 */