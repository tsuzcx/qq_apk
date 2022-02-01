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
  private static Executor jdField_a_of_type_JavaUtilConcurrentExecutor;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler.Callback jdField_a_of_type_AndroidOsHandler$Callback = new EmoticonFromGroupManager.1(this);
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper(), this.jdField_a_of_type_AndroidOsHandler$Callback);
  private BaseQQAppInterface jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface;
  private IEmoticonFromGroupDBManagerService<EmoticonFromGroupEntity> jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService;
  private final List<Integer> jdField_a_of_type_JavaUtilList = Arrays.asList(new Integer[] { Integer.valueOf(-2000), Integer.valueOf(-1035), Integer.valueOf(-2006) });
  private final List<Integer> b = Arrays.asList(new Integer[] { Integer.valueOf(1), Integer.valueOf(3000) });
  
  static
  {
    ThreadPoolParams localThreadPoolParams = new ThreadPoolParams();
    localThreadPoolParams.poolThreadName = "groupemostore_pool";
    localThreadPoolParams.corePoolsize = 2;
    localThreadPoolParams.maxPooolSize = 2;
    localThreadPoolParams.priority = 5;
    localThreadPoolParams.queue = new LinkedBlockingQueue();
    localThreadPoolParams.keepAliveTime = 10;
    jdField_a_of_type_JavaUtilConcurrentExecutor = ThreadManager.newFreeThreadPool(localThreadPoolParams);
  }
  
  public EmoticonFromGroupManager() {}
  
  public EmoticonFromGroupManager(BaseQQAppInterface paramBaseQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface = paramBaseQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getApp();
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService = ((IEmoticonFromGroupDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IEmoticonFromGroupDBManagerService.class));
  }
  
  private String b(String paramString)
  {
    if ((paramString != null) && (!"".equals(paramString)))
    {
      String str = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin();
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
    return (this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().widthPixels - ScreenUtil.dip2px(11.0F) * 2 - ScreenUtil.dip2px(2.0F) * 2) / 3;
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
          localObject = this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getCurrentAccountUin();
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
            int i = EmotionForEmoGroupUtil.a(this.jdField_a_of_type_AndroidContentContext, str);
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
  
  public MessageForPic a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
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
      if (b(localMessageRecord))
      {
        Iterator localIterator = a(localMessageRecord).iterator();
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
  
  protected MessageRecord a(String paramString, int paramInt, long paramLong)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).queryMsgItemByShmsgseq(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, paramString, paramInt, paramLong);
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
          double d = l;
          Double.isNaN(d);
          int i = (int)Math.ceil(d / 86400000.0D) - 1;
          if (i == 0) {
            str = HardCodeUtil.a(2131704161);
          }
          for (;;)
          {
            return str;
            if (1 == i) {
              str = HardCodeUtil.a(2131704152);
            } else if (7 > i) {
              switch (localTime1.weekDay)
              {
              default: 
                return null;
              case 6: 
                str = HardCodeUtil.a(2131704188);
                break;
              case 5: 
                str = HardCodeUtil.a(2131704180);
                break;
              case 4: 
                str = HardCodeUtil.a(2131704156);
                break;
              case 3: 
                str = HardCodeUtil.a(2131704174);
                break;
              case 2: 
                str = HardCodeUtil.a(2131704160);
                break;
              case 1: 
                str = HardCodeUtil.a(2131704197);
                break;
              case 0: 
                str = HardCodeUtil.a(2131704173);
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
  
  public String a(String paramString)
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
  
  public List<EmoticonFromGroupEntity> a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getEmoDataForShow();
  }
  
  protected List<MessageRecord> a(MessageRecord paramMessageRecord)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).getMsgElemListForMessageForMixedMsg(paramMessageRecord);
  }
  
  public Map<String, List<EmoticonFromGroupEntity>> a(List<EmoticonFromGroupEntity> paramList)
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
  
  public void a()
  {
    ThreadManager.post(new EmoticonFromGroupManager.4(this), 5, null, true);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("init mEmoManager.mCountOfSpare:");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getCountOfSpare());
      QLog.d("EmoticonFromGroup_Manager", 2, localStringBuilder.toString());
    }
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
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.update2DB(paramEmoticonFromGroupEntity, 2);
  }
  
  protected void a(MessageForPic paramMessageForPic, MessageRecord paramMessageRecord)
  {
    ((IEmosmService)QRoute.api(IEmosmService.class)).copyBaseInfoFromMixedToPic(paramMessageForPic, paramMessageRecord);
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (a(paramMessageRecord)) {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.deleteCacheAndDB(paramMessageRecord);
    }
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface != null)
    {
      MqqHandler localMqqHandler = ((IEmosmService)QRoute.api(IEmosmService.class)).getChatActivityHander(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface);
      if (localMqqHandler != null)
      {
        Object localObject2 = null;
        Object localObject1 = b();
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
              ((IEmosmService)QRoute.api(IEmosmService.class)).saveAioMedia2Weiyun(this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface, ((EmoticonFromGroupEntity)localObject1).msg, new WeiyunCallbackImpl(localMqqHandler));
              this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(1);
              return;
            }
            ((IFMToastUtil)QRoute.api(IFMToastUtil.class)).toastError(2131692557);
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
  
  public void a(List<MessageRecord> paramList)
  {
    if (!a()) {
      return;
    }
    if ((this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getDBCacheSize() < 600) && (this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getAddedEmoCacheDataSize() < 300))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        MessageRecord localMessageRecord = (MessageRecord)paramList.next();
        Integer localInteger = Integer.valueOf(localMessageRecord.msgtype);
        if ((this.jdField_a_of_type_JavaUtilList.contains(localInteger)) && (!((IPicFlash)QRoute.api(IPicFlash.class)).isFlashPicMsg(localMessageRecord)) && (!((IHotChatUtil)QRoute.api(IHotChatUtil.class)).isHotChatMsg(localMessageRecord)))
        {
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("filterMessageByType type: ");
            localStringBuilder.append(localInteger);
            QLog.i("EmoticonFromGroup_Manager", 2, localStringBuilder.toString());
          }
          this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.updateDBCache(localMessageRecord);
        }
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e("EmoticonFromGroup_Manager", 1, "over max limit.");
    }
  }
  
  public boolean a()
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
  
  public boolean a(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    Activity localActivity = Foreground.getTopActivity();
    if (localActivity == null)
    {
      QLog.e("EmoticonFromGroup_Manager", 1, "activity is null.");
      return false;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getCountOfSpare() < 1)
    {
      if (300 == FavEmoConstant.a)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2131689648, 0).b(2131299168);
      }
      else if (144 == FavEmoConstant.a)
      {
        paramEmoticonFromGroupEntity = new EmoticonFromGroupManager.3(this, localActivity);
        if (localActivity != null)
        {
          paramEmoticonFromGroupEntity = DialogUtil.a(localActivity, 0, HardCodeUtil.a(2131704177), localActivity.getString(2131689647), HardCodeUtil.a(2131704175), HardCodeUtil.a(2131704199), paramEmoticonFromGroupEntity, paramEmoticonFromGroupEntity);
          if (paramEmoticonFromGroupEntity != null) {
            paramEmoticonFromGroupEntity.show();
          }
        }
      }
      return false;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.decreaseCountOfSpare();
    c(paramEmoticonFromGroupEntity);
    QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131691912, 0).b(2131299168);
    return true;
  }
  
  public boolean a(MessageRecord paramMessageRecord)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (this.b.contains(Integer.valueOf(paramMessageRecord.istroop)))
      {
        bool1 = bool2;
        if (this.jdField_a_of_type_JavaUtilList.contains(Integer.valueOf(paramMessageRecord.msgtype))) {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public boolean a(String paramString)
  {
    Object localObject = (IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
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
    paramString = a(paramString);
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
  
  public int b()
  {
    Object localObject = (IFavroamingDBManagerService)this.jdField_a_of_type_ComTencentCommonAppBusinessBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class);
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
  
  public String b(long paramLong, int paramInt)
  {
    return a(paramLong * 1000L, paramInt);
  }
  
  public List<EmoticonFromGroupEntity> b()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getEmoDataShowing();
  }
  
  public void b(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.deleteDataFromCache(paramEmoticonFromGroupEntity);
  }
  
  public void b(MessageRecord paramMessageRecord)
  {
    a(paramMessageRecord);
  }
  
  public void b(List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.update2DB(paramList, 2);
  }
  
  protected boolean b(MessageRecord paramMessageRecord)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).isMessageForMixedMsg(paramMessageRecord);
  }
  
  public boolean b(String paramString)
  {
    Iterator localIterator = b().iterator();
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
    this.jdField_a_of_type_AndroidOsHandler.sendMessage((Message)localObject);
    int i = this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getCountOfSpare();
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
  
  public void c(EmoticonFromGroupEntity paramEmoticonFromGroupEntity)
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
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getUploadDrawableList().add(localObject);
      ((URLDrawable)localObject).setURLDrawableListener(new EmoticonFromGroupManager.6(this, (URLDrawable)localObject));
      ((URLDrawable)localObject).startDownload();
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.getUploadDrawableList().remove(localObject);
      jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new EmoticonFromGroupManager.7(this, (URLDrawable)localObject));
    }
    paramEmoticonFromGroupEntity.status = 0;
  }
  
  public void c(List<EmoticonFromGroupEntity> paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIEmoticonFromGroupDBManagerService.deleteDataFromCache(paramList);
  }
  
  public void d(List<EmoticonFromGroupEntity> paramList)
  {
    if (!paramList.isEmpty()) {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, 2, 2131691912, 0).b(2131299168);
    }
    jdField_a_of_type_JavaUtilConcurrentExecutor.execute(new EmoticonFromGroupManager.5(this, paramList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.EmoticonFromGroupManager
 * JD-Core Version:    0.7.0.1
 */