package com.tencent.mobileqq.emotionintegrate;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.photo.AIOGalleryAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIOPhotoListAdapter;
import com.tencent.mobileqq.activity.aio.photo.AIORichExpandInfo;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.magicface.drawable.PngFrameDrawable;
import com.tencent.mobileqq.pic.DownCallBack;
import com.tencent.mobileqq.pic.PicDownloadInfo;
import com.tencent.mobileqq.pic.PicReq;
import com.tencent.mobileqq.pic.api.IPicBus;
import com.tencent.mobileqq.pic.api.IPicHelper;
import com.tencent.mobileqq.pic.api.IPicTransFile.IPicDownloadPro;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.transfile.AbsDownloader;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.GridView;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Set;
import mqq.app.AppRuntime;

public class ChatHistoryEmotionAdapter
  extends BaseAdapter
  implements URLDrawableDownListener, EmotionDownGIFCallback.UiCallback
{
  public static final Object a = new Object();
  public static final Object b = new Object();
  public static final Object c = new Object();
  List<Object> d = new ArrayList();
  int e = 4;
  int f = -1;
  public boolean g = false;
  private List<MessageRecord> h;
  private LayoutInflater i;
  private EmotionDataManager j;
  private Handler k;
  private GridView l;
  private Context m;
  private int n;
  private int o;
  private Calendar p = null;
  private String q = null;
  private boolean r = true;
  private boolean s = false;
  private HashMap<MessageForPic, EmotionDownGIFCallback> t = new HashMap();
  private int u = -1;
  private int v = -1;
  private AIORichExpandInfo w = new AIORichExpandInfo();
  
  public ChatHistoryEmotionAdapter(Activity paramActivity, EmotionDataManager paramEmotionDataManager, Handler paramHandler, int paramInt, GridView paramGridView)
  {
    this.m = paramActivity;
    this.j = paramEmotionDataManager;
    this.k = paramHandler;
    this.n = paramInt;
    this.l = paramGridView;
    this.i = paramActivity.getLayoutInflater();
    this.o = AIOUtils.b(40.0F, this.m.getResources());
  }
  
  private void a(int paramInt1, View paramView, int paramInt2, Object paramObject)
  {
    if (paramInt2 != 0)
    {
      if (paramInt2 != 2) {
        return;
      }
      if (!ChatHistoryEmotionAdapter.HeaderHolder.class.isInstance(paramObject)) {
        return;
      }
      paramObject = (ChatHistoryEmotionAdapter.HeaderHolder)paramObject;
      if (paramObject != null)
      {
        String str = (String)getItem(paramInt1);
        paramObject.a.setText(str);
        Object localObject;
        if (AppSetting.e)
        {
          paramInt1 /= 4;
          localObject = paramObject.a;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131899882));
          localStringBuilder.append(paramInt1 + 1);
          localStringBuilder.append(HardCodeUtil.a(2131899835));
          localStringBuilder.append(str);
          ((TextView)localObject).setContentDescription(localStringBuilder.toString());
        }
        if (a())
        {
          localObject = (ViewGroup)paramObject.b.getParent();
          if (localObject != null) {
            ((ViewGroup)localObject).setBackgroundDrawable(this.m.getResources().getDrawable(2130839572));
          }
          paramObject.b.setVisibility(0);
          paramObject.b.setChecked(this.w.a(str));
          paramObject.b.setClickable(false);
          paramView.setOnClickListener(new ChatHistoryEmotionAdapter.1(this, str));
        }
      }
    }
    else if (paramView != null)
    {
      a(paramInt1, paramView);
    }
  }
  
  private IPicTransFile.IPicDownloadPro b(MessageForPic paramMessageForPic)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      PicDownloadInfo localPicDownloadInfo = new PicDownloadInfo();
      localPicDownloadInfo.t = paramMessageForPic.fileSizeFlag;
      int i1 = localPicDownloadInfo.t;
      boolean bool = true;
      if (i1 != 1) {
        bool = false;
      }
      i1 = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType("aiothumb", bool);
      paramMessageForPic = ((ITransFileController)((QQAppInterface)localAppRuntime).getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, i1));
      if ((paramMessageForPic != null) && ((paramMessageForPic instanceof IPicTransFile.IPicDownloadPro))) {
        return (IPicTransFile.IPicDownloadPro)paramMessageForPic;
      }
    }
    return null;
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    int i1 = paramCalendar.get(1);
    int i2 = localCalendar.get(1);
    int i3 = localCalendar.get(2);
    if ((i1 == i2) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(i2), Integer.valueOf(i3 + 1) });
  }
  
  public void a(int paramInt)
  {
    this.u = paramInt;
    this.v = AIOPhotoListAdapter.c(this.u);
  }
  
  public void a(int paramInt, View paramView)
  {
    Object localObject2 = getItem(paramInt);
    Object localObject1 = paramView.getTag();
    if (!EmotionPreviewData.class.isInstance(localObject2))
    {
      paramView = new StringBuilder();
      paramView.append("[updateView] is not AIORichMediaInfo, position:");
      paramView.append(paramInt);
      QLog.d("ChatHistoryEmotionAdapter", 2, paramView.toString());
      return;
    }
    if (!(localObject1 instanceof ChatHistoryEmotionAdapter.ContentHolder))
    {
      paramView = new StringBuilder();
      paramView.append("[updateView] is not ContentHolder, position:");
      paramView.append(paramInt);
      QLog.d("ChatHistoryEmotionAdapter", 2, paramView.toString());
      return;
    }
    localObject1 = (ChatHistoryEmotionAdapter.ContentHolder)localObject1;
    localObject2 = (EmotionPreviewData)localObject2;
    Object localObject3 = ((ChatHistoryEmotionAdapter.ContentHolder)localObject1).a;
    Object localObject4 = this.j;
    localObject4 = EmotionDataManager.a(this.m, (EmotionPreviewData)localObject2);
    if (((EmotionPreviewData)localObject2).c) {
      if (((EmotionPreviewData)localObject2).d) {
        ((URLImageView)localObject3).setURLDrawableDownListener(this);
      } else if (AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)((EmotionPreviewData)localObject2).a, 65537).toString()) == null) {
        a((MessageForPic)((EmotionPreviewData)localObject2).a);
      }
    }
    if ((localObject4 instanceof PngFrameDrawable))
    {
      PngFrameDrawable localPngFrameDrawable = (PngFrameDrawable)localObject4;
      if (localPngFrameDrawable.b() != null)
      {
        localObject4 = localPngFrameDrawable.b();
        i1 = this.n;
        ((URLImageView)localObject3).setImageBitmap(EmotionAdapter.a((Bitmap)localObject4, i1, i1));
        break label258;
      }
    }
    ((URLImageView)localObject3).setImageDrawable((Drawable)localObject4);
    label258:
    localObject3 = ((ChatHistoryEmotionAdapter.ContentHolder)localObject1).b;
    localObject1 = ((ChatHistoryEmotionAdapter.ContentHolder)localObject1).c;
    if (this.g)
    {
      if (((EmotionPreviewData)localObject2).b)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject1).setImageResource(2130847336);
        ((ImageView)localObject1).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject3).setVisibility(4);
        ((ImageView)localObject1).setImageResource(2130847333);
        ((ImageView)localObject1).setVisibility(0);
      }
    }
    else
    {
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setVisibility(4);
    }
    int i1 = paramInt / 4;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899841));
    ((StringBuilder)localObject1).append(i1 + 1);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899899));
    ((StringBuilder)localObject1).append(paramInt % 4 + 1);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899881));
    paramView.setContentDescription(((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic) {}
  
  public void a(MessageForPic paramMessageForPic)
  {
    EmotionDownGIFCallback localEmotionDownGIFCallback = new EmotionDownGIFCallback(paramMessageForPic, this.k, this);
    if (!this.t.containsKey(paramMessageForPic)) {
      this.t.put(paramMessageForPic, localEmotionDownGIFCallback);
    }
    Object localObject = b(paramMessageForPic);
    if (localObject != null)
    {
      ((IPicTransFile.IPicDownloadPro)localObject).addDownCallback(localEmotionDownGIFCallback);
      return;
    }
    localObject = ((IPicBus)QRoute.api(IPicBus.class)).createPicReq(5, 1536, 1);
    ((PicReq)localObject).a(paramMessageForPic, paramMessageForPic.getPicDownloadInfo());
    ((PicReq)localObject).a(localEmotionDownGIFCallback);
    paramMessageForPic = BaseApplicationImpl.getApplication().getRuntime();
    if ((paramMessageForPic != null) && ((paramMessageForPic instanceof QQAppInterface))) {
      ((IPicBus)QRoute.api(IPicBus.class)).launch((PicReq)localObject);
    }
  }
  
  public void a(List<MessageRecord> paramList)
  {
    this.h.addAll(paramList);
    a(false, paramList);
    b(false);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.s = paramBoolean;
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    this.t.remove(paramMessageForPic);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    int i1 = this.e;
    if (i1 == 0) {
      return;
    }
    if (paramBoolean)
    {
      this.d.clear();
      this.f = -1;
      this.q = null;
    }
    else
    {
      this.w.b(this.d, i1);
    }
    if (this.p == null)
    {
      this.p = Calendar.getInstance();
      this.p.setTimeInMillis(MessageCache.c() * 1000L);
    }
    i1 = paramList.size();
    boolean bool2 = true;
    i1 -= 1;
    for (;;)
    {
      int i3 = 0;
      if (i1 < 0) {
        break;
      }
      Object localObject2 = (MessageRecord)paramList.get(i1);
      localObject1 = new EmotionPreviewData((MessageRecord)localObject2);
      localObject2 = a(this.p, ((MessageRecord)localObject2).time);
      if (!((String)localObject2).equals(this.q))
      {
        this.q = ((String)localObject2);
        int i2 = this.f;
        if (i2 != -1)
        {
          int i4 = i2 % this.e;
          if (i4 > 0)
          {
            i2 = 0;
            while (i2 < this.e - i4)
            {
              this.d.add(c);
              i2 += 1;
            }
          }
        }
        this.f = 0;
        this.d.add(localObject2);
        i2 = i3;
        while (i2 < this.e - 1)
        {
          this.d.add(b);
          i2 += 1;
        }
      }
      this.d.add(localObject1);
      this.f += 1;
      i1 -= 1;
    }
    Object localObject1 = this.w;
    boolean bool1 = bool2;
    if (!paramBoolean) {
      if (paramList.isEmpty()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    ((AIORichExpandInfo)localObject1).a(bool1, this.e, this.d);
  }
  
  public boolean a()
  {
    return (this.s) && (this.v != -1);
  }
  
  public Object b(int paramInt)
  {
    return this.d.get(paramInt);
  }
  
  public void b()
  {
    if (this.w.a(this.d, this.e)) {
      notifyDataSetChanged();
    }
  }
  
  public void b(List<MessageRecord> paramList)
  {
    this.h = paramList;
    a(true, this.h);
    b(false);
    notifyDataSetChanged();
  }
  
  public boolean b(boolean paramBoolean)
  {
    if (paramBoolean != this.r)
    {
      this.r = paramBoolean;
      return true;
    }
    return false;
  }
  
  public int c()
  {
    return this.d.size();
  }
  
  public int d()
  {
    return c() + this.w.a();
  }
  
  public List<MessageRecord> e()
  {
    return this.h;
  }
  
  public void f()
  {
    if (!this.t.isEmpty())
    {
      Iterator localIterator = this.t.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        IPicTransFile.IPicDownloadPro localIPicDownloadPro = b((MessageForPic)localEntry.getKey());
        if (localIPicDownloadPro != null) {
          localIPicDownloadPro.removeDownCallBack((DownCallBack)localEntry.getValue());
        }
      }
    }
  }
  
  public int getCount()
  {
    int i1 = this.d.size();
    int i2 = i1;
    if (this.r)
    {
      int i3 = i1 % 4;
      i2 = i1;
      if (i3 > 0) {
        i2 = i1 + (4 - i3);
      }
      i2 += 1;
    }
    return i2;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.r) {
      return this.d.get(paramInt);
    }
    if (paramInt < this.d.size()) {
      return this.d.get(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return a;
    }
    return c;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public int getItemViewType(int paramInt)
  {
    Object localObject = getItem(paramInt);
    boolean bool = localObject instanceof MessageRecord;
    paramInt = 0;
    if (bool) {
      return 0;
    }
    if (c.equals(localObject)) {
      return 1;
    }
    if ((localObject instanceof String)) {
      return 2;
    }
    if (b.equals(localObject)) {
      return 3;
    }
    if (a.equals(localObject)) {
      paramInt = 4;
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i1 = getItemViewType(paramInt);
    Object localObject1;
    if (paramView == null) {
      localObject1 = null;
    } else {
      localObject1 = paramView.getTag();
    }
    Object localObject2;
    int i2;
    if (i1 != 0)
    {
      if (i1 != 1)
      {
        Object localObject3;
        if (i1 != 2)
        {
          if (i1 != 3)
          {
            if ((i1 == 4) && (!a.equals(localObject1)))
            {
              paramView = new ChatHistoryEmotionAdapter.FullWidthFixedViewLayout(this, this.m);
              localObject2 = this.i.inflate(2131627635, null);
              localObject3 = new FrameLayout.LayoutParams(-2, -2);
              ((FrameLayout.LayoutParams)localObject3).gravity = 17;
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              paramView.addView((View)localObject2);
              paramView.setTag(a);
            }
          }
          else if (!b.equals(localObject1))
          {
            paramView = new View(this.m);
            paramView.setMinimumHeight(this.o);
            paramView.setVisibility(4);
            paramView.setTag(b);
          }
        }
        else if (!ChatHistoryEmotionAdapter.HeaderHolder.class.isInstance(localObject1))
        {
          localObject2 = this.i.inflate(2131627636, null);
          localObject1 = new ChatHistoryEmotionAdapter.HeaderHolder(this);
          ((ChatHistoryEmotionAdapter.HeaderHolder)localObject1).a = ((TextView)((View)localObject2).findViewById(2131447246));
          ((ChatHistoryEmotionAdapter.HeaderHolder)localObject1).b = ((CheckBox)((View)localObject2).findViewById(2131436369));
          paramView = new ChatHistoryEmotionAdapter.FullWidthFixedViewLayout(this, this.m);
          localObject3 = ((View)localObject2).getLayoutParams();
          if (localObject3 != null)
          {
            ((View)localObject2).setLayoutParams(new FrameLayout.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
            paramView.setLayoutParams(new AbsListView.LayoutParams(((ViewGroup.LayoutParams)localObject3).width, ((ViewGroup.LayoutParams)localObject3).height));
          }
          ((FrameLayout)paramView).addView((View)localObject2);
          paramView.setTag(localObject1);
        }
      }
      else if (!c.equals(localObject1))
      {
        paramView = new View(this.m);
        i2 = this.n;
        paramView.setLayoutParams(new AbsListView.LayoutParams(i2, i2));
        paramView.setTag(c);
      }
    }
    else if (!ChatHistoryEmotionAdapter.ContentHolder.class.isInstance(localObject1))
    {
      if ((QLog.isColorLevel()) && (paramView != null))
      {
        paramView = (AbsListView.LayoutParams)paramView.getLayoutParams();
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("[getView] type 0 while convertView type ");
        ((StringBuilder)localObject2).append(paramView.viewType);
        QLog.d("ChatHistoryEmotionAdapter", 2, ((StringBuilder)localObject2).toString());
      }
      paramView = this.i.inflate(2131624745, null);
      i2 = this.n;
      paramView.setLayoutParams(new AbsListView.LayoutParams(i2, i2));
      localObject2 = new ChatHistoryEmotionAdapter.ContentHolder(this);
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).a = ((URLImageView)paramView.findViewById(2131440193));
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).a.setAdjustViewBounds(false);
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).b = ((ImageView)paramView.findViewById(2131440197));
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).c = ((ImageView)paramView.findViewById(2131440198));
      paramView.setTag(localObject2);
    }
    a(paramInt, paramView, i1, localObject1);
    EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
    return paramView;
  }
  
  public int getViewTypeCount()
  {
    return 5;
  }
  
  public void onLoadCancelled(View paramView, URLDrawable paramURLDrawable) {}
  
  public void onLoadFailed(View paramView, URLDrawable paramURLDrawable, Throwable paramThrowable) {}
  
  public void onLoadInterrupted(View paramView, URLDrawable paramURLDrawable, InterruptedException paramInterruptedException) {}
  
  public void onLoadProgressed(View paramView, URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(View paramView, URLDrawable paramURLDrawable)
  {
    int i1;
    try
    {
      File localFile = paramURLDrawable.getFileInLocal();
      if (localFile != null) {
        i1 = ImageUtil.i(localFile.getAbsolutePath());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i1 = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionAdapter", 2, new Object[] { "onLoadSuccessed,orientation:", Integer.valueOf(i1) });
    }
    AIOGalleryAdapter.a(paramView, paramURLDrawable, i1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */