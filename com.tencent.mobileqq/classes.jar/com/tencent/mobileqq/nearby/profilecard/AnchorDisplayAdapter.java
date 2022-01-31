package com.tencent.mobileqq.nearby.profilecard;

import afbw;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.statistics.ReportTask;
import com.tencent.mobileqq.transfile.NearbyImgDownloader;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowFollowAnchor;

public class AnchorDisplayAdapter
  extends BaseAdapter
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private String jdField_a_of_type_JavaLangString = "http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif";
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public AnchorDisplayAdapter(boolean paramBoolean, QQAppInterface paramQQAppInterface)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a(afbw paramafbw, cmd0xac5.NowFollowAnchor paramNowFollowAnchor)
  {
    paramafbw.jdField_a_of_type_TencentImOidbCmd0xac5Cmd0xac5$NowFollowAnchor = paramNowFollowAnchor;
    paramafbw.jdField_a_of_type_AndroidWidgetTextView.setText(((cmd0xac5.NowFollowAnchor)paramNowFollowAnchor.get()).bytes_nick_name.get().toStringUtf8());
    Object localObject = URLDrawable.getDrawable(paramNowFollowAnchor.bytes_head_url.get().toStringUtf8(), URLDrawable.URLDrawableOptions.obtain());
    ((URLDrawable)localObject).setTag(URLDrawableDecodeHandler.a(UIUtils.a(paramafbw.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 135.0F), UIUtils.a(paramafbw.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 135.0F), UIUtils.a(paramafbw.jdField_a_of_type_ComTencentImageURLImageView.getContext(), 4.0F)));
    ((URLDrawable)localObject).setDecodeHandler(URLDrawableDecodeHandler.b);
    paramafbw.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
    if (paramNowFollowAnchor.uint32_live_status.get() == 1)
    {
      paramafbw.jdField_a_of_type_AndroidViewView.setVisibility(0);
      try
      {
        paramNowFollowAnchor = NearbyImgDownloader.a(this.jdField_a_of_type_JavaLangString);
        localObject = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject).mPlayGifImage = true;
        paramNowFollowAnchor = URLDrawable.getDrawable(paramNowFollowAnchor, (URLDrawable.URLDrawableOptions)localObject);
        paramafbw.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(paramNowFollowAnchor);
        return;
      }
      catch (MalformedURLException paramafbw)
      {
        while (!QLog.isColorLevel()) {}
        QLog.i("AnchorDisplayAdapter", 2, "convertURL, e=" + paramafbw.toString(), paramafbw);
        return;
      }
    }
    paramafbw.jdField_b_of_type_ComTencentImageURLImageView.setImageDrawable(null);
    paramafbw.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  public void a(List paramList, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    this.jdField_a_of_type_JavaUtilList.addAll(paramList);
    this.jdField_a_of_type_Boolean = paramBoolean;
    paramList = paramString;
    if (TextUtils.isEmpty(paramString)) {
      paramList = "http://8.url.cn/huayang/resource/now/gift/ilive_animation.gif";
    }
    this.jdField_a_of_type_JavaLangString = paramList;
    if (this.b) {
      this.jdField_a_of_type_JavaUtilList.add(new cmd0xac5.NowFollowAnchor());
    }
    if (paramBoolean)
    {
      paramString = new ReportTask(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface).a("dc00899").b("grp_lbs").c("data_card");
      if (!this.b) {
        break label116;
      }
    }
    label116:
    for (paramList = "more_mylive";; paramList = "more_live")
    {
      paramString.d(paramList).a();
      return;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null)
    {
      localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(2130970464, paramViewGroup, false);
      paramView = new afbw(this);
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131366378));
      paramView.jdField_a_of_type_AndroidViewView = localView.findViewById(2131370664);
      paramView.jdField_b_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131370666));
      paramView.jdField_b_of_type_AndroidViewView = localView.findViewById(2131370667);
      paramView.c = localView.findViewById(2131370668);
      paramView.d = localView.findViewById(2131362726);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131369188));
      paramView.e = localView.findViewById(2131370663);
      paramView.f = localView.findViewById(2131370670);
      localView.setTag(paramView);
    }
    paramView = (afbw)localView.getTag();
    if (paramInt == 0)
    {
      paramView.e.setVisibility(0);
      if (paramInt != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label289;
      }
      paramView.f.setVisibility(0);
    }
    for (;;)
    {
      paramViewGroup = (cmd0xac5.NowFollowAnchor)this.jdField_a_of_type_JavaUtilList.get(paramInt);
      if (!this.b) {
        break label359;
      }
      paramView.jdField_b_of_type_AndroidViewView.setVisibility(8);
      if (paramInt != this.jdField_a_of_type_JavaUtilList.size() - 1) {
        break label301;
      }
      paramView.c.setVisibility(0);
      paramView.d.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      paramView.jdField_a_of_type_Int = 3;
      return localView;
      paramView.e.setVisibility(8);
      break;
      label289:
      paramView.f.setVisibility(8);
    }
    label301:
    paramView.c.setVisibility(8);
    paramView.d.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    a(paramView, paramViewGroup);
    if (paramViewGroup.uint32_live_status.get() == 1)
    {
      paramView.jdField_a_of_type_Int = 1;
      return localView;
    }
    paramView.jdField_a_of_type_Int = 2;
    return localView;
    label359:
    paramView.c.setVisibility(8);
    paramView.d.setVisibility(0);
    if ((this.jdField_a_of_type_Boolean) && (paramInt == this.jdField_a_of_type_JavaUtilList.size() - 1))
    {
      paramView.jdField_b_of_type_AndroidViewView.setVisibility(0);
      paramView.d.setVisibility(8);
      paramView.jdField_a_of_type_Int = 3;
    }
    for (;;)
    {
      a(paramView, paramViewGroup);
      return localView;
      paramView.jdField_b_of_type_AndroidViewView.setVisibility(8);
      paramView.d.setVisibility(0);
      if (paramViewGroup.uint32_live_status.get() == 1) {
        paramView.jdField_a_of_type_Int = 1;
      } else {
        paramView.jdField_a_of_type_Int = 2;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.AnchorDisplayAdapter
 * JD-Core Version:    0.7.0.1
 */