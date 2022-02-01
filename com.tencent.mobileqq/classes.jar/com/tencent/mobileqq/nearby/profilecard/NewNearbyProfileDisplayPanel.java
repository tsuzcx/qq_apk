package com.tencent.mobileqq.nearby.profilecard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.recyclerview.widget.RecyclerView.LayoutManager;
import com.tencent.biz.qqstory.utils.UIUtils;
import com.tencent.falco.utils.ThreadCenter;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.NearbyPeopleCard;
import com.tencent.mobileqq.mvvm.ViewExtKt;
import com.tencent.mobileqq.nearby.business.INearbyCardHandler;
import com.tencent.mobileqq.nearby.widget.NearbyCoverView;
import com.tencent.mobileqq.newnearby.util.NearbyStatusBarHelper;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.mobileqq.pic.api.ICompressOperator;
import com.tencent.mobileqq.picbrowser.PicInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.text.OffsetableImageSpan;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.mobileqq.transfile.TransProcessorHandler;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.mobileqq.transfile.api.ITransFileController;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.nowsummarycard.NowSummaryCard.CommonTag;
import com.tencent.nowsummarycard.NowSummaryCard.CommonTag.Tag;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/nearby/profilecard/NewNearbyProfileDisplayPanel;", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileDisplayPanel;", "activity", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;", "(Lcom/tencent/mobileqq/nearby/profilecard/NearbyPeopleProfileActivity;)V", "adapter", "Lcom/tencent/mobileqq/nearby/profilecard/NearbyProfileImageDisplayAdapter;", "bigImageView", "Landroid/widget/ImageView;", "coverView", "Lcom/tencent/mobileqq/nearby/widget/NearbyCoverView;", "followView", "Landroid/view/View;", "goToChoosePicture", "", "picInfo", "Lcom/tencent/mobileqq/picbrowser/PicInfo;", "picUploadHandler", "Lcom/tencent/mobileqq/transfile/TransProcessorHandler;", "value", "", "selectedTabIndex", "setSelectedTabIndex", "(I)V", "sendMsgBigView", "sendMsgView", "tabBars", "", "Lkotlin/Pair;", "Landroid/widget/TextView;", "uploadedPics", "Ljava/util/ArrayList;", "uploadingPic", "uploadingPics", "bindData", "", "card", "Lcom/tencent/mobileqq/data/NearbyPeopleCard;", "canAddPhotot", "createTagView", "color", "Landroid/util/Pair;", "", "tagName", "leftResId", "resPadding", "doOnDestory", "doOnNewIntent", "data", "Landroid/content/Intent;", "editNearbyProfileCardResult", "success", "enterChat", "fillVideoHead", "info", "itemView", "Landroid/widget/RelativeLayout;", "getConstellationTagColor", "kotlin.jvm.PlatformType", "getContentLayoutId", "getGenderDrawable", "gender", "getGenderTagColor", "getLoadingImageUrl", "getMaritalStatusTagColor", "getNearbyNowDataTagColor", "getPunsihViewHideIndex", "getSelectedTabIndex", "getTitleRightViewImgClickListener", "Landroid/view/View$OnClickListener;", "initNowAnchorUI", "initTabs", "initTitleNameLayout", "initViews", "parent", "initYanzhiUI", "needChangeButtonColor", "onImageChange", "drawable", "Landroid/graphics/drawable/Drawable;", "onSwitchToEditPanel", "reportPageSelected", "i", "savePhotots", "setFansAndFollowNumber", "fansCount", "followCount", "setGodFlag", "setPhotos", "setSelectedTab", "tabIndex", "animated", "setTags", "setUerName", "name", "showVerifiedDialog", "updateBottomBtn", "index", "dataType", "updateLikeBtn", "updateLikeBtnFromClick", "isFree", "uploadPhoto", "Companion", "qqnearby_impl_release"}, k=1, mv={1, 1, 16})
public final class NewNearbyProfileDisplayPanel
  extends NearbyProfileDisplayPanel
{
  public static final NewNearbyProfileDisplayPanel.Companion ar = new NewNearbyProfileDisplayPanel.Companion(null);
  private PicInfo aA;
  private ArrayList<PicInfo> aB = new ArrayList();
  private ArrayList<PicInfo> aC = new ArrayList();
  private final TransProcessorHandler aD = (TransProcessorHandler)new NewNearbyProfileDisplayPanel.picUploadHandler.1(this);
  private final List<kotlin.Pair<TextView, View>> aE = (List)new ArrayList();
  private int aF;
  private final NearbyProfileImageDisplayAdapter as = new NearbyProfileImageDisplayAdapter(this);
  private ImageView at;
  private View au;
  private NearbyCoverView av;
  private View aw;
  private View ax;
  private PicInfo ay;
  private boolean az;
  
  public NewNearbyProfileDisplayPanel(@NotNull NearbyPeopleProfileActivity paramNearbyPeopleProfileActivity)
  {
    super(paramNearbyPeopleProfileActivity);
  }
  
  private final void L()
  {
    NearbyPeopleProfileActivity localNearbyPeopleProfileActivity = this.e;
    QLog.i("NewNearbyProfileDisplay", 2, "savePhotots");
    INearbyCardHandler localINearbyCardHandler = localNearbyPeopleProfileActivity.mCardHandler;
    if (localINearbyCardHandler != null)
    {
      localNearbyPeopleProfileActivity.showWaitingDialog(HardCodeUtil.a(2131905183));
      ArrayList localArrayList = new ArrayList((Collection)this.k);
      localArrayList.addAll((Collection)this.aC);
      localNearbyPeopleProfileActivity.app.execute((Runnable)new NewNearbyProfileDisplayPanel.savePhotots..inlined.apply.lambda.1(localINearbyCardHandler, localArrayList, localNearbyPeopleProfileActivity, this));
    }
  }
  
  private final void M()
  {
    if (this.aB.isEmpty()) {
      return;
    }
    Object localObject = new StringBuilder(HardCodeUtil.a(2131905140));
    ((StringBuilder)localObject).append(this.aB.size());
    ((StringBuilder)localObject).append(")...");
    this.e.showWaitingDialog(((StringBuilder)localObject).toString());
    localObject = this.aB.remove(0);
    Intrinsics.checkExpressionValueIsNotNull(localObject, "uploadingPics.removeAt(0)");
    localObject = (PicInfo)localObject;
    CompressInfo localCompressInfo = new CompressInfo(((PicInfo)localObject).d, 0);
    localCompressInfo.o = 0;
    ((ICompressOperator)QRoute.api(ICompressOperator.class)).start(localCompressInfo);
    if (!StringUtil.isEmpty(localCompressInfo.l))
    {
      TransferRequest localTransferRequest = new TransferRequest();
      localTransferRequest.mIsUp = true;
      localTransferRequest.mLocalPath = localCompressInfo.l;
      localTransferRequest.mFileType = 8;
      ((ITransFileController)this.e.app.getRuntimeService(ITransFileController.class)).transferAsync(localTransferRequest);
      this.aA = ((PicInfo)localObject);
      return;
    }
    M();
  }
  
  private final void c(NearbyPeopleCard paramNearbyPeopleCard)
  {
    Object localObject3 = (Map)new LinkedHashMap();
    Object localObject1 = paramNearbyPeopleCard.commonTag;
    int i = 1;
    Object localObject4;
    if (localObject1 != null)
    {
      localObject1 = ((NowSummaryCard.CommonTag)localObject1).tag;
      if (localObject1 != null)
      {
        localObject1 = ((PBRepeatMessageField)localObject1).get();
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (NowSummaryCard.CommonTag.Tag)((Iterator)localObject1).next();
            localObject2 = ((NowSummaryCard.CommonTag.Tag)localObject4).name.get();
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "list");
            if ((((Collection)localObject2).isEmpty() ^ true))
            {
              localObject4 = ((NowSummaryCard.CommonTag.Tag)localObject4).topic.get();
              Intrinsics.checkExpressionValueIsNotNull(localObject4, "topic");
              ((Map)localObject3).put(localObject4, localObject2);
            }
          }
        }
      }
    }
    localObject1 = (ViewGroup)this.a.findViewById(2131439161);
    if (((Map)localObject3).isEmpty())
    {
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "layout");
      ((ViewGroup)localObject1).setVisibility(8);
      return;
    }
    ((ViewGroup)localObject1).removeAllViews();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "layout");
    ((ViewGroup)localObject1).setVisibility(0);
    Object localObject2 = LayoutInflater.from(((ViewGroup)localObject1).getContext());
    localObject3 = ((Map)localObject3).entrySet().iterator();
    Object localObject6;
    Object localObject5;
    while (((Iterator)localObject3).hasNext())
    {
      localObject4 = (Map.Entry)((Iterator)localObject3).next();
      localObject6 = (String)((Map.Entry)localObject4).getKey();
      Object localObject7 = (List)((Map.Entry)localObject4).getValue();
      localObject4 = ((LayoutInflater)localObject2).inflate(1946484750, (ViewGroup)localObject1, false);
      localObject5 = (ViewGroup)((View)localObject4).findViewById(1946419226);
      Object localObject8 = (TextView)((View)localObject4).findViewById(1946419231);
      Intrinsics.checkExpressionValueIsNotNull(localObject8, "text");
      ((TextView)localObject8).setText((CharSequence)localObject6);
      localObject6 = ((Iterable)localObject7).iterator();
      while (((Iterator)localObject6).hasNext())
      {
        localObject7 = (String)((Iterator)localObject6).next();
        localObject8 = ((LayoutInflater)localObject2).inflate(1946484749, (ViewGroup)localObject5, false);
        TextView localTextView = (TextView)((View)localObject8).findViewById(1946419231);
        Intrinsics.checkExpressionValueIsNotNull(localTextView, "itemText");
        localTextView.setText((CharSequence)localObject7);
        ((ViewGroup)localObject5).addView((View)localObject8);
      }
      ((ViewGroup)localObject1).addView((View)localObject4);
    }
    localObject3 = paramNearbyPeopleCard.recentlyJoinedGroup;
    if (localObject3 != null)
    {
      localObject4 = ((android.util.Pair)localObject3).second;
      Intrinsics.checkExpressionValueIsNotNull(localObject4, "it.second");
      if (((CharSequence)localObject4).length() != 0) {
        i = 0;
      }
      if (i != 0) {
        return;
      }
      localObject4 = ((LayoutInflater)localObject2).inflate(1946484747, (ViewGroup)localObject1, false);
      localObject5 = (TextView)((View)localObject4).findViewById(1946419231);
      localObject6 = this.e.app;
      Intrinsics.checkExpressionValueIsNotNull(localObject6, "mActivity.app");
      if (Intrinsics.areEqual(((QQAppInterface)localObject6).getCurrentUin(), paramNearbyPeopleCard.uin)) {
        i = 1946615822;
      } else {
        i = 1946615823;
      }
      ((TextView)localObject5).setText(i);
      ((TextView)((View)localObject4).findViewById(1946419202)).setText((CharSequence)((android.util.Pair)localObject3).second);
      ((View)localObject4).setOnClickListener((View.OnClickListener)new NewNearbyProfileDisplayPanel.setTags..inlined.let.lambda.1((android.util.Pair)localObject3, this, (LayoutInflater)localObject2, (ViewGroup)localObject1, paramNearbyPeopleCard));
      ((ViewGroup)localObject1).addView((View)localObject4);
    }
  }
  
  private final void d(int paramInt)
  {
    if (this.aF == paramInt) {
      return;
    }
    this.aF = paramInt;
    ThreadCenter.postDefaultUITask((Runnable)new NewNearbyProfileDisplayPanel.selectedTabIndex.1(this, paramInt));
  }
  
  protected void A() {}
  
  @NotNull
  protected android.util.Pair<String, String> B()
  {
    return new android.util.Pair("#F0E5FF", "#6B24DA");
  }
  
  @NotNull
  protected android.util.Pair<String, String> C()
  {
    return new android.util.Pair("#E4E6FF", "#4753DA");
  }
  
  @NotNull
  protected android.util.Pair<String, String> D()
  {
    return new android.util.Pair("#FCDD68", "#D40301");
  }
  
  protected void E()
  {
    this.as.notifyDataSetChanged();
  }
  
  @NotNull
  protected View.OnClickListener F()
  {
    return (View.OnClickListener)new NewNearbyProfileDisplayPanel.getTitleRightViewImgClickListener.1(this);
  }
  
  protected void G()
  {
    Object localObject = this.e;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "mActivity");
    localObject = ((NearbyPeopleProfileActivity)localObject).getSupportFragmentManager();
    NearbyProfileSendMsgDialog.Companion localCompanion = NearbyProfileSendMsgDialog.a;
    Intrinsics.checkExpressionValueIsNotNull(localObject, "it");
    localCompanion.a((FragmentManager)localObject, (NearbyProfileDisplayPanel)this);
  }
  
  protected boolean H()
  {
    return false;
  }
  
  public final boolean J()
  {
    return this.aA == null;
  }
  
  public final void K()
  {
    this.az = true;
  }
  
  @NotNull
  protected TextView a(@NotNull android.util.Pair<String, String> paramPair, @Nullable String paramString, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramPair, "color");
    TextView localTextView = new TextView(this.b);
    localTextView.setTextSize(2, 10.0F);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, DisplayUtil.a(this.b, 5.0F), 0);
    localTextView.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = new GradientDrawable();
    ((GradientDrawable)localObject).setColor(Color.parseColor((String)paramPair.first));
    ((GradientDrawable)localObject).setCornerRadius(DisplayUtil.a(this.b, 3.0F));
    ViewExtKt.a((View)localTextView, (Drawable)localObject);
    int j = Color.parseColor((String)paramPair.second);
    localTextView.setTextColor(j);
    paramPair = (CharSequence)paramString;
    localTextView.setText(paramPair);
    int i = DisplayUtil.a(this.b, 8.5F);
    int k = DisplayUtil.a(this.b, 4.0F);
    localTextView.setPadding(i, k, i, k);
    localTextView.setGravity(17);
    if (paramInt1 > 0)
    {
      paramString = ContextCompat.getDrawable(this.b, paramInt1);
      i = 1;
      if (paramString != null)
      {
        DrawableCompat.setTint(paramString, j);
        if ((paramString instanceof BitmapDrawable)) {
          localTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)new BitmapDrawable(localTextView.getResources(), Bitmap.createScaledBitmap(((BitmapDrawable)paramString).getBitmap(), 25, 25, true)), null, null, null);
        } else {
          localTextView.setCompoundDrawablesWithIntrinsicBounds(paramString, null, null, null);
        }
      }
      paramInt1 = i;
      if (paramPair != null) {
        if (paramPair.length() == 0) {
          paramInt1 = i;
        } else {
          paramInt1 = 0;
        }
      }
      if (paramInt1 == 0) {
        localTextView.setCompoundDrawablePadding(paramInt2);
      }
    }
    return localTextView;
  }
  
  protected void a(int paramInt) {}
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    d(paramInt);
    Iterator localIterator = ((Iterable)this.aE).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject = localIterator.next();
      if (i < 0) {
        CollectionsKt.throwIndexOverflow();
      }
      kotlin.Pair localPair = (kotlin.Pair)localObject;
      int j;
      if (i == paramInt)
      {
        localObject = "#000000";
        j = 0;
      }
      else
      {
        localObject = "#777777";
        j = 4;
      }
      ((TextView)localPair.getFirst()).setTextColor(Color.parseColor((String)localObject));
      ((View)localPair.getSecond()).setVisibility(j);
      i += 1;
    }
  }
  
  public final void a(@NotNull Drawable paramDrawable, @NotNull PicInfo paramPicInfo)
  {
    Intrinsics.checkParameterIsNotNull(paramDrawable, "drawable");
    Intrinsics.checkParameterIsNotNull(paramPicInfo, "picInfo");
    this.ay = paramPicInfo;
    paramPicInfo = this.at;
    if (paramPicInfo == null) {
      Intrinsics.throwUninitializedPropertyAccessException("bigImageView");
    }
    paramPicInfo.setImageDrawable(paramDrawable);
  }
  
  protected void a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "parent");
    super.a(paramView);
    Object localObject1 = (RecyclerView)paramView.findViewById(2131444519);
    ((RecyclerView)localObject1).setLayoutManager((RecyclerView.LayoutManager)new LinearLayoutManager(((RecyclerView)localObject1).getContext(), 0, false));
    ((RecyclerView)localObject1).setAdapter((RecyclerView.Adapter)this.as);
    localObject1 = paramView.findViewById(2131429425);
    Object localObject2 = (ImageView)localObject1;
    ((ImageView)localObject2).setOnTouchListener((View.OnTouchListener)new NewNearbyProfileDisplayPanel.initViews.2.1());
    ((ImageView)localObject2).setOnClickListener((View.OnClickListener)new NewNearbyProfileDisplayPanel.initViews..inlined.apply.lambda.1((ImageView)localObject2, this, paramView));
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "parent.findViewById<Imag…)\n            }\n        }");
    this.at = ((ImageView)localObject2);
    ((ImageView)paramView.findViewById(2131440861)).setImageResource(1946353696);
    localObject1 = this.i;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "mTitleLeftView");
    ((TextView)localObject1).setText((CharSequence)"");
    this.g.setTopOffset(UIUtils.a(this.b, 120.0F) + ImmersiveUtils.getStatusBarHeight(this.b));
    localObject1 = paramView.findViewById(2131429453);
    ((View)localObject1).setOnClickListener((View.OnClickListener)new NewNearbyProfileDisplayPanel.initViews..inlined.apply.lambda.2(this));
    ((View)localObject1).setBackgroundResource(1946353699);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "parent.findViewById<View…_msg_button_bg)\n        }");
    this.au = ((View)localObject1);
    localObject1 = paramView.findViewById(2131431458);
    localObject2 = (NearbyCoverView)localObject1;
    ((NearbyCoverView)localObject2).setLoading(true);
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "parent.findViewById<Near…sLoading = true\n        }");
    this.av = ((NearbyCoverView)localObject2);
    NearbyStatusBarHelper.a(paramView);
    paramView.findViewById(2131447722).setOnClickListener((View.OnClickListener)NewNearbyProfileDisplayPanel.initViews.6.1.a);
    this.j.setImageResource(1946353682);
  }
  
  public void a(@NotNull NearbyPeopleCard paramNearbyPeopleCard)
  {
    Intrinsics.checkParameterIsNotNull(paramNearbyPeopleCard, "card");
    super.a(paramNearbyPeopleCard);
    Object localObject1 = this.av;
    if (localObject1 == null) {
      Intrinsics.throwUninitializedPropertyAccessException("coverView");
    }
    ((NearbyCoverView)localObject1).setLoading(false);
    TextView localTextView = (TextView)this.a.findViewById(2131449284);
    localObject1 = paramNearbyPeopleCard.xuanYan;
    Object localObject3;
    Object localObject2;
    int i;
    int j;
    int k;
    int m;
    if (paramNearbyPeopleCard.nowUserType == 0)
    {
      if (localObject1 == null) {
        break label912;
      }
      localObject3 = (RichStatus)null;
      try
      {
        localObject1 = RichStatus.parseStatus((byte[])localObject1);
        localObject3 = localObject1;
      }
      catch (RuntimeException localRuntimeException)
      {
        localObject4 = new StringBuilder();
        ((StringBuilder)localObject4).append("RichStatus parseStatus error: ");
        ((StringBuilder)localObject4).append(localRuntimeException);
        QLog.e("NearbyProfileFragment", 1, ((StringBuilder)localObject4).toString());
      }
      localObject2 = (SpannableString)null;
      if (localObject3 != null) {
        localObject2 = ((RichStatus)localObject3).toSpannableString(null, -8947849, -16777216);
      }
      Object localObject4 = localObject2;
      if (localObject2 == null) {
        localObject4 = new SpannableString((CharSequence)"");
      }
      localTextView.setVisibility(0);
      if (localObject3 != null)
      {
        localObject2 = (CharSequence)((RichStatus)localObject3).actionText;
        if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
          i = 0;
        } else {
          i = 1;
        }
        if (i == 0)
        {
          localObject4 = new SpannableStringBuilder((CharSequence)localObject4);
          ((SpannableStringBuilder)localObject4).insert(0, (CharSequence)"[S] ");
          if (this.e.mStatusManager != null)
          {
            localObject2 = this.e.mStatusManager.a(((RichStatus)localObject3).actionId, 200);
          }
          else
          {
            localObject2 = this.e;
            Intrinsics.checkExpressionValueIsNotNull(localObject2, "mActivity");
            localObject2 = BitmapManager.a(((NearbyPeopleProfileActivity)localObject2).getResources(), 2130851609);
          }
          localObject3 = this.e;
          Intrinsics.checkExpressionValueIsNotNull(localObject3, "mActivity");
          localObject2 = (BitmapDrawable)new StatableBitmapDrawable(((NearbyPeopleProfileActivity)localObject3).getResources(), (Bitmap)localObject2, false, false);
          i = (int)(localTextView.getTextSize() * 1.1F + 0.5F);
          ((BitmapDrawable)localObject2).setBounds(0, 0, i, i);
          localObject2 = new OffsetableImageSpan((Drawable)localObject2, 0);
          ((OffsetableImageSpan)localObject2).setOffset(-0.1F);
          ((SpannableStringBuilder)localObject4).setSpan(localObject2, 0, 3, 17);
          localTextView.setText((CharSequence)localTextView.getContext().getString(1946615830, new Object[] { localObject4 }));
          break label912;
        }
      }
      localObject2 = ((SpannableString)localObject4).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "ss.toString()");
      localObject2 = StringUtil.trim((String)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "StringUtil.trim(text)");
      localObject2 = (CharSequence)localObject2;
      if ((localObject2 != null) && (((CharSequence)localObject2).length() != 0)) {
        i = 0;
      } else {
        i = 1;
      }
      if (i == 0)
      {
        Intrinsics.checkExpressionValueIsNotNull(localTextView, "this");
        localObject3 = localTextView.getContext();
        i = ((CharSequence)localObject2).length() - 1;
        j = 0;
        k = 0;
        while (j <= i)
        {
          if (k == 0) {
            m = j;
          } else {
            m = i;
          }
          if (((CharSequence)localObject2).charAt(m) <= ' ') {
            m = 1;
          } else {
            m = 0;
          }
          if (k == 0)
          {
            if (m == 0) {
              k = 1;
            } else {
              j += 1;
            }
          }
          else
          {
            if (m == 0) {
              break;
            }
            i -= 1;
          }
        }
        localTextView.setText((CharSequence)((Context)localObject3).getString(1946615830, new Object[] { ((CharSequence)localObject2).subSequence(j, i + 1).toString() }));
      }
      else if (this.e.mMode == 2)
      {
        localTextView.setText((CharSequence)this.e.getString(2131892172));
      }
      else
      {
        localTextView.setVisibility(8);
      }
    }
    label912:
    label1052:
    for (;;)
    {
      try
      {
        Intrinsics.checkExpressionValueIsNotNull(localObject2, "richStatus");
        localObject3 = Charset.forName("utf-8");
        Intrinsics.checkExpressionValueIsNotNull(localObject3, "Charset.forName(\"utf-8\")");
        localObject3 = new String((byte[])localObject2, (Charset)localObject3);
        if (((CharSequence)localObject3).length() <= 0) {
          break label986;
        }
        i = 1;
        if (i != 0)
        {
          Intrinsics.checkExpressionValueIsNotNull(localTextView, "this");
          localObject2 = localTextView.getContext();
          localObject3 = (CharSequence)localObject3;
          j = ((CharSequence)localObject3).length() - 1;
          i = 0;
          k = 0;
          break label991;
          if (((CharSequence)localObject3).charAt(m) > ' ') {
            break label1013;
          }
          m = 1;
          break label1016;
          label816:
          localTextView.setText((CharSequence)((Context)localObject2).getString(1946615830, new Object[] { ((CharSequence)localObject3).subSequence(i, j + 1).toString() }));
          localTextView.setVisibility(0);
        }
        else
        {
          localTextView.setVisibility(8);
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("setXuanyan wx error, e=");
        ((StringBuilder)localObject3).append(localUnsupportedEncodingException);
        QLog.i("NearbyProfileFragment", 1, ((StringBuilder)localObject3).toString());
      }
      c(paramNearbyPeopleCard);
      if (paramNearbyPeopleCard.isVerified) {
        ((ImageView)this.a.findViewById(2131449359)).setImageResource(1946353695);
      }
      this.aD.addFilter(new Class[] { NearbyPeoplePhotoUploadProcessor.class });
      ((ITransFileController)this.e.app.getRuntimeService(ITransFileController.class)).addHandle(this.aD);
      return;
      label986:
      i = 0;
      continue;
      for (;;)
      {
        label991:
        if (i > j) {
          break label1052;
        }
        if (k == 0)
        {
          m = i;
          break;
        }
        m = j;
        break;
        label1013:
        m = 0;
        label1016:
        if (k == 0)
        {
          if (m == 0) {
            k = 1;
          } else {
            i += 1;
          }
        }
        else
        {
          if (m == 0) {
            break label816;
          }
          j -= 1;
        }
      }
    }
  }
  
  public void a(@NotNull PicInfo paramPicInfo, @Nullable RelativeLayout paramRelativeLayout)
  {
    Intrinsics.checkParameterIsNotNull(paramPicInfo, "info");
    this.as.a(paramPicInfo.b);
  }
  
  protected void a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    TextView localTextView = (TextView)this.a.findViewById(2131449279);
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "tv");
    localTextView.setText((CharSequence)paramString);
  }
  
  public boolean a(@Nullable Intent paramIntent)
  {
    if (!this.az) {
      return false;
    }
    this.az = false;
    if (paramIntent != null) {
      paramIntent = paramIntent.getStringArrayListExtra("PhotoConst.PHOTO_PATHS");
    } else {
      paramIntent = null;
    }
    Object localObject = (Collection)paramIntent;
    int i;
    if ((localObject != null) && (!((Collection)localObject).isEmpty())) {
      i = 0;
    } else {
      i = 1;
    }
    if (i != 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("NearbyPublishMenuHelper", 2, "path is empty return");
      }
      return false;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("select photo result, path=");
    ((StringBuilder)localObject).append(paramIntent);
    QLog.d("NearbyPublishMenuHelper", 1, ((StringBuilder)localObject).toString());
    localObject = (Iterable)paramIntent;
    paramIntent = (Collection)new ArrayList(CollectionsKt.collectionSizeOrDefault((Iterable)localObject, 10));
    localObject = ((Iterable)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      PicInfo localPicInfo = new PicInfo();
      localPicInfo.d = str;
      paramIntent.add(localPicInfo);
    }
    paramIntent = (List)paramIntent;
    localObject = this.aB;
    ((ArrayList)localObject).clear();
    ((ArrayList)localObject).addAll((Collection)paramIntent);
    M();
    return true;
  }
  
  protected int b()
  {
    return 2131627570;
  }
  
  protected int b(int paramInt)
  {
    if (paramInt == 0) {
      return 1946353688;
    }
    return 1946353681;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    TextView localTextView = this.m;
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "mFansNumTextView");
    localTextView.setText((CharSequence)String.valueOf(paramInt1));
    localTextView = this.l;
    Intrinsics.checkExpressionValueIsNotNull(localTextView, "mFollowNumTextView");
    localTextView.setText((CharSequence)String.valueOf(paramInt2));
  }
  
  public void b(boolean paramBoolean)
  {
    this.aC.clear();
  }
  
  @NotNull
  protected android.util.Pair<String, String> c(int paramInt)
  {
    String str2;
    String str1;
    if (paramInt != 1)
    {
      str2 = "#E2EDFF";
      str1 = "#3775DA";
    }
    else
    {
      str2 = "#FFE5F3";
      str1 = "#E73695";
    }
    return new android.util.Pair(str2, str1);
  }
  
  protected void c(int paramInt1, int paramInt2)
  {
    super.c(paramInt1, paramInt2);
    if (paramInt2 != 8)
    {
      if (paramInt2 != 60) {
        return;
      }
      localTextView = (TextView)this.h.getChildAt(paramInt1).findViewById(2131448897);
      localTextView.setBackgroundResource(1946353666);
      Object localObject;
      if (this.T)
      {
        localObject = this.au;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("sendMsgBigView");
        }
        ((View)localObject).setVisibility(0);
        localObject = this.h;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mDisplayBottomBtns");
        ((ViewGroup)localObject).setVisibility(8);
      }
      else
      {
        Intrinsics.checkExpressionValueIsNotNull(localTextView, "tv");
        localTextView.setText((CharSequence)"关注");
        localTextView.setTextColor(-1);
        localObject = this.au;
        if (localObject == null) {
          Intrinsics.throwUninitializedPropertyAccessException("sendMsgBigView");
        }
        ((View)localObject).setVisibility(8);
        localObject = this.h;
        Intrinsics.checkExpressionValueIsNotNull(localObject, "mDisplayBottomBtns");
        ((ViewGroup)localObject).setVisibility(0);
      }
      this.aw = ((View)localTextView);
      return;
    }
    TextView localTextView = (TextView)this.h.getChildAt(paramInt1).findViewById(2131448897);
    this.ax = ((View)localTextView);
    localTextView.setTextColor(-1);
    localTextView.setBackgroundResource(1946353699);
  }
  
  protected void c(boolean paramBoolean) {}
  
  public void k()
  {
    super.k();
    ((ITransFileController)this.e.app.getRuntimeService(ITransFileController.class)).removeHandle(this.aD);
  }
  
  public void l() {}
  
  public void p()
  {
    Object localObject = this.f;
    if (localObject != null)
    {
      long l = ((NearbyPeopleCard)localObject).tinyId;
      localObject = this.e.app;
      Intrinsics.checkExpressionValueIsNotNull(localObject, "mActivity.app");
      NearbySendMsgHelper.a((QQAppInterface)localObject, l, String.valueOf(l), 1001, "你悄悄的看了Ta，主动打个招呼吧！", null);
      super.p();
    }
  }
  
  public void q()
  {
    ((ITransFileController)this.e.app.getRuntimeService(ITransFileController.class)).removeHandle(this.aD);
  }
  
  @NotNull
  protected String r()
  {
    return "https://dldir1.qq.com/huayang/qq/images/76b8502dfdeaa7e0b68992999351a2bb.png";
  }
  
  protected void u() {}
  
  protected int v()
  {
    return this.aF;
  }
  
  protected void w()
  {
    NewNearbyProfileDisplayPanel.initTabs..inlined.apply.lambda.1 local1 = new NewNearbyProfileDisplayPanel.initTabs..inlined.apply.lambda.1((ViewGroup)this.a.findViewById(2131439248), this);
    this.ac = 0;
    local1.invoke(2131905105);
    t();
    this.ab = 1;
    local1.invoke(2131905160);
    s();
  }
  
  protected int x()
  {
    return 0;
  }
  
  public void y() {}
  
  protected void z() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NewNearbyProfileDisplayPanel
 * JD-Core Version:    0.7.0.1
 */