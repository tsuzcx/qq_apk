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
  public static final Object a;
  public static final Object b;
  public static final Object c;
  int jdField_a_of_type_Int = 4;
  private Context jdField_a_of_type_AndroidContentContext;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private AIORichExpandInfo jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo = new AIORichExpandInfo();
  private EmotionDataManager jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataManager;
  private GridView jdField_a_of_type_ComTencentWidgetGridView;
  private String jdField_a_of_type_JavaLangString = null;
  private Calendar jdField_a_of_type_JavaUtilCalendar = null;
  private HashMap<MessageForPic, EmotionDownGIFCallback> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  List<Object> jdField_a_of_type_JavaUtilList = new ArrayList();
  public boolean a;
  int jdField_b_of_type_Int = -1;
  private List<MessageRecord> jdField_b_of_type_JavaUtilList;
  private boolean jdField_b_of_type_Boolean = true;
  private int jdField_c_of_type_Int;
  private boolean jdField_c_of_type_Boolean = false;
  private int d;
  private int e = -1;
  private int f = -1;
  
  static
  {
    jdField_a_of_type_JavaLangObject = new Object();
    jdField_b_of_type_JavaLangObject = new Object();
    jdField_c_of_type_JavaLangObject = new Object();
  }
  
  public ChatHistoryEmotionAdapter(Activity paramActivity, EmotionDataManager paramEmotionDataManager, Handler paramHandler, int paramInt, GridView paramGridView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataManager = paramEmotionDataManager;
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    this.jdField_c_of_type_Int = paramInt;
    this.jdField_a_of_type_ComTencentWidgetGridView = paramGridView;
    this.jdField_a_of_type_AndroidViewLayoutInflater = paramActivity.getLayoutInflater();
    this.d = AIOUtils.b(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
  }
  
  private IPicTransFile.IPicDownloadPro a(MessageForPic paramMessageForPic)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface)))
    {
      PicDownloadInfo localPicDownloadInfo = new PicDownloadInfo();
      localPicDownloadInfo.e = paramMessageForPic.fileSizeFlag;
      int i = localPicDownloadInfo.e;
      boolean bool = true;
      if (i != 1) {
        bool = false;
      }
      i = ((IPicHelper)QRoute.api(IPicHelper.class)).getFileSizeType("aiothumb", bool);
      paramMessageForPic = ((ITransFileController)((QQAppInterface)localAppRuntime).getRuntimeService(ITransFileController.class)).findProcessor(TransFileControllerImpl.makeReceiveKey(paramMessageForPic.md5, paramMessageForPic.uuid, i));
      if ((paramMessageForPic != null) && ((paramMessageForPic instanceof IPicTransFile.IPicDownloadPro))) {
        return (IPicTransFile.IPicDownloadPro)paramMessageForPic;
      }
    }
    return null;
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
        paramObject.jdField_a_of_type_AndroidWidgetTextView.setText(str);
        Object localObject;
        if (AppSetting.d)
        {
          paramInt1 /= 4;
          localObject = paramObject.jdField_a_of_type_AndroidWidgetTextView;
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(HardCodeUtil.a(2131701865));
          localStringBuilder.append(paramInt1 + 1);
          localStringBuilder.append(HardCodeUtil.a(2131701817));
          localStringBuilder.append(str);
          ((TextView)localObject).setContentDescription(localStringBuilder.toString());
        }
        if (a())
        {
          localObject = (ViewGroup)paramObject.jdField_a_of_type_AndroidWidgetCheckBox.getParent();
          if (localObject != null) {
            ((ViewGroup)localObject).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839388));
          }
          paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setVisibility(0);
          paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setChecked(this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a(str));
          paramObject.jdField_a_of_type_AndroidWidgetCheckBox.setClickable(false);
          paramView.setOnClickListener(new ChatHistoryEmotionAdapter.1(this, str));
        }
      }
    }
    else if (paramView != null)
    {
      a(paramInt1, paramView);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object a(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  String a(Calendar paramCalendar, long paramLong)
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.setTimeInMillis(paramLong * 1000L);
    int i = paramCalendar.get(1);
    int j = localCalendar.get(1);
    int k = localCalendar.get(2);
    if ((i == j) && (paramCalendar.get(6) - localCalendar.get(6) < 7)) {
      return "7天内";
    }
    return String.format(Locale.CHINA, "%d年%d月", new Object[] { Integer.valueOf(j), Integer.valueOf(k + 1) });
  }
  
  public List<MessageRecord> a()
  {
    return this.jdField_b_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a(this.jdField_a_of_type_JavaUtilList, this.jdField_a_of_type_Int)) {
      notifyDataSetChanged();
    }
  }
  
  public void a(int paramInt)
  {
    this.e = paramInt;
    this.f = AIOPhotoListAdapter.a(this.e);
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
    Object localObject3 = ((ChatHistoryEmotionAdapter.ContentHolder)localObject1).jdField_a_of_type_ComTencentImageURLImageView;
    Object localObject4 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionDataManager;
    localObject4 = EmotionDataManager.a(this.jdField_a_of_type_AndroidContentContext, (EmotionPreviewData)localObject2);
    if (((EmotionPreviewData)localObject2).jdField_b_of_type_Boolean) {
      if (((EmotionPreviewData)localObject2).jdField_c_of_type_Boolean) {
        ((URLImageView)localObject3).setURLDrawableDownListener(this);
      } else if (AbsDownloader.getFile(URLDrawableHelper.getURL((MessageForPic)((EmotionPreviewData)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord, 65537).toString()) == null) {
        a((MessageForPic)((EmotionPreviewData)localObject2).jdField_a_of_type_ComTencentMobileqqDataMessageRecord);
      }
    }
    if ((localObject4 instanceof PngFrameDrawable))
    {
      PngFrameDrawable localPngFrameDrawable = (PngFrameDrawable)localObject4;
      if (localPngFrameDrawable.a() != null)
      {
        localObject4 = localPngFrameDrawable.a();
        i = this.jdField_c_of_type_Int;
        ((URLImageView)localObject3).setImageBitmap(EmotionAdapter.a((Bitmap)localObject4, i, i));
        break label258;
      }
    }
    ((URLImageView)localObject3).setImageDrawable((Drawable)localObject4);
    label258:
    localObject3 = ((ChatHistoryEmotionAdapter.ContentHolder)localObject1).jdField_a_of_type_AndroidWidgetImageView;
    localObject1 = ((ChatHistoryEmotionAdapter.ContentHolder)localObject1).b;
    if (this.jdField_a_of_type_Boolean)
    {
      if (((EmotionPreviewData)localObject2).jdField_a_of_type_Boolean)
      {
        ((ImageView)localObject3).setVisibility(0);
        ((ImageView)localObject1).setImageResource(2130845866);
        ((ImageView)localObject1).setVisibility(0);
      }
      else
      {
        ((ImageView)localObject3).setVisibility(4);
        ((ImageView)localObject1).setImageResource(2130845863);
        ((ImageView)localObject1).setVisibility(0);
      }
    }
    else
    {
      ((ImageView)localObject3).setVisibility(4);
      ((ImageView)localObject1).setVisibility(4);
    }
    int i = paramInt / 4;
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701823));
    ((StringBuilder)localObject1).append(i + 1);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701883));
    ((StringBuilder)localObject1).append(paramInt % 4 + 1);
    ((StringBuilder)localObject1).append(HardCodeUtil.a(2131701864));
    paramView.setContentDescription(((StringBuilder)localObject1).toString());
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic) {}
  
  public void a(MessageForPic paramMessageForPic)
  {
    EmotionDownGIFCallback localEmotionDownGIFCallback = new EmotionDownGIFCallback(paramMessageForPic, this.jdField_a_of_type_AndroidOsHandler, this);
    if (!this.jdField_a_of_type_JavaUtilHashMap.containsKey(paramMessageForPic)) {
      this.jdField_a_of_type_JavaUtilHashMap.put(paramMessageForPic, localEmotionDownGIFCallback);
    }
    Object localObject = a(paramMessageForPic);
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
    this.jdField_b_of_type_JavaUtilList.addAll(paramList);
    a(false, paramList);
    a(false);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    this.jdField_a_of_type_JavaUtilHashMap.remove(paramMessageForPic);
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean, List<MessageRecord> paramList)
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 0) {
      return;
    }
    if (paramBoolean)
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_Int = -1;
      this.jdField_a_of_type_JavaLangString = null;
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a(this.jdField_a_of_type_JavaUtilList, i);
    }
    if (this.jdField_a_of_type_JavaUtilCalendar == null)
    {
      this.jdField_a_of_type_JavaUtilCalendar = Calendar.getInstance();
      this.jdField_a_of_type_JavaUtilCalendar.setTimeInMillis(MessageCache.a() * 1000L);
    }
    i = paramList.size();
    boolean bool2 = true;
    i -= 1;
    for (;;)
    {
      int k = 0;
      if (i < 0) {
        break;
      }
      Object localObject2 = (MessageRecord)paramList.get(i);
      localObject1 = new EmotionPreviewData((MessageRecord)localObject2);
      localObject2 = a(this.jdField_a_of_type_JavaUtilCalendar, ((MessageRecord)localObject2).time);
      if (!((String)localObject2).equals(this.jdField_a_of_type_JavaLangString))
      {
        this.jdField_a_of_type_JavaLangString = ((String)localObject2);
        int j = this.jdField_b_of_type_Int;
        if (j != -1)
        {
          int m = j % this.jdField_a_of_type_Int;
          if (m > 0)
          {
            j = 0;
            while (j < this.jdField_a_of_type_Int - m)
            {
              this.jdField_a_of_type_JavaUtilList.add(jdField_c_of_type_JavaLangObject);
              j += 1;
            }
          }
        }
        this.jdField_b_of_type_Int = 0;
        this.jdField_a_of_type_JavaUtilList.add(localObject2);
        j = k;
        while (j < this.jdField_a_of_type_Int - 1)
        {
          this.jdField_a_of_type_JavaUtilList.add(jdField_b_of_type_JavaLangObject);
          j += 1;
        }
      }
      this.jdField_a_of_type_JavaUtilList.add(localObject1);
      this.jdField_b_of_type_Int += 1;
      i -= 1;
    }
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo;
    boolean bool1 = bool2;
    if (!paramBoolean) {
      if (paramList.isEmpty()) {
        bool1 = bool2;
      } else {
        bool1 = false;
      }
    }
    ((AIORichExpandInfo)localObject1).a(bool1, this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
  }
  
  public boolean a()
  {
    return (this.jdField_c_of_type_Boolean) && (this.f != -1);
  }
  
  public boolean a(boolean paramBoolean)
  {
    if (paramBoolean != this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = paramBoolean;
      return true;
    }
    return false;
  }
  
  public int b()
  {
    return a() + this.jdField_a_of_type_ComTencentMobileqqActivityAioPhotoAIORichExpandInfo.a();
  }
  
  public void b()
  {
    if (!this.jdField_a_of_type_JavaUtilHashMap.isEmpty())
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilHashMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        IPicTransFile.IPicDownloadPro localIPicDownloadPro = a((MessageForPic)localEntry.getKey());
        if (localIPicDownloadPro != null) {
          localIPicDownloadPro.removeDownCallBack((DownCallBack)localEntry.getValue());
        }
      }
    }
  }
  
  public void b(List<MessageRecord> paramList)
  {
    this.jdField_b_of_type_JavaUtilList = paramList;
    a(true, this.jdField_b_of_type_JavaUtilList);
    a(false);
    notifyDataSetChanged();
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilList.size();
    int j = i;
    if (this.jdField_b_of_type_Boolean)
    {
      int k = i % 4;
      j = i;
      if (k > 0) {
        j = i + (4 - k);
      }
      j += 1;
    }
    return j;
  }
  
  public Object getItem(int paramInt)
  {
    if (!this.jdField_b_of_type_Boolean) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (paramInt < this.jdField_a_of_type_JavaUtilList.size()) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    if (paramInt == getCount() - 1) {
      return jdField_a_of_type_JavaLangObject;
    }
    return jdField_c_of_type_JavaLangObject;
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
    if (jdField_c_of_type_JavaLangObject.equals(localObject)) {
      return 1;
    }
    if ((localObject instanceof String)) {
      return 2;
    }
    if (jdField_b_of_type_JavaLangObject.equals(localObject)) {
      return 3;
    }
    if (jdField_a_of_type_JavaLangObject.equals(localObject)) {
      paramInt = 4;
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    Object localObject1;
    if (paramView == null) {
      localObject1 = null;
    } else {
      localObject1 = paramView.getTag();
    }
    Object localObject2;
    int j;
    if (i != 0)
    {
      if (i != 1)
      {
        Object localObject3;
        if (i != 2)
        {
          if (i != 3)
          {
            if ((i == 4) && (!jdField_a_of_type_JavaLangObject.equals(localObject1)))
            {
              paramView = new ChatHistoryEmotionAdapter.FullWidthFixedViewLayout(this, this.jdField_a_of_type_AndroidContentContext);
              localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561279, null);
              localObject3 = new FrameLayout.LayoutParams(-2, -2);
              ((FrameLayout.LayoutParams)localObject3).gravity = 17;
              ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
              paramView.addView((View)localObject2);
              paramView.setTag(jdField_a_of_type_JavaLangObject);
            }
          }
          else if (!jdField_b_of_type_JavaLangObject.equals(localObject1))
          {
            paramView = new View(this.jdField_a_of_type_AndroidContentContext);
            paramView.setMinimumHeight(this.d);
            paramView.setVisibility(4);
            paramView.setTag(jdField_b_of_type_JavaLangObject);
          }
        }
        else if (!ChatHistoryEmotionAdapter.HeaderHolder.class.isInstance(localObject1))
        {
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131561280, null);
          localObject1 = new ChatHistoryEmotionAdapter.HeaderHolder(this);
          ((ChatHistoryEmotionAdapter.HeaderHolder)localObject1).jdField_a_of_type_AndroidWidgetTextView = ((TextView)((View)localObject2).findViewById(2131378615));
          ((ChatHistoryEmotionAdapter.HeaderHolder)localObject1).jdField_a_of_type_AndroidWidgetCheckBox = ((CheckBox)((View)localObject2).findViewById(2131369353));
          paramView = new ChatHistoryEmotionAdapter.FullWidthFixedViewLayout(this, this.jdField_a_of_type_AndroidContentContext);
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
      else if (!jdField_c_of_type_JavaLangObject.equals(localObject1))
      {
        paramView = new View(this.jdField_a_of_type_AndroidContentContext);
        j = this.jdField_c_of_type_Int;
        paramView.setLayoutParams(new AbsListView.LayoutParams(j, j));
        paramView.setTag(jdField_c_of_type_JavaLangObject);
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
      paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131559084, null);
      j = this.jdField_c_of_type_Int;
      paramView.setLayoutParams(new AbsListView.LayoutParams(j, j));
      localObject2 = new ChatHistoryEmotionAdapter.ContentHolder(this);
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramView.findViewById(2131372648));
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).jdField_a_of_type_ComTencentImageURLImageView.setAdjustViewBounds(false);
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131372652));
      ((ChatHistoryEmotionAdapter.ContentHolder)localObject2).b = ((ImageView)paramView.findViewById(2131372653));
      paramView.setTag(localObject2);
    }
    a(paramInt, paramView, i, localObject1);
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
    int i;
    try
    {
      File localFile = paramURLDrawable.getFileInLocal();
      if (localFile != null) {
        i = ImageUtil.d(localFile.getAbsolutePath());
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      i = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ChatHistoryEmotionAdapter", 2, new Object[] { "onLoadSuccessed,orientation:", Integer.valueOf(i) });
    }
    AIOGalleryAdapter.a(paramView, paramURLDrawable, i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.ChatHistoryEmotionAdapter
 * JD-Core Version:    0.7.0.1
 */