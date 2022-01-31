package com.tencent.mobileqq.nearby.now.view;

import alud;
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
import auul;
import avcz;
import aveg;
import avej;
import avek;
import aven;
import aver;
import aves;
import avet;
import aveu;
import avev;
import avew;
import avex;
import avey;
import avez;
import avfa;
import avfb;
import avfc;
import avfd;
import avfe;
import avff;
import avfg;
import avfh;
import avfi;
import avfj;
import avfk;
import avfl;
import avfm;
import avfw;
import avha;
import avhb;
import avhf;
import azqs;
import bddf;
import bddg;
import bdgm;
import bdjz;
import bdnu;
import bdoo;
import bhuf;
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
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;
import mww;

public class ShortVideoCommentsView
  extends LinearLayout
  implements View.OnLayoutChangeListener, aven
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
  private avcz jdField_a_of_type_Avcz = new avfd(this);
  private avek jdField_a_of_type_Avek;
  private avfw jdField_a_of_type_Avfw;
  private avha jdField_a_of_type_Avha;
  private avhf jdField_a_of_type_Avhf;
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
    jdField_a_of_type_Int = (int)mww.a(getContext(), 60.0F);
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
        int n = mww.b(getContext());
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() <= n - bdoo.a(localActivity)) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - m <= n - bdoo.a(localActivity) - mww.a(getContext(), 50.0F)))
        {
          this.jdField_i_of_type_Boolean = true;
          new aveg().h("video").i("playpage_com_exp").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
          ThreadManagerV2.excute(new ShortVideoCommentsView.28(this, (auul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
        }
      }
    } while (this.jdField_a_of_type_Avhf == null);
    this.jdField_a_of_type_Avhf.f(m);
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
        this.jdField_a_of_type_Avek.notifyDataSetChanged();
        paramComment = this.jdField_j_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder().append("(");
        Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
        long l = localComments.jdField_a_of_type_Long + 1L;
        localComments.jdField_a_of_type_Long = l;
        paramComment.setText(String.valueOf(l) + ")");
        if (this.jdField_a_of_type_Avhf != null) {
          this.jdField_a_of_type_Avhf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
        }
        s();
        if ((getContext() instanceof Activity))
        {
          paramComment = (Activity)getContext();
          mww.b(getContext());
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
    this.jdField_a_of_type_Avek.notifyDataSetChanged();
    paramComment = this.jdField_j_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder().append("(");
    Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
    long l = localComments.jdField_a_of_type_Long - 1L;
    localComments.jdField_a_of_type_Long = l;
    paramComment.setText(String.valueOf(l) + ")");
    if (this.jdField_a_of_type_Avhf != null) {
      this.jdField_a_of_type_Avhf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
    }
  }
  
  private void i(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_Avha.b(paramComment);
  }
  
  private void j(Comments.Comment paramComment)
  {
    String str = getResources().getString(2131696849);
    bdgm.a(getContext(), 232, null, str, new avff(this, paramComment), new avfg(this)).show();
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new avfk(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new avfl(this));
    q();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new avfm(this));
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(new aves(this));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new avet(this));
    this.jdField_a_of_type_AndroidWidgetListView.setLongClickable(true);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new aveu(this));
  }
  
  private void r()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Avha.b();
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
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(getContext().getResources().getString(2131696848));
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
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.isEmpty()) || (this.jdField_a_of_type_Avek.jdField_a_of_type_Boolean)) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && ((this.jdField_b_of_type_AndroidWidgetTextView.getText() == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getText().length() == 0)))
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
  }
  
  public View a()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561081, this, true);
    this.jdField_b_of_type_Int = (mww.b(getContext()) / 3);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new avfa(this));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369888));
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())) {
      this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new avfe(this));
    }
    this.jdField_a_of_type_Avek = new avek(getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.jdField_a_of_type_Avha, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561080, this, false);
    this.jdField_a_of_type_Avfw.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_Avfw.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131372098));
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView = ((ImageDisplayView)this.jdField_a_of_type_AndroidViewView.findViewById(2131368019));
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView = ((OperationView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371458));
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a();
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)this.jdField_a_of_type_AndroidViewView.findViewById(2131371497));
    Object localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).height = mww.b(this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    ((FrameLayout.LayoutParams)localObject).width = mww.a(this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.requestLayout();
    this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new avfh(this));
    label596:
    float f2;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 6)
    {
      this.jdField_a_of_type_Avfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
      this.jdField_a_of_type_Avhf = this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a();
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561082, this, false);
      this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131375534);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379043));
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView = ((TopicLabelListView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379056));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131379038));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378810));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378896));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378770));
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int != 6) {
        break label1292;
      }
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378741));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561072, this, false);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131378715));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      int m = bdoo.a((Activity)this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
      float f1 = mww.b(this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()) - m;
      f2 = mww.a(this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
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
        localObject = LayoutInflater.from(getContext()).inflate(2131561077, this.jdField_b_of_type_AndroidWidgetLinearLayout, true);
        label859:
        this.jdField_a_of_type_Avhf.a((View)localObject);
        this.jdField_a_of_type_Avfw.jdField_a_of_type_AndroidViewView = ((View)localObject);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 6)
        {
          this.jdField_a_of_type_Avhf.d();
          this.jdField_c_of_type_AndroidViewView.findViewById(2131375532).setVisibility(8);
        }
      }
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 6) {
        break label1344;
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView, (int)f2, -2);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidViewView);
      this.jdField_f_of_type_AndroidViewView.findViewById(2131378153).setVisibility(0);
      label974:
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_Avek);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4) {
        break label1384;
      }
      g();
      this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new avfi(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379922);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(new avfj(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363706));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131369707));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131365833));
      p();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131375939));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131369126));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131363644));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131375891));
      j();
      this.jdField_g_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131379923);
      return this.jdField_b_of_type_AndroidViewView;
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_j_of_type_Int == 4)
      {
        this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(0);
        this.jdField_a_of_type_Avfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
        break;
      }
      this.jdField_a_of_type_Avfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_Avfw.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(8);
      break;
      label1292:
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131378740));
      break label596;
      label1312:
      localObject = LayoutInflater.from(getContext()).inflate(2131561077, (ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131370022), true);
      break label859;
      label1344:
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView, (int)f2, -2);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidViewView);
      break label974;
      label1384:
      avej.a(this.jdField_a_of_type_Avfw, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.l, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.k);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2131561067, null, false));
      localObject = new AbsListView.LayoutParams(-1, (int)mww.a(getContext(), 50.0F));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView = ((HorizontalBallLoadingView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131373564));
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_Avha.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
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
  
  public void a(avfw paramavfw, VideoData paramVideoData)
  {
    this.jdField_a_of_type_Avfw = paramavfw;
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
      azqs.b(paramQQAppInterface, "dc00899", "grp_lbs", (String)localObject4, "video", paramString, 0, 0, (String)localObject5, (String)localObject6, (String)localObject7, "");
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
    new aveg().h("video").i("playpage_com_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    ThreadManagerV2.excute(new ShortVideoCommentsView.19(this, (auul)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(106)), 16, null, false);
  }
  
  public void a(Comments.Comment paramComment, int paramInt, String paramString)
  {
    if (paramComment != null)
    {
      if (paramInt != 10003) {
        break label70;
      }
      a(getContext().getResources().getString(2131696855));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      h(paramComment);
      new aveg().h("video").i("playpage_com_fail").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      label70:
      if (paramInt == 10009) {
        b(paramString);
      } else {
        a(getContext().getResources().getString(2131696857));
      }
    }
  }
  
  public void a(Comments paramComments)
  {
    this.jdField_a_of_type_Avek.jdField_a_of_type_Boolean = false;
    if ((paramComments.jdField_a_of_type_Long == 0L) && (paramComments.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Boolean = paramComments.jdField_a_of_type_Boolean;
      if ((paramComments.jdField_a_of_type_JavaUtilList != null) && (paramComments.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.addAll(paramComments.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_Avek.notifyDataSetChanged();
      }
      this.jdField_b_of_type_Boolean = paramComments.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_j_of_type_AndroidWidgetTextView.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long) + ")");
      if (this.jdField_a_of_type_Avhf != null) {
        this.jdField_a_of_type_Avhf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long = paramComments.jdField_a_of_type_Long;
    }
  }
  
  public void a(Comments paramComments, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4) {
      this.jdField_a_of_type_Avha.a();
    }
  }
  
  public void a(String paramString)
  {
    if (getContext() != null) {
      QQToast.a(getContext(), 0, paramString, 1).a();
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
      this.jdField_a_of_type_JavaLangString = getContext().getResources().getString(2131696848);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
      break;
      label145:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ShortVideoComments", 2, "onPermissionGranted btnText ie empty! btnSend use defualt text ");
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131696856));
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_Avha.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(Comments.Comment paramComment)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.contains(paramComment))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.remove(paramComment);
      this.jdField_a_of_type_Avek.notifyDataSetChanged();
      paramComment = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
      paramComment.jdField_a_of_type_Long -= 1L;
      this.jdField_j_of_type_AndroidWidgetTextView.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long) + ")");
      if (this.jdField_a_of_type_Avhf != null) {
        this.jdField_a_of_type_Avhf.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
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
      bdgm.a(localBaseActivity, paramString, 2131690648, 2131699508, new avfb(this, localBaseActivity), new avfc(this)).show();
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "playpage_phone_exp");
    }
  }
  
  public boolean b()
  {
    return (this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (!this.jdField_a_of_type_Avhf.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_Avhf.jdField_b_of_type_Boolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_Avek.jdField_a_of_type_Boolean = true;
  }
  
  public void c(Comments.Comment paramComment)
  {
    bhuf localbhuf = bhuf.a(getContext());
    localbhuf.a(alud.a(2131714458), 1);
    localbhuf.c(2131690648);
    localbhuf.a(new avev(this, paramComment, localbhuf));
    localbhuf.show();
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
    if ((TextUtils.isEmpty(localLocationInfo.getName())) || (localLocationInfo.name.endsWith(alud.a(2131714476))))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 6)
      {
        this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845127, 0, 0, 0);
        this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      }
      this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(null);
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 6)
    {
      this.jdField_i_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(2130845064, 0, 0, 0);
      this.jdField_i_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#576B95"));
    }
    this.jdField_i_of_type_AndroidWidgetTextView.setEnabled(true);
    this.jdField_i_of_type_AndroidWidgetTextView.setOnClickListener(new aver(this, localLocationInfo));
  }
  
  public void d(Comments.Comment paramComment)
  {
    bhuf localbhuf = bhuf.a(getContext());
    localbhuf.a(alud.a(2131714462), 1);
    localbhuf.c(2131690648);
    localbhuf.a(new avew(this, paramComment, localbhuf));
    localbhuf.show();
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments = new Comments();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Avha = new avhb(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    this.jdField_c_of_type_Int = ((int)(mww.a(getContext()) - mww.a(getContext(), 85.0F)));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(mww.a(getContext(), 12.0F));
  }
  
  public void e(Comments.Comment paramComment)
  {
    bhuf localbhuf = bhuf.a(getContext());
    localbhuf.a(alud.a(2131714445), 1);
    localbhuf.a(alud.a(2131714448), 1);
    localbhuf.c(2131690648);
    localbhuf.a(new avex(this, paramComment, localbhuf));
    localbhuf.show();
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
      Bundle localBundle = new bddg().a(paramComment.jdField_a_of_type_JavaLangString).a();
      bddf.a((BaseActivity)localContext, 0L, paramComment.c + "", null, 20006, "", localBundle);
      return;
    }
    QQToast.a(localContext, 2, alud.a(2131714423), 0).a();
  }
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131365733));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new avey(this));
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
    localObject = bdnu.b(getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Avdd, (String)localObject);
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
      this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(new avez(this));
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
        this.jdField_f_of_type_AndroidWidgetTextView.setText(alud.a(2131714438));
        this.jdField_h_of_type_AndroidWidgetTextView.setText(alud.a(2131714431));
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
      this.jdField_f_of_type_AndroidWidgetTextView.setText(alud.a(2131714466));
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
        localObject = l / 60L / 1000L + 1L + alud.a(2131714440);
      } else if (l < 86400000L) {
        localObject = l / 60L / 60L / 1000L + alud.a(2131714487);
      } else if (l < 31536000000L) {
        localObject = l / 24L / 60L / 60L / 1000L + alud.a(2131714447);
      } else {
        localObject = l / 365L / 24L / 60L / 60L / 1000L + alud.a(2131714433);
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
    this.jdField_a_of_type_Avha.c();
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_Avek != null) {
      this.jdField_a_of_type_Avek.a(this.jdField_e_of_type_Boolean);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.now.view.ShortVideoCommentsView
 * JD-Core Version:    0.7.0.1
 */