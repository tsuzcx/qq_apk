import android.animation.ObjectAnimator;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaGestureLayout;
import com.tencent.biz.pubaccount.readinjoy.viola.delegate.ViolaInitDelegate.2;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.core.ViolaSDKManager;
import org.json.JSONObject;

public class rkg
{
  private ObjectAnimator jdField_a_of_type_AndroidAnimationObjectAnimator;
  private View jdField_a_of_type_AndroidViewView;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private AnimationSet jdField_a_of_type_AndroidViewAnimationAnimationSet;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  private ViolaFragment jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment;
  private ViolaGestureLayout jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout;
  private ViolaBaseView jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView;
  private String jdField_a_of_type_JavaLangString;
  private rkn jdField_a_of_type_Rkn;
  private TranslateAnimation b;
  private TranslateAnimation c;
  
  public rkg(ViolaFragment paramViolaFragment)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment = paramViolaFragment;
  }
  
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = Uri.parse(paramString).getQueryParameter("_ckey");
    } while (TextUtils.isEmpty(paramString));
    SharedPreferences localSharedPreferences = bgmq.a(BaseApplicationImpl.getApplication().getRuntime(), true, true);
    if (localSharedPreferences == null)
    {
      QLog.d("ViolaInitDelegate", 1, "failed to getItem");
      return null;
    }
    return localSharedPreferences.getString(paramString, null);
  }
  
  private rnn a(JSONObject paramJSONObject)
  {
    return new rnn(this.jdField_a_of_type_JavaLangString, paramJSONObject, a(this.jdField_a_of_type_JavaLangString));
  }
  
  private void c(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout = new ViolaGestureLayout(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
    Object localObject = (ViewGroup)paramViewGroup.getParent();
    int i = ((ViewGroup)localObject).indexOfChild(paramViewGroup);
    ((ViewGroup)localObject).removeView(paramViewGroup);
    this.jdField_a_of_type_AndroidViewView = new View(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(Color.parseColor("#66000000"));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout.addView(this.jdField_a_of_type_AndroidViewView);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout.addView(paramViewGroup);
    ((ViewGroup)localObject).addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout, i);
    localObject = (FrameLayout)paramViewGroup.findViewById(2131313408);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout.setViolaContainer(paramViewGroup);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout.setViolaGestureListener(new rki(this, paramViewGroup, (FrameLayout)localObject));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout.setViolaMaterListListener(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResume();
      c(true);
    }
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void a(Bundle paramBundle)
  {
    if (paramBundle != null) {
      this.jdField_a_of_type_JavaLangString = paramBundle.getString("url");
    }
  }
  
  public void a(ViewGroup paramViewGroup)
  {
    paramViewGroup.setBackgroundColor(0);
    c(paramViewGroup);
    paramViewGroup.setLayerType(2, null);
    if (this.jdField_a_of_type_AndroidViewAnimationAnimationSet == null)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet = ((AnimationSet)AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), 2130772066));
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setDuration(200L);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setInterpolator(new AccelerateDecelerateInterpolator());
      FrameLayout localFrameLayout = (FrameLayout)paramViewGroup.findViewById(2131313408);
      this.jdField_a_of_type_AndroidViewAnimationAnimationSet.setAnimationListener(new rkh(this, localFrameLayout, paramViewGroup));
    }
    a(true);
    ViolaSDKManager.getInstance().postOnUiThreadDelay(new ViolaInitDelegate.2(this, paramViewGroup), 150L);
  }
  
  public void a(@NonNull ViewGroup paramViewGroup, @NonNull JSONObject paramJSONObject, boolean paramBoolean, rno paramrno)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)paramViewGroup.findViewById(2131313407));
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView = new ViolaBaseView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity());
    if (!paramBoolean) {
      this.jdField_a_of_type_AndroidViewViewGroup.addView(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView);
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setListener(paramrno);
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.setPageStartTime(System.currentTimeMillis());
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment, a(paramJSONObject));
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramString);
    }
  }
  
  public void a(rkn paramrkn)
  {
    this.jdField_a_of_type_Rkn = paramrkn;
  }
  
  public void a(rno paramrno)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramrno);
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setLayerType(2, null);
    if (paramBoolean) {}
    for (this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, View.ALPHA, new float[] { 0.0F, 1.0F });; this.jdField_a_of_type_AndroidAnimationObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_AndroidViewView, View.ALPHA, new float[] { 1.0F, 0.0F }))
    {
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.addListener(new rkl(this));
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setDuration(250L);
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.setInterpolator(new LinearInterpolator());
      this.jdField_a_of_type_AndroidAnimationObjectAnimator.start();
      return;
    }
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      return this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.d();
    }
    return false;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null)
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityPause();
      c(false);
    }
  }
  
  public void b(ViewGroup paramViewGroup)
  {
    if (this.c == null) {
      this.c = ((TranslateAnimation)AnimationUtils.loadAnimation(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaFragment.getActivity(), 2130772044));
    }
    this.c.setAnimationListener(new rkm(this, paramViewGroup));
    this.c.setDuration(200L);
    this.c.setInterpolator(new AccelerateInterpolator());
    paramViewGroup.startAnimation(this.c);
  }
  
  public void b(boolean paramBoolean)
  {
    if (paramBoolean) {}
    try
    {
      c(true);
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("startSession", 1);
      a(localJSONObject.toString());
      return;
    }
    catch (Exception localException)
    {
      if (!QLog.isColorLevel()) {
        return;
      }
      QLog.e("ViolaInitDelegate", 1, "setUserVisibleHint Exception " + localException.getMessage());
    }
    c(false);
    return;
  }
  
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.onActivityDestroy();
    }
  }
  
  public void c(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.c())) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a(paramBoolean);
    }
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViewViolaBaseView.a();
    }
  }
  
  public void d(boolean paramBoolean)
  {
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout != null) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaViolaGestureLayout.setCanCloseFromBottom(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     rkg
 * JD-Core Version:    0.7.0.1
 */