package com.tencent.mobileqq.nearby.now.view;

import aewz;
import aexa;
import aexb;
import aexc;
import aexd;
import aexe;
import aexf;
import aexg;
import aexh;
import aexi;
import aexj;
import aexk;
import aexl;
import aexm;
import aexn;
import aexo;
import aexp;
import aexq;
import aexr;
import aexs;
import aext;
import aexu;
import aexv;
import aexw;
import aexy;
import aexz;
import aeya;
import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ImageSpan;
import android.util.DisplayMetrics;
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
import com.tencent.av.utils.UITools;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.now.model.Comments;
import com.tencent.mobileqq.nearby.now.model.Comments.Comment;
import com.tencent.mobileqq.nearby.now.model.LocationInfo;
import com.tencent.mobileqq.nearby.now.model.MedalInfo;
import com.tencent.mobileqq.nearby.now.model.MedalInfoMgr.IMediaInfoListener;
import com.tencent.mobileqq.nearby.now.model.VideoData;
import com.tencent.mobileqq.nearby.now.utils.NowVideoReporter;
import com.tencent.mobileqq.nearby.now.utils.StoryRelayoutUtil;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenter;
import com.tencent.mobileqq.nearby.now.view.presenter.CommentsPresenterImpl;
import com.tencent.mobileqq.nearby.now.view.viewmodel.PlayOperationViewModel;
import com.tencent.mobileqq.nearby.now.view.widget.HorizontalBallLoadingView;
import com.tencent.mobileqq.nearby.now.view.widget.ImageDisplayView;
import com.tencent.mobileqq.nearby.now.view.widget.TopicLabelListView;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class ShortVideoCommentsView
  extends LinearLayout
  implements View.OnLayoutChangeListener, CommentsView
{
  private static int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private aexy jdField_a_of_type_Aexy;
  private aexz jdField_a_of_type_Aexz;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  public View a;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  public ImageView a;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout;
  private ListView jdField_a_of_type_AndroidWidgetListView;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  public QQAppInterface a;
  private Comments.Comment jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments$Comment;
  public Comments a;
  private MedalInfo jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfo;
  private MedalInfoMgr.IMediaInfoListener jdField_a_of_type_ComTencentMobileqqNearbyNowModelMedalInfoMgr$IMediaInfoListener = new aexl(this);
  private VideoData jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData;
  private CommentsAdapter jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter;
  private VideoPlayerPagerAdapter.VideoViewHolder jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder;
  private CommentsPresenter jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter;
  private PlayOperationViewModel jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel;
  private HorizontalBallLoadingView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView;
  private TopicLabelListView jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView;
  private String jdField_a_of_type_JavaLangString = "";
  private Map jdField_a_of_type_JavaUtilMap = new HashMap();
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
    jdField_a_of_type_Int = (int)UITools.a(getContext(), 60.0F);
  }
  
  private aeya a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    aeya localaeya;
    do
    {
      return null;
      localaeya = new aeya(this, null);
      m = paramString.indexOf("#");
      if (m == -1)
      {
        localaeya.jdField_a_of_type_JavaLangString = paramString;
        return localaeya;
      }
      paramString = paramString.split("#");
    } while (paramString == null);
    if (m > 0) {
      localaeya.jdField_a_of_type_JavaLangString = paramString[0];
    }
    localaeya.jdField_a_of_type_JavaUtilList = new ArrayList();
    int m = 1;
    if (m < paramString.length)
    {
      if (TextUtils.isEmpty(paramString[m])) {}
      for (;;)
      {
        m += 1;
        break;
        if (!localaeya.jdField_a_of_type_JavaUtilList.contains(paramString[m])) {
          localaeya.jdField_a_of_type_JavaUtilList.add(paramString[m]);
        }
      }
    }
    return localaeya;
  }
  
  private void a(int paramInt)
  {
    if (this.jdField_a_of_type_Aexy != null) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_Aexy);
    }
    this.jdField_a_of_type_Aexy = new aexy(this, paramInt);
    ThreadManager.getUIHandler().post(this.jdField_a_of_type_Aexy);
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
        int n = UITools.b(getContext());
        if ((this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() <= n - ViewUtils.a(localActivity)) || (this.jdField_b_of_type_AndroidWidgetLinearLayout.getMeasuredHeight() - m <= n - ViewUtils.a(localActivity) - UITools.a(getContext(), 50.0F)))
        {
          this.jdField_i_of_type_Boolean = true;
          new NowVideoReporter().h("video").i("playpage_com_exp").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        }
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel == null);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.e(m);
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
  
  private void c(Comments.Comment paramComment)
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
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.notifyDataSetChanged();
        paramComment = this.jdField_j_of_type_AndroidWidgetTextView;
        StringBuilder localStringBuilder = new StringBuilder().append("(");
        Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
        long l = localComments.jdField_a_of_type_Long + 1L;
        localComments.jdField_a_of_type_Long = l;
        paramComment.setText(String.valueOf(l) + ")");
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel != null) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
        }
        s();
        if ((getContext() instanceof Activity))
        {
          paramComment = (Activity)getContext();
          m = UITools.b(getContext());
          this.jdField_a_of_type_AndroidWidgetListView.setSelectionFromTop(1, (int)(m - ViewUtils.a(paramComment) - jdField_a_of_type_Int - UITools.a(getContext(), 50.0F)));
          postDelayed(new aexe(this), 100L);
        }
        return;
      }
      m += 1;
    }
  }
  
  private void d(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.remove(paramComment);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.notifyDataSetChanged();
    paramComment = this.jdField_j_of_type_AndroidWidgetTextView;
    StringBuilder localStringBuilder = new StringBuilder().append("(");
    Comments localComments = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
    long l = localComments.jdField_a_of_type_Long - 1L;
    localComments.jdField_a_of_type_Long = l;
    paramComment.setText(String.valueOf(l) + ")");
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
    }
  }
  
  private void e(Comments.Comment paramComment)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter.b(paramComment);
  }
  
  private void f(Comments.Comment paramComment)
  {
    String str = getResources().getString(2131430834);
    DialogUtil.a(getContext(), 232, null, str, new aexo(this, paramComment), new aexp(this)).show();
  }
  
  private void p()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new aext(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnTouchListener(new aexu(this));
    q();
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOnClickListener(new aexv(this));
  }
  
  private void q()
  {
    this.jdField_a_of_type_AndroidWidgetListView.setOnScrollListener(new aexw(this));
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemClickListener(new aexa(this));
    this.jdField_a_of_type_AndroidWidgetListView.setLongClickable(true);
    this.jdField_a_of_type_AndroidWidgetListView.setOnItemLongClickListener(new aexb(this));
  }
  
  private void r()
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter.b();
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
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(getContext().getResources().getString(2131430838));
    }
  }
  
  private void t()
  {
    if (this.jdField_a_of_type_Aexz != null) {
      ThreadManager.getUIHandler().post(this.jdField_a_of_type_Aexz);
    }
    this.jdField_a_of_type_Aexz = new aexz(this, System.currentTimeMillis());
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_Aexz, 100L);
  }
  
  private void u()
  {
    if (((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.isEmpty()) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.jdField_a_of_type_Boolean)) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0) && ((this.jdField_b_of_type_AndroidWidgetTextView.getText() == null) || (this.jdField_b_of_type_AndroidWidgetTextView.getText().length() == 0)))
    {
      this.jdField_g_of_type_AndroidViewView.setVisibility(8);
      return;
    }
    this.jdField_g_of_type_AndroidViewView.setVisibility(0);
  }
  
  public View a()
  {
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970461, this, true);
    this.jdField_b_of_type_Int = (UITools.b(getContext()) / 3);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new aewz(this));
    this.jdField_a_of_type_AndroidWidgetListView = ((ListView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370573));
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData == null) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())) {
      this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new aexk(this));
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter = new CommentsAdapter(getContext(), this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter, this.jdField_a_of_type_AndroidGraphicsPaint, this.jdField_c_of_type_Int);
    this.jdField_a_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970460, this, false);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewView.findViewById(2131370641));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView = ((ImageDisplayView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370643));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView = ((OperationView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370644));
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView = ((QQStoryVideoPlayerErrorView)this.jdField_a_of_type_AndroidViewView.findViewById(2131370640));
    Object localObject = (FrameLayout.LayoutParams)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).height = UITools.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    ((FrameLayout.LayoutParams)localObject).width = UITools.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.getContext());
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.requestLayout();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setOnClickListener(new aexq(this));
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Int != 4)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewQQStoryVideoPlayerErrorView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel = this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewOperationView.a();
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 1)
      {
        localObject = LayoutInflater.from(getContext()).inflate(2130970457, (ViewGroup)this.jdField_b_of_type_AndroidViewView.findViewById(2131370646), true);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a((View)localObject);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_AndroidViewView = ((View)localObject);
      }
      this.jdField_c_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970462, this, false);
      this.jdField_d_of_type_AndroidViewView = this.jdField_c_of_type_AndroidViewView.findViewById(2131370656);
      this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131361926));
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView = ((TopicLabelListView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370657));
      this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370658));
      this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370659));
      this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131363549));
      this.jdField_h_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370660));
      this.jdField_i_of_type_AndroidWidgetTextView = ((TextView)this.jdField_c_of_type_AndroidViewView.findViewById(2131370661));
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      this.jdField_f_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2130970451, this, false);
      this.jdField_j_of_type_AndroidWidgetTextView = ((TextView)this.jdField_f_of_type_AndroidViewView.findViewById(2131370576));
      this.jdField_b_of_type_AndroidWidgetLinearLayout = new LinearLayout(getContext());
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#00000000"));
      int m = ViewUtils.a((Activity)this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
      float f1 = UITools.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()) - m;
      float f2 = UITools.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext());
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int == 4)
      {
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setBackgroundColor(Color.parseColor("#000000"));
        localObject = new AbsListView.LayoutParams(-1, -1);
        ((AbsListView.LayoutParams)localObject).width = ((int)f2);
        ((AbsListView.LayoutParams)localObject).height = ((int)f1);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
        this.jdField_b_of_type_AndroidWidgetLinearLayout.requestLayout();
      }
      this.jdField_b_of_type_AndroidWidgetLinearLayout.setOrientation(1);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_a_of_type_AndroidViewView, (int)f2, UITools.b(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()) - ViewUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.getContext()));
      this.jdField_c_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_f_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#ffffff"));
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_c_of_type_AndroidViewView);
      this.jdField_b_of_type_AndroidWidgetLinearLayout.addView(this.jdField_f_of_type_AndroidViewView);
      this.jdField_a_of_type_AndroidWidgetListView.addHeaderView(this.jdField_b_of_type_AndroidWidgetLinearLayout);
      this.jdField_a_of_type_AndroidWidgetListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter);
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4) {
        break label1165;
      }
      g();
      this.jdField_a_of_type_AndroidWidgetListView.setOnTouchListener(new aexr(this));
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.a())
      {
        this.jdField_c_of_type_AndroidViewView.setVisibility(8);
        this.jdField_f_of_type_AndroidViewView.setVisibility(8);
      }
      this.jdField_e_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131370647);
      this.jdField_e_of_type_AndroidViewView.setOnClickListener(new aexs(this));
      this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370654));
      this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370653));
      this.jdField_a_of_type_AndroidWidgetEditText = ((EditText)this.jdField_b_of_type_AndroidViewView.findViewById(2131370655));
      p();
      this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370649));
      this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370650));
      this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370651));
      this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_b_of_type_AndroidViewView.findViewById(2131370652));
      j();
      this.jdField_g_of_type_AndroidViewView = this.jdField_b_of_type_AndroidViewView.findViewById(2131367265);
      return this.jdField_b_of_type_AndroidViewView;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetImageDisplayView.setVisibility(0);
      break;
      label1165:
      StoryRelayoutUtil.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.i, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_h_of_type_Int);
      this.jdField_a_of_type_AndroidWidgetFrameLayout = ((FrameLayout)LayoutInflater.from(getContext()).inflate(2130970446, null, false));
      localObject = new AbsListView.LayoutParams(-1, (int)UITools.a(getContext(), 50.0F));
      this.jdField_a_of_type_AndroidWidgetFrameLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView = ((HorizontalBallLoadingView)this.jdField_a_of_type_AndroidWidgetFrameLayout.findViewById(2131370565));
      this.jdField_a_of_type_AndroidWidgetListView.addFooterView(this.jdField_a_of_type_AndroidWidgetFrameLayout);
    }
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(0);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 300) || (paramInt1 == 301)) {
      a("", "");
    }
  }
  
  public void a(Comments.Comment paramComment)
  {
    if (paramComment != null) {}
    new NowVideoReporter().h("video").i("playpage_com_suc").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void a(Comments.Comment paramComment, int paramInt)
  {
    if (paramComment != null)
    {
      if (paramInt != 10003) {
        break label70;
      }
      a(getContext().getResources().getString(2131430842));
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
      d(paramComment);
      new NowVideoReporter().h("video").i("playpage_com_fail").a().a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
      return;
      label70:
      if (paramInt == 10010) {
        a("当前等级不够，请努力升级吧！");
      } else {
        a(getContext().getResources().getString(2131430843));
      }
    }
  }
  
  public void a(Comments paramComments)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.jdField_a_of_type_Boolean = false;
    if ((paramComments.jdField_a_of_type_Long == 0L) && (paramComments.jdField_a_of_type_Boolean)) {}
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Boolean = paramComments.jdField_a_of_type_Boolean;
      if ((paramComments.jdField_a_of_type_JavaUtilList != null) && (paramComments.jdField_a_of_type_JavaUtilList.size() > 0))
      {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.addAll(paramComments.jdField_a_of_type_JavaUtilList);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.notifyDataSetChanged();
      }
      this.jdField_b_of_type_Boolean = paramComments.jdField_a_of_type_Boolean;
      this.jdField_a_of_type_Boolean = false;
      this.jdField_j_of_type_AndroidWidgetTextView.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long) + ")");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
      }
      return;
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long = paramComments.jdField_a_of_type_Long;
    }
  }
  
  public void a(Comments paramComments, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Int != 4) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter.a();
    }
  }
  
  public void a(VideoPlayerPagerAdapter.VideoViewHolder paramVideoViewHolder, VideoData paramVideoData)
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewVideoPlayerPagerAdapter$VideoViewHolder = paramVideoViewHolder;
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData = paramVideoData;
    this.jdField_c_of_type_Boolean = false;
    e();
    a();
    a(null, 0);
    h();
    d();
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
      this.jdField_a_of_type_JavaLangString = getContext().getResources().getString(2131430838);
      this.jdField_a_of_type_AndroidWidgetEditText.setHint(this.jdField_a_of_type_JavaLangString);
      break;
      label145:
      if (this.jdField_a_of_type_AndroidWidgetTextView != null)
      {
        if (QLog.isColorLevel()) {
          QLog.w("ShortVideoComments", 2, "onPermissionGranted btnText ie empty! btnSend use defualt text ");
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setText(getContext().getResources().getString(2131430839));
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_f_of_type_Boolean;
  }
  
  public void b()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter.a() > 0) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView != null)) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetHorizontalBallLoadingView.setVisibility(8);
    }
    this.jdField_a_of_type_Boolean = false;
  }
  
  public void b(Comments.Comment paramComment)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.contains(paramComment))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList.remove(paramComment);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.notifyDataSetChanged();
      paramComment = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments;
      paramComment.jdField_a_of_type_Long -= 1L;
      this.jdField_j_of_type_AndroidWidgetTextView.setText("(" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long) + ")");
      if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel != null) {
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_Long);
      }
    }
  }
  
  public boolean b()
  {
    return (this.jdField_f_of_type_Boolean) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_a_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_a_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewViewmodelPlayOperationViewModel.jdField_b_of_type_Boolean);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.jdField_a_of_type_Boolean = true;
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
    do
    {
      return;
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_ComTencentMobileqqNearbyNowModelLocationInfo;
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoComments", 2, "initLocationView:" + ((LocationInfo)localObject2).toString());
      }
    } while ((((LocationInfo)localObject2).isCityEmpty()) && (((LocationInfo)localObject2).isNameEmpty()));
    this.jdField_i_of_type_AndroidWidgetTextView.setVisibility(0);
    Object localObject1 = new StringBuilder(((LocationInfo)localObject2).getCity());
    if (!((LocationInfo)localObject2).isNameEmpty())
    {
      if (!((LocationInfo)localObject2).isCityEmpty()) {
        ((StringBuilder)localObject1).append("·");
      }
      ((StringBuilder)localObject1).append(((LocationInfo)localObject2).getName());
    }
    Object localObject2 = new ImageSpan(getContext(), 2130842792);
    int m = (int)(14.0F * getContext().getResources().getDisplayMetrics().density + 0.5F);
    ((ImageSpan)localObject2).getDrawable().setBounds(0, 0, m, m);
    localObject1 = new SpannableString("P " + ((StringBuilder)localObject1).toString());
    ((SpannableString)localObject1).setSpan(localObject2, 0, 1, 17);
    this.jdField_i_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments = new Comments();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelComments.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter = new CommentsPresenterImpl(this, this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getLongAccountUin();
    this.jdField_c_of_type_Int = ((int)(UITools.a(getContext()) - UITools.a(getContext(), 85.0F)));
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(UITools.a(getContext(), 12.0F));
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
  
  public void g()
  {
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_b_of_type_AndroidViewView.findViewById(2131370648));
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new aexc(this));
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
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j != null)
    {
      localObject = str;
      if (!this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j.isEmpty()) {
        localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j.replace("\n", "").replace("\r", "").trim();
      }
    }
    label173:
    long l;
    if (!((String)localObject).isEmpty())
    {
      localObject = a(this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.j);
      if (localObject == null)
      {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(8);
        if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b) {
          break label355;
        }
        this.jdField_f_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetTextView.setVisibility(8);
        this.jdField_g_of_type_AndroidWidgetTextView.setOnTouchListener(new aexd(this));
        l = System.currentTimeMillis() - this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.c * 1000L;
        if (l >= 0L) {
          break label573;
        }
        localObject = "1分钟前";
      }
    }
    for (;;)
    {
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
      this.jdField_c_of_type_AndroidViewView.setVisibility(0);
      return;
      if (TextUtils.isEmpty(((aeya)localObject).jdField_a_of_type_JavaLangString)) {
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      for (;;)
      {
        if ((((aeya)localObject).jdField_a_of_type_JavaUtilList != null) && (((aeya)localObject).jdField_a_of_type_JavaUtilList.size() != 0)) {
          break label303;
        }
        this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(8);
        break;
        this.jdField_d_of_type_AndroidWidgetTextView.setText(((aeya)localObject).jdField_a_of_type_JavaLangString);
        this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(0);
      }
      label303:
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setData(((aeya)localObject).jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(0);
      break;
      this.jdField_d_of_type_AndroidWidgetTextView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewWidgetTopicLabelListView.setVisibility(8);
      this.jdField_d_of_type_AndroidViewView.setVisibility(8);
      break;
      label355:
      if ((this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.e == this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.b) && (this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_g_of_type_Int != 4))
      {
        this.jdField_f_of_type_AndroidWidgetTextView.setText("来自: ");
        this.jdField_h_of_type_AndroidWidgetTextView.setText(" 的直播");
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
        break label173;
      }
      this.jdField_f_of_type_AndroidWidgetTextView.setText("录制者: ");
      this.jdField_h_of_type_AndroidWidgetTextView.setVisibility(8);
      str = this.jdField_a_of_type_ComTencentMobileqqNearbyNowModelVideoData.jdField_h_of_type_JavaLangString;
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
      break label173;
      label573:
      if (l < 3600000L) {
        localObject = l / 60L / 1000L + 1L + "分钟前";
      } else if (l < 86400000L) {
        localObject = l / 60L / 60L / 1000L + "小时前";
      } else if (l < 31536000000L) {
        localObject = l / 24L / 60L / 60L / 1000L + "天前";
      } else {
        localObject = l / 365L / 24L / 60L / 60L / 1000L + "年前";
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
    } while (this.jdField_a_of_type_Aexz == null);
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_Aexz);
  }
  
  public void k()
  {
    j();
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetListView.setSelection(0);
    this.jdField_d_of_type_Int = 0;
    ThreadManager.getUIHandler().postDelayed(new aexf(this), 10L);
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
    postDelayed(new aexg(this), 100L);
    postDelayed(new aexh(this), 200L);
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
      postDelayed(new aexi(this), 100L);
      postDelayed(new aexj(this), 200L);
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
    this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewPresenterCommentsPresenter.c();
    this.jdField_e_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyNowViewCommentsAdapter.a(this.jdField_e_of_type_Boolean);
    }
  }
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    if ((paramInt8 != 0) && (paramInt4 != 0))
    {
      if (paramInt8 - paramInt4 <= this.jdField_b_of_type_Int) {
        break label53;
      }
      ThreadManager.getUIHandler().post(new aexm(this));
    }
    for (;;)
    {
      if (this.jdField_d_of_type_Int == 0) {
        this.jdField_d_of_type_Int = b();
      }
      return;
      label53:
      if (paramInt4 - paramInt8 > this.jdField_b_of_type_Int) {
        ThreadManager.getUIHandler().post(new aexn(this));
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