package com.tencent.mobileqq.nearby.now.view;

import ajjy;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView.LayoutParams;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import ascz;
import asll;
import asmr;
import asmu;
import asmv;
import asmy;
import asnc;
import asnd;
import asne;
import asnf;
import asng;
import asnh;
import asni;
import asnj;
import asnk;
import asnl;
import asnm;
import asnn;
import asno;
import asnp;
import asnq;
import asnr;
import asns;
import asnt;
import asnu;
import asnv;
import asnw;
import asnx;
import asoh;
import aspl;
import aspm;
import aspq;
import awqx;
import azyk;
import azyl;
import babr;
import bafb;
import baiw;
import bajq;
import bbmy;
import begr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mjg;
import mqq.os.MqqHandler;

public class ShortVideoCommentsView
  extends LinearLayout
  implements View.OnLayoutChangeListener, asmy
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private asll jdField_a_of_type_Asll = new asno(this);
  private asmv jdField_a_of_type_Asmv;
  private asoh jdField_a_of_type_Asoh;
  private aspl jdField_a_of_type_Aspl;
  private aspq jdField_a_of_type_Aspq;
  public QQAppInterface a;
  private Comments.Comment jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment;
  public Comments a;
  private MedalInfo jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo;
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private ShortVideoCommentsView.BottomAreaRunnable jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable;
  private ShortVideoCommentsView.FocusInputRunnable jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable;
  private HorizontalBallLoadingView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView;
  private TopicLabelListView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView;
  private String jdField_a_of_type_JavaLangString = "";
  private Map<Integer, Integer> jdField_a_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private LinearLayout jdField_b_of_type_AndroidWidgetLinearLayout;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private View jdField_c_of_type_AndroidViewView;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private int jdField_d_of_type_Int;
  private View jdField_d_of_type_AndroidViewView;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private View jdField_e_of_type_AndroidViewView;
  private TextView jdField_e_of_type_AndroidWidgetTextView;
  private boolean jdField_e_of_type_Boolean;
  private View jdField_f_of_type_AndroidViewView;
  private TextView jdField_f_of_type_AndroidWidgetTextView;
  private boolean jdField_f_of_type_Boolean;
  private View jdField_g_of_type_AndroidViewView;
  private TextView jdField_g_of_type_AndroidWidgetTextView;
  private boolean jdField_g_of_type_Boolean;
  private TextView jdField_h_of_type_AndroidWidgetTextView;
  private boolean jdField_h_of_type_Boolean;
  private TextView jdField_i_of_type_AndroidWidgetTextView;
  private boolean jdField_i_of_type_Boolean;
  private TextView jdField_j_of_type_AndroidWidgetTextView;
  private boolean jdField_j_of_type_Boolean;
  private boolean k;
  
  public ShortVideoCommentsView(Context paramContext)
  {
    super(paramContext);
    jdField_a_of_type_Int = (int)mjg.a(getContext(), 60.0F);
  }
  
  private String a(String paramString)
  {
    String str;
    if (TextUtils.isEmpty(paramString)) {
      str = "";
    }
    int m;
    do
    {
      return str;
      m = paramString.indexOf("#");
      str = paramString;
    } while (m == -1);
    paramString = paramString.split("#");
    if (m > 0) {
      return paramString[0];
    }
    return "";
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable != null) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable = new ShortVideoCommentsView.BottomAreaRunnable(this, paramInt);
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$BottomAreaRunnable);
  }
  
  private void a(boolean paramBoolean)
  {
    if (this.k) {}
    int m;
    do
    {
      return;
      this.jdField_f_of_type_Boolean = paramBoolean;
      m = b();
      if ((!this.jdField_i_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetLinearLayout != null) && (this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() > 0) && ((getContext() instanceof Activity)))
      {
        Activity localActivity = (Activity)getContext();
        int n = mjg.b(getContext());
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() <= n - bajq.a(localActivity)) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - m <= n - bajq.a(localActivity) - mjg.a(getContext(), 50.0F)))
        {
          this.jdField_i_of_type_Boolean = true;
          new asmr().h("video").i("playpage_com_exp").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ThreadManagerV2.excute(new ShortVideoCommentsView.28(this, (ascz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        }
      }
    } while (this.jdField_a_of_type_Aspq == null);
    this.jdField_a_of_type_Aspq.f(m);
  }
  
  private int b()
  {
    if ((this.jdField_a_of_type_AndroidWidgetListView != null) && (this.jdField_a_of_type_AndroidWidgetListView.getChildCount() > 0))
    {
      View localView = this.jdField_a_of_type_AndroidWidgetListView.getChildAt(0);
      int m = -localView.getTop();
      this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(this.jdField_a_of_type_AndroidWidgetListView.getFirstVisiblePosition()), Integer.valueOf(localView.getHeight()));
      int n = 0;
      for (;;)
      {
        i1 = m;
        if (n >= this.jdField_a_of_type_AndroidWidgetListView.getFirstVisiblePosition()) {
          break;
        }
        i1 = m;
        if (this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(n)) != null) {
          i1 = m + ((Integer)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(n))).intValue();
        }
        n += 1;
        m = i1;
      }
    }
    int i1 = 0;
    return i1;
  }
  
  private void g(Comments.Comment paramComment)
  {
    int m = 0;
    for (;;)
    {
      if (m < this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.size())
      {
        if (((Comments.Comment)this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.get(m)).jdField_a_of_type_Int != 2) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.add(m, paramComment);
        }
      }
      else
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.contains(paramComment)) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.add(paramComment);
        }
        this.jdField_a_of_type_Asmv.notifyDataSetChanged();
        paramComment = this.jdField_j_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder().append("(");
        Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
        long l = localComments.jdField_a_of_type_Long + 1L;
        localComments.jdField_a_of_type_Long = l;
        paramComment.setText(String.valueOf(l) + ")");
        if (this.jdField_a_of_type_Aspq != null) {
          this.jdField_a_of_type_Aspq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
        }
        s();
        if ((getContext() instanceof Activity))
        {
          paramComment = (Activity)getContext();
          mjg.b(getContext());
          postDelayed(new ShortVideoCommentsView.18(this), 100L);
        }
        return;
      }
      m += 1;
    }
  }
  
  private void h(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.remove(paramComment);
    this.jdField_a_of_type_Asmv.notifyDataSetChanged();
    paramComment = this.jdField_j_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder().append("(");
    Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
    long l = localComments.jdField_a_of_type_Long - 1L;
    localComments.jdField_a_of_type_Long = l;
    paramComment.setText(String.valueOf(l) + ")");
    if (this.jdField_a_of_type_Aspq != null) {
      this.jdField_a_of_type_Aspq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
    }
  }
  
  private void i(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Aspl.b(paramComment);
  }
  
  private void j(Comments.Comment paramComment)
  {
    String str = getResources().getString(2131630959);
    babr.a(getContext(), 232, null, str, new asnq(this, paramComment), new asnr(this)).show();
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new asnv(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new asnw(this));
    q();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new asnx(this));
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(new asnd(this));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new asne(this));
    this.jdField_a_of_type_AndroidWidgetListView.setLongClickable(true);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new asnf(this));
  }
  
  private void r()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Aspl.b();
  }
  
  private void s()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment = null;
    this.jdField_a_of_type_AndroidWidgetEditText.setText("");
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
    if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
    }
    for (;;)
    {
      j();
      return;
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(getContext().getResources().getString(2131630958));
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable != null) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable);
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable = new ShortVideoCommentsView.FocusInputRunnable(this, System.currentTimeMillis());
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable, 100L);
  }
  
  private void u()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.isEmpty()) || (this.jdField_a_of_type_Asmv.jdField_a_of_type_Boolean)) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && ((this.jdField_b_of_type_AndroidWidgetTextView.getText() == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getText().length() == 0)))
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
  }
  
  public View a()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131495303, this, true);
    this.jdField_b_of_type_Int = (mjg.b(getContext()) / 3);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new asnl(this));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131303930));
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())) {
      this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new asnp(this));
    }
    this.jdField_a_of_type_Asmv = new asmv(getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.jdField_a_of_type_Aspl, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131495302, this, false);
    this.jdField_a_of_type_Asoh.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Asoh.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131306063));
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView = ((ImageDisplayView)this.jdField_a_of_type_AndroidViewView.findViewById(2131302253));
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView = ((OperationView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305433));
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a();
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)this.jdField_a_of_type_AndroidViewView.findViewById(2131305472));
    Object localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).height = mjg.b(this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    ((FrameLayout.LayoutParams)localObject).width = mjg.a(this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.requestLayout();
    this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new asns(this));
    label596:
    float f2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 6)
    {
      this.jdField_a_of_type_Asoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
      this.jdField_a_of_type_Aspq = this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a();
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131495304, this, false);
      this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131309267);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312553));
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView = ((TopicLabelListView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312563));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312550));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312361));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312436));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312329));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int != 6) {
        break label1292;
      }
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312306));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131495294, this, false);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131312282));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      int m = bajq.a((Activity)this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
      float f1 = mjg.b(this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()) - m;
      f2 = mjg.a(this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 4)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#000000"));
        localObject = new AbsListView.LayoutParams(-1, -1);
        ((AbsListView.LayoutParams)localObject).width = ((int)f2);
        ((AbsListView.LayoutParams)localObject).height = ((int)f1);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.requestLayout();
      }
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_f_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 1)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 6) {
          break label1312;
        }
        localObject = LayoutInflater.from(getContext()).inflate(2131495299, this.jdField_b_of_type_AndroidWidgetLinearLayout, true);
        label859:
        this.jdField_a_of_type_Aspq.a((View)localObject);
        this.jdField_a_of_type_Asoh.jdField_a_of_type_AndroidViewView = ((View)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 6)
        {
          this.jdField_a_of_type_Aspq.d();
          this.jdField_c_of_type_AndroidViewView.findViewById(2131309265).setVisibility(8);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 6) {
        break label1344;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView, (int)f2, -2);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidViewView);
      this.jdField_f_of_type_AndroidViewView.findViewById(2131311749).setVisibility(0);
      label974:
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Asmv);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4) {
        break label1384;
      }
      g();
      this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new asnt(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131313326);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(new asnu(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298100));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131303761));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131300151));
      p();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131309648));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131303212));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131298048));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131309602));
      j();
      this.jdField_g_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131313327);
      return this.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4)
      {
        this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(0);
        this.jdField_a_of_type_Asoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
      }
      this.jdField_a_of_type_Asoh.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Asoh.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      break;
      label1292:
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131312305));
      break label596;
      label1312:
      localObject = LayoutInflater.from(getContext()).inflate(2131495299, (ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131304068), true);
      break label859;
      label1344:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView, (int)f2, -2);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidViewView);
      break label974;
      label1384:
      asmu.a(this.jdField_a_of_type_Asoh, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.l, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.k);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131495289, null, false));
      localObject = new AbsListView.LayoutParams(-1, (int)mjg.a(getContext(), 50.0F));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView = ((HorizontalBallLoadingView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131307364));
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Aspl.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 300) || (paramInt1 == 301)) {
      a("", "");
    }
    do
    {
      do
      {
        return;
      } while (paramInt1 != 302);
      if (QLog.isColorLevel()) {
        QLog.d("nearby.bindphone", 2, "shortVideoComments onActivityResult, requestCode=" + paramInt1 + ", resultCode=" + paramInt2);
      }
    } while (paramInt2 != -1);
  }
  
  public void a(asoh paramasoh, VideoData paramVideoData)
  {
    this.jdField_a_of_type_Asoh = paramasoh;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_c_of_type_Boolean = false;
    e();
    a();
    a(null, 0);
    h();
    d();
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    String str2 = "";
    String str1 = "";
    String str4 = "";
    String str3 = "";
    localObject4 = str2;
    localObject5 = str1;
    localObject6 = str4;
    localObject7 = str3;
    localObject1 = str2;
    localObject8 = str1;
    localObject2 = str4;
    localObject3 = str3;
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null)
      {
        localObject1 = str2;
        localObject8 = str1;
        localObject2 = str4;
        localObject3 = str3;
        localObject6 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.f + "";
        localObject1 = str2;
        localObject8 = str1;
        localObject2 = localObject6;
        localObject3 = str3;
        localObject7 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_e_of_type_Int + "";
        localObject1 = str2;
        localObject8 = str1;
        localObject2 = localObject6;
        localObject3 = localObject7;
        localObject4 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long + "";
        localObject1 = localObject4;
        localObject8 = str1;
        localObject2 = localObject6;
        localObject3 = localObject7;
        localObject5 = String.valueOf(BaseApplicationImpl.getApplication().getSharedPreferences("self_info" + paramQQAppInterface.getCurrentAccountUin(), 4).getInt("charm_level", 0));
      }
      localObject1 = localObject4;
      localObject8 = localObject5;
      localObject2 = localObject6;
      localObject3 = localObject7;
      awqx.b(paramQQAppInterface, "dc00899", "grp_lbs", (String)localObject4, "video", paramString, 0, 0, (String)localObject5, (String)localObject6, (String)localObject7, "");
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        localObject4 = localObject1;
        localObject5 = localObject8;
        localObject6 = localObject2;
        localObject7 = localObject3;
        if (QLog.isColorLevel())
        {
          QLog.e("nearby.bindphone", 2, "reportBindPhoneAction: exp=" + paramQQAppInterface.toString());
          localObject4 = localObject1;
          localObject5 = localObject8;
          localObject6 = localObject2;
          localObject7 = localObject3;
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "reportBindPhoneAction: action=" + paramString + ", toUin=" + (String)localObject4 + ", gender=" + (String)localObject6 + ", age=" + (String)localObject7 + ", level=" + (String)localObject5);
    }
  }
  
  public void a(Comments.Comment paramComment)
  {
    if (paramComment != null) {}
    new asmr().h("video").i("playpage_com_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManagerV2.excute(new ShortVideoCommentsView.19(this, (ascz)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (paramComment != null)
    {
      if (paramInt != 10003) {
        break label70;
      }
      a(getContext().getResources().getString(2131630965));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      h(paramComment);
      new asmr().h("video").i("playpage_com_fail").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      label70:
      if (paramInt == 10009) {
        b(paramString);
      } else {
        a(getContext().getResources().getString(2131630967));
      }
    }
  }
  
  public void a(Comments paramComments)
  {
    this.jdField_a_of_type_Asmv.jdField_a_of_type_Boolean = false;
    if ((paramComments.jdField_a_of_type_Long == 0L) && (paramComments.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Boolean = paramComments.jdField_a_of_type_Boolean;
      if ((paramComments.jdField_a_of_type_JavaUtilList != null) && (paramComments.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.addAll(paramComments.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_Asmv.notifyDataSetChanged();
      }
      this.jdField_b_of_type_Boolean = paramComments.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_j_of_type_AndroidWidgetTextView.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long) + ")");
      if (this.jdField_a_of_type_Aspq != null) {
        this.jdField_a_of_type_Aspq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long = paramComments.jdField_a_of_type_Long;
    }
  }
  
  public void a(Comments paramComments, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4) {
      this.jdField_a_of_type_Aspl.a();
    }
  }
  
  public void a(String paramString)
  {
    if (getContext() != null) {
      bbmy.a(getContext(), 0, paramString, 1).a();
    }
  }
  
  public void a(String paramString1, String paramString2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) || (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)) {
      a(0);
    }
    this.jdField_g_of_type_Boolean = true;
    if ((!TextUtils.isEmpty(paramString1)) && (this.jdField_a_of_type_AndroidWidgetEditText != null))
    {
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(paramString1);
      this.jdField_a_of_type_JavaLangString = paramString1;
      if ((TextUtils.isEmpty(paramString2)) || (this.jdField_a_of_type_AndroidWidgetTextView == null)) {
        break label145;
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString2);
    }
    for (;;)
    {
      if (this.jdField_c_of_type_Boolean) {
        i();
      }
      return;
      if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.w("ShortVideoComments", 2, "onPermissionGranted text ie empty! etinput use defualt hint ");
      }
      this.jdField_a_of_type_JavaLangString = getContext().getResources().getString(2131630958);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
      break;
      label145:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ShortVideoComments", 2, "onPermissionGranted btnText ie empty! btnSend use defualt text ");
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131630966));
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Aspl.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(Comments.Comment paramComment)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.contains(paramComment))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.remove(paramComment);
      this.jdField_a_of_type_Asmv.notifyDataSetChanged();
      paramComment = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
      paramComment.jdField_a_of_type_Long -= 1L;
      this.jdField_j_of_type_AndroidWidgetTextView.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long) + ")");
      if (this.jdField_a_of_type_Aspq != null) {
        this.jdField_a_of_type_Aspq.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
      }
    }
  }
  
  public void b(String paramString)
  {
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    if (QLog.isColorLevel()) {
      QLog.d("nearby.bindphone", 2, "shortVideoComments showBindPhone, tip=" + paramString + ", activity=" + localBaseActivity);
    }
    if ((!TextUtils.isEmpty(paramString)) && (localBaseActivity != null))
    {
      babr.a(localBaseActivity, paramString, 2131625035, 2131633390, new asnm(this, localBaseActivity), new asnn(this)).show();
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "playpage_phone_exp");
    }
  }
  
  public boolean b()
  {
    return (this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (!this.jdField_a_of_type_Aspq.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Aspq.jdField_b_of_type_Boolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Asmv.jdField_a_of_type_Boolean = true;
  }
  
  public void c(Comments.Comment paramComment)
  {
    begr localbegr = begr.a(getContext());
    localbegr.a(ajjy.a(2131648275), 1);
    localbegr.c(2131625035);
    localbegr.a(new asng(this, paramComment, localbegr));
    localbegr.show();
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo == null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "initLocationView: lbsInfo null!");
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(8);
    }
    LocationInfo localLocationInfo;
    do
    {
      return;
      localLocationInfo = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "initLocationView:" + localLocationInfo.toString());
      }
    } while ((localLocationInfo.isCityEmpty()) && (localLocationInfo.isNameEmpty()));
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    String str2 = localLocationInfo.getName();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = localLocationInfo.getCity();
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setText(str1);
    if ((TextUtils.isEmpty(localLocationInfo.getName())) || (localLocationInfo.name.endsWith(ajjy.a(2131648293))))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 6)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844609, 0, 0, 0);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 6)
    {
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130844546, 0, 0, 0);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(new asnc(this, localLocationInfo));
  }
  
  public void d(Comments.Comment paramComment)
  {
    begr localbegr = begr.a(getContext());
    localbegr.a(ajjy.a(2131648279), 1);
    localbegr.c(2131625035);
    localbegr.a(new asnh(this, paramComment, localbegr));
    localbegr.show();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments = new Comments();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Aspl = new aspm(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    this.jdField_c_of_type_Int = ((int)(mjg.a(getContext()) - mjg.a(getContext(), 85.0F)));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(mjg.a(getContext(), 12.0F));
  }
  
  public void e(Comments.Comment paramComment)
  {
    begr localbegr = begr.a(getContext());
    localbegr.a(ajjy.a(2131648262), 1);
    localbegr.a(ajjy.a(2131648265), 1);
    localbegr.c(2131625035);
    localbegr.a(new asni(this, paramComment, localbegr));
    localbegr.show();
  }
  
  public void f()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      a(0);
      return;
    }
    a(1);
  }
  
  public void f(Comments.Comment paramComment)
  {
    Context localContext = getContext();
    if ((paramComment.c > 0L) && ((localContext instanceof BaseActivity)))
    {
      Bundle localBundle = new azyl().a(paramComment.jdField_a_of_type_JavaLangString).a();
      azyk.a((BaseActivity)localContext, 0L, paramComment.c + "", null, 20006, "", localBundle);
      return;
    }
    bbmy.a(localContext, 2, ajjy.a(2131648240), 0).a();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131300051));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new asnj(this));
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
  }
  
  public void h()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a()))
    {
      this.jdField_c_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    String str = "";
    Object localObject = str;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString != null)
    {
      localObject = str;
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString.isEmpty()) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_JavaLangString.replace("\n", "").replace("\r", "").trim();
      }
    }
    localObject = a((String)localObject);
    localObject = baiw.b(getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Aslp, (String)localObject);
    label204:
    long l;
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "topicTitle is null or the length is 0");
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c) {
        break label307;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(new asnk(this));
      l = NetConnInfoCenter.getServerTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_e_of_type_Long * 1000L;
      if (l >= 0L) {
        break label534;
      }
      localObject = "1分钟前";
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(8);
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((localObject instanceof SpannableString)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setMovementMethod(LinkMovementMethod.getInstance());
      }
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break;
      label307:
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Long == this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int != 4))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648255));
        this.jdField_h_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648248));
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(0);
        str = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_JavaLangString;
        localObject = str;
        if (str != null)
        {
          localObject = str;
          if (str.length() > 6)
          {
            localObject = str.substring(0, 6);
            localObject = (String)localObject + "...";
          }
        }
        this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        break label204;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText(ajjy.a(2131648283));
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      str = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.h;
      localObject = str;
      if (str != null)
      {
        localObject = str;
        if (str.length() > 6)
        {
          localObject = str.substring(0, 6);
          localObject = (String)localObject + "...";
        }
      }
      this.jdField_g_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      break label204;
      label534:
      if (l < 3600000L) {
        localObject = l / 60L / 1000L + 1L + ajjy.a(2131648257);
      } else if (l < 86400000L) {
        localObject = l / 60L / 60L / 1000L + ajjy.a(2131648304);
      } else if (l < 31536000000L) {
        localObject = l / 24L / 60L / 60L / 1000L + ajjy.a(2131648264);
      } else {
        localObject = l / 365L / 24L / 60L / 60L / 1000L + ajjy.a(2131648250);
      }
    }
  }
  
  public void i()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    if ((!this.jdField_d_of_type_Boolean) && (getContext() != null))
    {
      InputMethodManager localInputMethodManager = (InputMethodManager)getContext().getSystemService("input_method");
      this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken();
      localInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 0);
      this.jdField_d_of_type_Boolean = true;
    }
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
  }
  
  public void j()
  {
    if (this.jdField_a_of_type_AndroidWidgetEditText == null) {}
    do
    {
      return;
      if ((this.jdField_d_of_type_Boolean) && (getContext() != null))
      {
        ((InputMethodManager)getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
        this.jdField_d_of_type_Boolean = false;
      }
      this.jdField_h_of_type_Boolean = false;
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable == null);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewShortVideoCommentsView$FocusInputRunnable);
  }
  
  public void k()
  {
    j();
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetListView.setSelection(0);
    this.jdField_d_of_type_Int = 0;
    ThreadManager.getUIHandler().postDelayed(new ShortVideoCommentsView.22(this), 10L);
  }
  
  public void l()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_h_of_type_Boolean = true;
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      i();
      t();
      return;
    }
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    u();
    postDelayed(new ShortVideoCommentsView.23(this), 100L);
    postDelayed(new ShortVideoCommentsView.24(this), 200L);
  }
  
  public void m()
  {
    if (this.jdField_g_of_type_Boolean)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
    }
    for (;;)
    {
      postDelayed(new ShortVideoCommentsView.25(this), 100L);
      postDelayed(new ShortVideoCommentsView.26(this), 200L);
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData != null) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4)) {
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      }
      u();
    }
  }
  
  public void n()
  {
    this.jdField_b_of_type_AndroidViewView.addOnLayoutChangeListener(this);
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4) {
      a("", "");
    }
  }
  
  public void o()
  {
    j();
    this.jdField_b_of_type_AndroidViewView.removeOnLayoutChangeListener(this);
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    j();
    this.jdField_a_of_type_Aspl.c();
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_Asmv != null) {
      this.jdField_a_of_type_Asmv.a(this.jdField_e_of_type_Boolean);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0))
    {
      if (paramInt8 - paramInt4 <= this.jdField_b_of_type_Int) {
        break label53;
      }
      ThreadManager.getUIHandler().post(new ShortVideoCommentsView.29(this));
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 0) {
        this.jdField_d_of_type_Int = b();
      }
      return;
      label53:
      if (paramInt4 - paramInt8 > this.jdField_b_of_type_Int) {
        ThreadManager.getUIHandler().post(new ShortVideoCommentsView.30(this));
      }
    }
  }
  
  protected void onWindowVisibilityChanged(int paramInt)
  {
    super.onWindowVisibilityChanged(paramInt);
    if (paramInt == 0)
    {
      n();
      return;
    }
    o();
  }
  
  public void setVideoData(VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView
 * JD-Core Version:    0.7.0.1
 */