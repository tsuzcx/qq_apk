package dov.com.tencent.biz.qqstory.takevideo.sendpanel;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.armap.INonMainProcAvatarLoader;
import com.tencent.mobileqq.avatar.api.IQQNonMainProcAvatarLoaderApi;
import com.tencent.mobileqq.drawable.EmptyDrawable;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richmedia.capture.util.CaptureReportUtil;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QuickSendProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.RecentDynamicAvatarView;
import dov.com.qq.im.ae.report.AEBaseDataReporter;
import dov.com.qq.im.ae.report.AEBaseReportParam;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.editipc.PeakIpcController;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoPartManager;
import java.net.URL;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class SendPanelAdapter
  extends BaseAdapter
  implements View.OnClickListener
{
  private int jdField_a_of_type_Int;
  private Context jdField_a_of_type_AndroidContentContext;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private INonMainProcAvatarLoader jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader;
  private IHeaderUpdateListener jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelIHeaderUpdateListener;
  private SendPanelPart jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart;
  private List<SendPanelItemInfo> jdField_a_of_type_JavaUtilList;
  private ConcurrentHashMap<Integer, URLDrawable> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private INonMainProcAvatarLoader b;
  private INonMainProcAvatarLoader c;
  private INonMainProcAvatarLoader d;
  
  public SendPanelAdapter(Context paramContext, IHeaderUpdateListener paramIHeaderUpdateListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelIHeaderUpdateListener = paramIHeaderUpdateListener;
    this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.c();
    this.jdField_a_of_type_Int = AIOUtils.a(40.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
    c();
  }
  
  public static Drawable a(String paramString, int paramInt1, int paramInt2)
  {
    EmptyDrawable localEmptyDrawable = new EmptyDrawable(Color.rgb(214, 214, 214), paramInt1, paramInt2);
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(paramString, localEmptyDrawable, localEmptyDrawable);
        if (localURLDrawable.getStatus() != 1) {
          localURLDrawable.downloadImediatly();
        }
        return localURLDrawable;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("SendPanelAdapter", 2, "getIconDrawable Exception, coverUrl=" + paramString, localException);
        }
      }
    }
    return localEmptyDrawable;
  }
  
  private SendPanelItemInfo a(String paramString, int paramInt1, int paramInt2)
  {
    if ((!TextUtils.isEmpty(paramString)) && (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        SendPanelItemInfo localSendPanelItemInfo = (SendPanelItemInfo)localIterator.next();
        if ((!TextUtils.isEmpty(localSendPanelItemInfo.jdField_a_of_type_JavaLangString)) && (paramString.equals(localSendPanelItemInfo.jdField_a_of_type_JavaLangString)) && (paramInt1 == localSendPanelItemInfo.jdField_a_of_type_Int))
        {
          localSendPanelItemInfo.jdField_b_of_type_Int = paramInt2;
          if (localSendPanelItemInfo.jdField_b_of_type_Int == 1) {
            localSendPanelItemInfo.jdField_b_of_type_Boolean = true;
          }
          return localSendPanelItemInfo;
        }
      }
    }
    return null;
  }
  
  private void a(SendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder == null) || (paramSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "updateStatusView fail");
      }
    }
    do
    {
      return;
      paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setStatus(paramSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int);
    } while (paramSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int != 1);
    paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setProgress(paramSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_c_of_type_Int);
  }
  
  private void a(String paramString, int paramInt1, int paramInt2, RecentDynamicAvatarView paramRecentDynamicAvatarView, int paramInt3)
  {
    if (FileUtils.b(paramString))
    {
      paramString = ShortVideoUtils.getThumbUrl(paramString);
      if (paramString == null) {
        break label57;
      }
      paramString = a(paramString.toString(), paramInt1, paramInt2);
      if ((paramString instanceof URLDrawable)) {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(paramInt3), (URLDrawable)paramString);
      }
      paramRecentDynamicAvatarView.setImageDrawable(paramString);
    }
    label57:
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SendPanelAdapter", 2, "url  is null ");
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 1);
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a();
    this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(new SendPanelAdapter.1(this));
    this.b = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 4);
    this.b.a();
    this.b.a(new SendPanelAdapter.2(this));
    this.c = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 113);
    this.c.a();
    this.c.a(new SendPanelAdapter.3(this));
    this.d = ((IQQNonMainProcAvatarLoaderApi)QRoute.api(IQQNonMainProcAvatarLoaderApi.class)).getNonMainAppHeadLoader(this.jdField_a_of_type_AndroidContentContext, 101);
    this.d.a();
    this.d.a(new SendPanelAdapter.4(this));
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader != null) {
      this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.b();
    }
    if (this.b != null) {
      this.b.b();
    }
    if (this.d != null) {
      this.d.b();
    }
    a(false);
  }
  
  public void a(int paramInt, SendPanelAdapter.SendPanelViewHolder paramSendPanelViewHolder)
  {
    if ((paramSendPanelViewHolder == null) || (paramSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "bindData fail viewHolder");
      }
      return;
    }
    SendPanelItemInfo localSendPanelItemInfo = paramSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo;
    if ((localSendPanelItemInfo.jdField_a_of_type_AndroidGraphicsBitmap != null) && (!localSendPanelItemInfo.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled())) {
      paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap(localSendPanelItemInfo.jdField_a_of_type_AndroidGraphicsBitmap);
    }
    label313:
    for (;;)
    {
      paramSendPanelViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(localSendPanelItemInfo.jdField_c_of_type_JavaLangString);
      paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setTag(paramSendPanelViewHolder);
      paramSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView.setOnClickListener(this);
      a(paramSendPanelViewHolder);
      return;
      Object localObject;
      if (!TextUtils.isEmpty(localSendPanelItemInfo.d))
      {
        localObject = (URLDrawable)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(Integer.valueOf(paramInt));
        if (localObject != null) {
          paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageDrawable((Drawable)localObject);
        } else {
          a(localSendPanelItemInfo.d, this.jdField_a_of_type_Int, this.jdField_a_of_type_Int, paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView, paramInt);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_AndroidGraphicsBitmap;
        if ((localSendPanelItemInfo.jdField_a_of_type_Int == 0) || (localSendPanelItemInfo.jdField_a_of_type_Int == 1000) || (localSendPanelItemInfo.jdField_a_of_type_Int == 1004)) {
          localObject = this.jdField_a_of_type_ComTencentMobileqqArmapINonMainProcAvatarLoader.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
        }
        for (;;)
        {
          if (localObject == null) {
            break label313;
          }
          paramSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView.setImageBitmap((Bitmap)localObject);
          break;
          if (localSendPanelItemInfo.jdField_a_of_type_Int == 1)
          {
            if (localSendPanelItemInfo.jdField_c_of_type_Boolean) {
              localObject = this.c.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
            } else {
              localObject = this.b.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
            }
          }
          else if (localSendPanelItemInfo.jdField_a_of_type_Int == 3000) {
            localObject = this.d.a(localSendPanelItemInfo.jdField_a_of_type_JavaLangString, true);
          }
        }
      }
    }
  }
  
  public void a(int paramInt, SendPanelItemInfo paramSendPanelItemInfo)
  {
    if ((paramInt < 0) || (this.jdField_a_of_type_JavaUtilList == null) || (paramInt > this.jdField_a_of_type_JavaUtilList.size()) || (paramSendPanelItemInfo == null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onUpdate return");
      }
      return;
    }
    this.jdField_a_of_type_JavaUtilList.set(paramInt, paramSendPanelItemInfo);
  }
  
  public void a(SendPanelPart paramSendPanelPart)
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart = paramSendPanelPart;
  }
  
  public void a(List<SendPanelItemInfo> paramList)
  {
    if (paramList == null) {
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "setData list is empty");
      }
    }
    do
    {
      return;
      if ((this.jdField_a_of_type_JavaUtilList == null) || (!paramList.isEmpty())) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("SendPanelAdapter", 2, "setData do not need refresh");
    return;
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SendPanelAdapter", 2, "onEditUpdate");
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Object localObject = (SendPanelItemInfo)this.jdField_a_of_type_JavaUtilList.get(0);
      if ((TextUtils.isEmpty(((SendPanelItemInfo)localObject).e)) && (TextUtils.isEmpty(((SendPanelItemInfo)localObject).g))) {
        return;
      }
      if ((paramBoolean) && (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart != null)) {
        CaptureReportUtil.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.a);
      }
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((SendPanelItemInfo)((Iterator)localObject).next()).a();
      }
    }
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0)) {
      return !TextUtils.isEmpty(((SendPanelItemInfo)this.jdField_a_of_type_JavaUtilList.get(0)).e);
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap != null) {
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.clear();
    }
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return this.jdField_a_of_type_JavaUtilList.size();
    }
    return 0;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilList != null) {
      return (SendPanelItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      try
      {
        long l = Long.parseLong(((SendPanelItemInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_JavaLangString);
        return l;
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SendPanelAdapter", 2, "getItemId exception = " + localException.getMessage());
        }
      }
    }
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    SendPanelItemInfo localSendPanelItemInfo = (SendPanelItemInfo)getItem(paramInt);
    SendPanelAdapter.SendPanelViewHolder localSendPanelViewHolder;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131563017, null);
      localSendPanelViewHolder = new SendPanelAdapter.SendPanelViewHolder(this);
      localSendPanelViewHolder.jdField_a_of_type_ComTencentWidgetRecentDynamicAvatarView = ((RecentDynamicAvatarView)paramView.findViewById(2131368603));
      localSendPanelViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131372115));
      localSendPanelViewHolder.jdField_a_of_type_ComTencentMobileqqWidgetQuickSendProgressView = ((QuickSendProgressView)paramView.findViewById(2131372587));
      localSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = localSendPanelItemInfo;
      a(paramInt, localSendPanelViewHolder);
      paramView.setTag(localSendPanelViewHolder);
    }
    for (;;)
    {
      EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
      return paramView;
      localSendPanelViewHolder = (SendPanelAdapter.SendPanelViewHolder)paramView.getTag();
      localSendPanelViewHolder.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = localSendPanelItemInfo;
      a(paramInt, localSendPanelViewHolder);
    }
  }
  
  public void onClick(View paramView)
  {
    Object localObject1;
    if ((paramView.getTag() instanceof SendPanelAdapter.SendPanelViewHolder))
    {
      localObject1 = (SendPanelAdapter.SendPanelViewHolder)paramView.getTag();
      if (((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo != null) {
        break label48;
      }
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick itemInfo is null");
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label48:
      if (QLog.isColorLevel()) {
        QLog.d("SendPanelAdapter", 2, "onClick operateStatus = " + ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int);
      }
      SendPanelItemInfo localSendPanelItemInfo;
      switch (((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_b_of_type_Int)
      {
      default: 
        break;
      case 0: 
        if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719522), 0).a();
        }
        else
        {
          if (!TextUtils.isEmpty(((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.g))
          {
            localSendPanelItemInfo = a(((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, 1);
            Object localObject2;
            int i;
            if (localSendPanelItemInfo != null)
            {
              ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = localSendPanelItemInfo;
              a((SendPanelAdapter.SendPanelViewHolder)localObject1);
              if (localSendPanelItemInfo.jdField_a_of_type_Boolean) {
                PeakIpcController.a(localSendPanelItemInfo.e, localSendPanelItemInfo.f, localSendPanelItemInfo, SendPanelManager.a().jdField_a_of_type_JavaLangString, SendPanelManager.a().a());
              }
            }
            else
            {
              if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart != null) {
                CaptureReportUtil.c(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.a, localSendPanelItemInfo);
              }
              localObject2 = AEBaseDataReporter.a();
              localObject1 = ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.g;
              if (localSendPanelItemInfo != null) {
                break label355;
              }
              i = -1;
              ((AEBaseDataReporter)localObject2).a((String)localObject1, i);
              localObject2 = new StringBuilder().append("【OnClick】messageType:");
              if (localSendPanelItemInfo != null) {
                break label364;
              }
            }
            for (localObject1 = "-1";; localObject1 = Integer.valueOf(localSendPanelItemInfo.jdField_a_of_type_Int))
            {
              AEQLog.b("SendPanelAdapter", localObject1);
              break;
              PeakIpcController.a(localSendPanelItemInfo.e, localSendPanelItemInfo, SendPanelManager.a().jdField_a_of_type_JavaLangString, SendPanelManager.a().a());
              break label243;
              i = localSendPanelItemInfo.jdField_a_of_type_Int;
              break label282;
            }
          }
          AEBaseReportParam.a().c();
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.a.a(20, ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo);
          this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.a.d();
        }
        break;
      case 1: 
        localSendPanelItemInfo = a(((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, 0);
        if (localSendPanelItemInfo != null)
        {
          ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = localSendPanelItemInfo;
          a((SendPanelAdapter.SendPanelViewHolder)localObject1);
          PeakIpcController.a(localSendPanelItemInfo);
        }
        if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart != null) {
          CaptureReportUtil.b(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.a, localSendPanelItemInfo);
        }
        break;
      case 2: 
        label243:
        if (!NetworkUtil.g(this.jdField_a_of_type_AndroidContentContext))
        {
          QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getString(2131719522), 0).a();
        }
        else
        {
          localSendPanelItemInfo = a(((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_JavaLangString, ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo.jdField_a_of_type_Int, 1);
          if (localSendPanelItemInfo != null)
          {
            ((SendPanelAdapter.SendPanelViewHolder)localObject1).jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelItemInfo = localSendPanelItemInfo;
            a((SendPanelAdapter.SendPanelViewHolder)localObject1);
            PeakIpcController.b(localSendPanelItemInfo);
          }
          if (this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart != null) {
            CaptureReportUtil.a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoSendpanelSendPanelPart.a, localSendPanelItemInfo);
          }
        }
        label282:
        label355:
        label364:
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.sendpanel.SendPanelAdapter
 * JD-Core Version:    0.7.0.1
 */