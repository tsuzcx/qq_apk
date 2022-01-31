import android.animation.Animator;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.comment.ReadInJoyCommentListFragment;
import com.tencent.biz.pubaccount.readinjoy.comment.data.AnchorData;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.viola.CommonSuspensionGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.VVideoView;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaCommentManager.1;
import com.tencent.biz.pubaccount.readinjoy.viola.videonew.topicvideo.ViolaCommentManager.5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class rzk
{
  private int jdField_a_of_type_Int;
  private FragmentActivity jdField_a_of_type_AndroidSupportV4AppFragmentActivity;
  private FragmentManager jdField_a_of_type_AndroidSupportV4AppFragmentManager;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_a_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private FrameLayout jdField_a_of_type_AndroidWidgetFrameLayout;
  private ReadInJoyCommentListFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment;
  private VVideoView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView;
  private rzo jdField_a_of_type_Rzo;
  private boolean jdField_a_of_type_Boolean;
  private int[] jdField_a_of_type_ArrayOfInt;
  private int jdField_b_of_type_Int;
  private View jdField_b_of_type_AndroidViewView;
  private ViewGroup.LayoutParams jdField_b_of_type_AndroidViewViewGroup$LayoutParams;
  private ViewGroup jdField_b_of_type_AndroidViewViewGroup;
  private int[] jdField_b_of_type_ArrayOfInt;
  private int[] c;
  
  public rzk(FragmentActivity paramFragmentActivity, FragmentManager paramFragmentManager, int paramInt)
  {
    this.jdField_b_of_type_Int = paramInt;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity = paramFragmentActivity;
    this.jdField_a_of_type_AndroidSupportV4AppFragmentManager = paramFragmentManager;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = new FrameLayout(paramFragmentActivity);
    this.jdField_a_of_type_AndroidViewView = new View(paramFragmentActivity);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewView, -1, -1);
    this.jdField_a_of_type_AndroidViewViewGroup = new FrameLayout(paramFragmentActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setId(2131364513);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.jdField_a_of_type_AndroidViewViewGroup, -2, -2);
    ((FrameLayout.LayoutParams)this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams()).gravity = 80;
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getWindow().addContentView(this.jdField_a_of_type_AndroidWidgetFrameLayout, new WindowManager.LayoutParams(-1, -1));
    a();
  }
  
  private void a(VVideoView paramVVideoView, View paramView)
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    b(paramVVideoView, paramView);
    paramView.setScaleX(1.0F);
    paramView.setScaleY(1.0F);
    paramView.setX(0.0F);
    paramView.setY(0.0F);
    if (this.jdField_b_of_type_AndroidViewViewGroup != null) {
      this.jdField_b_of_type_AndroidViewViewGroup.addView(paramView, this.jdField_a_of_type_Int, this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = null;
    this.jdField_b_of_type_AndroidViewView = null;
    this.jdField_b_of_type_AndroidViewViewGroup = null;
    this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams = null;
    this.jdField_a_of_type_ArrayOfInt = null;
    this.jdField_b_of_type_ArrayOfInt = null;
  }
  
  private void a(VVideoView paramVVideoView, View paramView, int paramInt)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = paramVVideoView;
    this.jdField_b_of_type_AndroidViewView = paramView;
    this.jdField_b_of_type_AndroidViewViewGroup = ((ViewGroup)paramView.getParent());
    this.jdField_b_of_type_AndroidViewViewGroup$LayoutParams = paramView.getLayoutParams();
    this.jdField_a_of_type_Int = this.jdField_b_of_type_AndroidViewViewGroup.indexOfChild(paramView);
    this.jdField_a_of_type_ArrayOfInt = new int[2];
    paramView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    this.jdField_a_of_type_ArrayOfInt[1] -= this.jdField_b_of_type_Int;
    this.jdField_b_of_type_ArrayOfInt = new int[] { paramView.getWidth(), paramView.getHeight() };
    b(paramVVideoView, paramView);
    int i = qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[0];
    int j = (int)(paramView.getHeight() / paramView.getWidth() * i);
    this.jdField_a_of_type_AndroidWidgetFrameLayout.addView(paramView, 1, new FrameLayout.LayoutParams(-1, j));
    this.jdField_a_of_type_AndroidViewView.setBackgroundDrawable(new ColorDrawable(paramInt));
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    qol.a(this.jdField_a_of_type_AndroidViewView, 0, 300);
    qol.a(this.jdField_a_of_type_AndroidViewViewGroup, 0, 300);
    qol.a(paramView, this.jdField_a_of_type_ArrayOfInt, this.jdField_b_of_type_ArrayOfInt, new int[] { 0, ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity) }, new int[] { i, j }, 300L, true);
    paramVVideoView = this.jdField_a_of_type_AndroidViewViewGroup;
    paramInt = this.jdField_a_of_type_ArrayOfInt[1];
    i = this.jdField_b_of_type_ArrayOfInt[1];
    int[] arrayOfInt1 = this.c;
    j = qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1];
    int k = this.c[1];
    int[] arrayOfInt2 = this.c;
    qol.a(paramVVideoView, new int[] { 0, paramInt + i }, arrayOfInt1, new int[] { 0, j - k }, arrayOfInt2, 300L, true);
    paramView.addOnLayoutChangeListener(new rzl(this));
  }
  
  private void a(VVideoView paramVVideoView, View paramView, boolean paramBoolean)
  {
    if (paramView == null) {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    qol.a(this.jdField_a_of_type_AndroidViewView, 8, 300);
    qol.a(this.jdField_a_of_type_AndroidViewViewGroup, 8, 300);
    int[] arrayOfInt = new int[2];
    arrayOfInt[0] = this.jdField_a_of_type_AndroidViewViewGroup.getWidth();
    arrayOfInt[1] = this.jdField_a_of_type_AndroidViewViewGroup.getHeight();
    Object localObject;
    if (paramBoolean)
    {
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1];
    }
    for (;;)
    {
      qol.a(this.jdField_a_of_type_AndroidViewViewGroup, new int[] { 0, qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1] - this.jdField_a_of_type_AndroidViewViewGroup.getHeight() }, arrayOfInt, (int[])localObject, arrayOfInt, 300L, true);
      int i = ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
      int j = paramView.getWidth();
      int k = paramView.getHeight();
      localObject = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt = this.jdField_b_of_type_ArrayOfInt;
      localObject = qol.a(paramView, new int[] { 0, i }, new int[] { j, k }, (int[])localObject, arrayOfInt, 300L, false);
      ((Animator)localObject).addListener(new rzm(this, paramVVideoView, paramView));
      ((Animator)localObject).start();
      return;
      localObject = new int[2];
      localObject[0] = 0;
      localObject[1] = (this.jdField_a_of_type_ArrayOfInt[1] + this.jdField_b_of_type_ArrayOfInt[1]);
    }
  }
  
  private void b(VVideoView paramVVideoView, View paramView)
  {
    if (paramVVideoView != null) {
      paramVVideoView.a();
    }
    if ((paramView.getParent() instanceof ViewGroup)) {
      ((ViewGroup)paramView.getParent()).removeView(paramView);
    }
    if (paramVVideoView != null) {
      paramVVideoView.b();
    }
  }
  
  private void c()
  {
    try
    {
      int i;
      if (axli.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext()))
      {
        i = axli.d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, i);
      }
      if (this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity == null) {
        return;
      }
      if (CommonSuspensionGestureLayout.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity))
      {
        if (this.jdField_b_of_type_Int == 0) {
          return;
        }
        i = axli.d(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity.getApplicationContext());
        this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, i + this.jdField_b_of_type_Int);
        return;
      }
      if (this.jdField_b_of_type_Int == 0)
      {
        this.jdField_a_of_type_AndroidViewViewGroup.post(new ViolaCommentManager.1(this));
        return;
      }
    }
    catch (Exception localException)
    {
      QLog.d("ViolaCommentManager", 1, "setCommentPadding");
      localException.printStackTrace();
      return;
    }
    if ((!CommonSuspensionGestureLayout.a(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)) && (this.jdField_b_of_type_Int != 0)) {
      this.jdField_a_of_type_AndroidViewViewGroup.setPadding(0, 0, 0, this.jdField_b_of_type_Int);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams = this.jdField_a_of_type_AndroidViewViewGroup.getLayoutParams();
    this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity);
    this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
    b();
    this.c = new int[] { qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[0], this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height };
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(View paramView, float paramFloat)
  {
    if (this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams != null)
    {
      int i = (int)(paramView.getHeight() / paramView.getWidth() * qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[0]);
      this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height = ((int)(qol.b(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)[1] - i - paramFloat - ImmersiveUtils.getStatusBarHeight(this.jdField_a_of_type_AndroidSupportV4AppFragmentActivity)));
      this.c[1] = this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams.height;
      this.jdField_a_of_type_AndroidViewViewGroup.setLayoutParams(this.jdField_a_of_type_AndroidViewViewGroup$LayoutParams);
    }
  }
  
  public void a(VVideoView paramVVideoView, View paramView, ArticleInfo paramArticleInfo, AnchorData paramAnchorData, int paramInt)
  {
    c();
    if ((this.jdField_a_of_type_AndroidViewViewGroup.getWidth() <= 0) || (this.jdField_a_of_type_AndroidViewViewGroup.getHeight() != this.c[1]))
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
      this.jdField_a_of_type_AndroidViewViewGroup.setAlpha(0.0F);
    }
    do
    {
      this.jdField_a_of_type_AndroidViewViewGroup.post(new ViolaCommentManager.5(this, paramVVideoView, paramView, paramArticleInfo, paramAnchorData, paramInt));
      do
      {
        return;
      } while ((this.jdField_a_of_type_Boolean) || (paramArticleInfo == null));
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
      {
        Fragment localFragment = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.findFragmentById(2131364513);
        if ((localFragment instanceof ReadInJoyCommentListFragment)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = ((ReadInJoyCommentListFragment)localFragment);
        }
      }
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null) {
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(paramArticleInfo, paramAnchorData, true, 2);
      }
      this.jdField_a_of_type_Boolean = true;
      a(paramVVideoView, paramView, paramInt);
    } while (this.jdField_a_of_type_Rzo == null);
    this.jdField_a_of_type_Rzo.a(true);
  }
  
  public void a(rzo paramrzo)
  {
    this.jdField_a_of_type_Rzo = paramrzo;
  }
  
  public void a(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView == null)
      {
        View localView = this.jdField_b_of_type_AndroidViewView.findViewWithTag("VVideoView");
        if ((localView instanceof VVideoView)) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView = ((VVideoView)localView);
        }
      }
      a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaVideonewVVideoView, this.jdField_b_of_type_AndroidViewView, paramBoolean);
      if (this.jdField_a_of_type_Rzo != null) {
        this.jdField_a_of_type_Rzo.a(false);
      }
    }
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment != null)
    {
      bool1 = bool2;
      if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.c())
      {
        a(false);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment == null)
    {
      Object localObject = new Bundle();
      ((Bundle)localObject).putBoolean("arg_comment_list_comment_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_share_btn", false);
      ((Bundle)localObject).putBoolean("arg_comment_list_biu_btn", false);
      ((Bundle)localObject).putBoolean("readinjoy_open_comment_from_video", true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment = new ReadInJoyCommentListFragment();
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a(2);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment.a((Bundle)localObject, new rzn(this), this.jdField_a_of_type_AndroidViewViewGroup);
      localObject = this.jdField_a_of_type_AndroidSupportV4AppFragmentManager.beginTransaction();
      ((FragmentTransaction)localObject).add(2131364513, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyCommentReadInJoyCommentListFragment);
      ((FragmentTransaction)localObject).commitAllowingStateLoss();
    }
  }
  
  public boolean b()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rzk
 * JD-Core Version:    0.7.0.1
 */