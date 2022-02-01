package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.nearby.FaceScoreConfig;
import com.tencent.mobileqq.nearby.interestTag.InterestTag;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.urldrawable.URLDrawableHelperConstants;
import com.tencent.mobileqq.util.NearbyProfileUtil;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.BooleanRef;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NearbyNowData;
import tencent.im.oidb.cmd0xac5.cmd0xac5.NowAnchorState;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NewNearbyProfileFragment;", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileFragment;", "()V", "noContent", "", "getLayoutId", "", "initGiftUI", "", "initLabelDisplayCtrl", "initNowLiveUI", "loadImage", "imageView", "Landroid/widget/ImageView;", "openFaceScorePage", "tinyid", "", "refreshViews", "setJobCompanySchoolInfo", "setTagsInfo", "tags", "", "Lcom/tencent/mobileqq/nearby/interestTag/InterestTag;", "([Lcom/tencent/mobileqq/nearby/interestTag/InterestTag;)V", "setXuanYan", "richStatus", "", "setYanzhiInfo", "updateFaceScoreItem", "config", "Lcom/tencent/mobileqq/nearby/FaceScoreConfig;", "Companion", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewNearbyProfileFragment
  extends NearbyProfileFragment
{
  public static final NewNearbyProfileFragment.Companion s = new NewNearbyProfileFragment.Companion(null);
  private boolean t = true;
  private HashMap u;
  
  private final void a(ImageView paramImageView)
  {
    Object localObject = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = URLDrawableHelperConstants.a;
    ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = UIUtils.a(getContext(), 162.0F);
    ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = UIUtils.a(getContext(), 166.0F);
    localObject = URLDrawable.getDrawable("https://dldir1.qq.com/huayang/qq/images/76b8502dfdeaa7e0b68992999351a2bb.png", (URLDrawable.URLDrawableOptions)localObject);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "URLDrawable.getDrawable(…RL, emptyDrawableOptions)");
    if (((URLDrawable)localObject).getStatus() == 1)
    {
      paramImageView.setVisibility(0);
      paramImageView.setImageDrawable((Drawable)localObject);
      return;
    }
    ((URLDrawable)localObject).setURLDrawableListener((URLDrawable.URLDrawableListener)new NewNearbyProfileFragment.loadImage.1(this, paramImageView));
    ThreadManager.post((Runnable)new NewNearbyProfileFragment.loadImage.2((URLDrawable)localObject), 8, null, false);
  }
  
  private final void k()
  {
    Object localObject1 = this.e;
    if (localObject1 != null)
    {
      View localView = this.i.findViewById(2131439488);
      Object localObject2 = ((NearbyPeopleCard)localObject1).nearbyNowData;
      if (localObject2 != null)
      {
        localObject2 = ((cmd0xac5.NearbyNowData)localObject2).now_anchor_state;
        if (localObject2 != null)
        {
          localObject2 = ((cmd0xac5.NowAnchorState)localObject2).uint32_level;
          if (localObject2 != null)
          {
            i = ((PBUInt32Field)localObject2).get();
            break label65;
          }
        }
      }
      int i = 0;
      label65:
      if (i <= 0)
      {
        Intrinsics.checkExpressionValueIsNotNull(localView, "nowLiveLayout");
        localView.setVisibility(8);
        return;
      }
      localObject2 = (TextView)this.i.findViewById(2131439489);
      ((TextView)localObject2).setText((CharSequence)((TextView)localObject2).getContext().getString(1946615843, new Object[] { Integer.valueOf(i) }));
      localObject2 = (TextView)this.i.findViewById(2131439490);
      if (((NearbyPeopleCard)localObject1).nearbyNowData.now_anchor_state.uint32_live_status.get() == 1) {
        i = 1946615844;
      } else {
        i = 1946615845;
      }
      ((TextView)localObject2).setText(i);
      localObject1 = this.e.nearbyNowData.now_anchor_state.bytes_live_url.get().toStringUtf8();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "jumpUrl");
      if (StringsKt.isBlank((CharSequence)localObject1)) {
        return;
      }
      localView.setOnClickListener((View.OnClickListener)new NewNearbyProfileFragment.initNowLiveUI.3(this, (String)localObject1));
    }
  }
  
  protected int a()
  {
    return 2131627581;
  }
  
  public void a(long paramLong) {}
  
  public void a(@Nullable FaceScoreConfig paramFaceScoreConfig) {}
  
  protected void a(@Nullable InterestTag[] paramArrayOfInterestTag)
  {
    LabelDisplayCtrl localLabelDisplayCtrl = this.m;
    Object localObject = this.e;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mCard");
    localObject = ((NearbyPeopleCard)localObject).getCommonTagInfos();
    if (localObject != null) {
      localLabelDisplayCtrl.a((InterestTag)localObject);
    }
    localLabelDisplayCtrl.a(paramArrayOfInterestTag);
    if (((localLabelDisplayCtrl instanceof NewLabelDisplayCtrl)) && (((NewLabelDisplayCtrl)localLabelDisplayCtrl).c())) {
      this.t = false;
    }
  }
  
  protected void b(@Nullable byte[] paramArrayOfByte) {}
  
  protected void c()
  {
    LinearLayout localLinearLayout = (LinearLayout)this.i.findViewById(2131436941);
    View localView = this.i.findViewById(2131436942);
    NewLabelDisplayCtrl localNewLabelDisplayCtrl = new NewLabelDisplayCtrl();
    localNewLabelDisplayCtrl.a((Context)this.c, localLinearLayout, localView);
    this.m = ((LabelDisplayCtrl)localNewLabelDisplayCtrl);
  }
  
  protected void d() {}
  
  protected void e()
  {
    this.t = true;
    super.e();
    k();
    View localView1 = this.i;
    View localView2 = localView1.findViewById(2131439345);
    boolean bool = this.t;
    int j = 0;
    if (bool)
    {
      View localView3 = localView2.findViewById(2131435357);
      Intrinsics.checkExpressionValueIsNotNull(localView3, "findViewById(R.id.image)");
      a((ImageView)localView3);
      i = 0;
    }
    else
    {
      i = 8;
    }
    localView2.setVisibility(i);
    localView1 = localView1.findViewById(2131437213);
    int i = j;
    if (this.t) {
      i = 8;
    }
    localView1.setVisibility(i);
  }
  
  protected void f() {}
  
  protected void g()
  {
    Object localObject1 = this.e;
    Object localObject2 = (ViewGroup)this.i.findViewById(2131440005);
    ((ViewGroup)localObject2).removeAllViews();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "personInfoContainer");
    Context localContext = ((ViewGroup)localObject2).getContext();
    Ref.BooleanRef localBooleanRef = new Ref.BooleanRef();
    int i = 0;
    localBooleanRef.element = false;
    localObject2 = new NewNearbyProfileFragment.setJobCompanySchoolInfo.1(this, localBooleanRef, localContext, (ViewGroup)localObject2);
    int j = ((NearbyPeopleCard)localObject1).job;
    if ((j > 0) && (j < NearbyProfileUtil.e.length)) {
      ((NewNearbyProfileFragment.setJobCompanySchoolInfo.1)localObject2).invoke(NearbyProfileUtil.e[j], 1946615812);
    }
    ((NewNearbyProfileFragment.setJobCompanySchoolInfo.1)localObject2).invoke(((NearbyPeopleCard)localObject1).company, 1946615808);
    ((NewNearbyProfileFragment.setJobCompanySchoolInfo.1)localObject2).invoke(((NearbyPeopleCard)localObject1).college, 1946615835);
    localObject1 = this.i.findViewById(2131440006);
    if (!localBooleanRef.element) {
      i = 8;
    }
    ((View)localObject1).setVisibility(i);
  }
  
  public void j()
  {
    HashMap localHashMap = this.u;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileFragment
 * JD-Core Version:    0.7.0.1
 */