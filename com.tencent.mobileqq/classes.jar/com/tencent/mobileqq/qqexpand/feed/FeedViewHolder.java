package com.tencent.mobileqq.qqexpand.feed;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo.SchoolInfo;
import com.tencent.mobileqq.qqexpand.fragment.SquareItemClickListener;
import com.tencent.mobileqq.qqexpand.utils.ExtendFriendLabelUtils;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.ProfileGuideDialogUtils;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendFeedView;
import com.tencent.mobileqq.qqexpand.widget.ExtendFriendLabelFlowLayout;
import com.tencent.mobileqq.qqexpand.widget.voice.OldExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.SignatureTemplateInfo;
import com.tencent.mobileqq.vas.VasResEngine.VasRes;
import com.tencent.mobileqq.vas.VasResEngine.VasResAdapter;
import com.tencent.mobileqq.vas.VasResEngine.VasResDrawable;
import com.tencent.mobileqq.vas.adapter.SignatureAdapter;
import com.tencent.mobileqq.vas.adapter.SignatureFontAdapter;
import com.tencent.mobileqq.vas.webview.util.VasWebviewUtil;
import cooperation.qzone.widget.QzoneEmotionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class FeedViewHolder
  extends RecyclerView.ViewHolder
  implements View.OnClickListener
{
  private ExtendFriendLabelListAdapter A;
  public ExtendFriendFeedView a;
  public View b;
  public ImageView c;
  public TextView d;
  public ImageView e;
  public TextView f;
  public LinearLayout g;
  public ImageView h;
  public ImageView i;
  public ETTextView j;
  public OldExpandVoiceView k;
  public ImageView l;
  public ImageView m;
  private final SquareItemClickListener n;
  private final FaceFetch o;
  private VasRes p;
  private int q;
  private int r;
  private boolean s = false;
  private boolean t = false;
  private int u = 0;
  private int v = 0;
  private int w = 0;
  private final QBaseActivity x;
  private final QQAppInterface y;
  private final ExtendFriendLabelFlowLayout z;
  
  public FeedViewHolder(View paramView, SquareItemClickListener paramSquareItemClickListener, FaceFetch paramFaceFetch, Activity paramActivity)
  {
    super(paramView);
    this.a = ((ExtendFriendFeedView)paramView);
    this.o = paramFaceFetch;
    this.n = paramSquareItemClickListener;
    paramSquareItemClickListener = (QBaseActivity)paramActivity;
    this.x = paramSquareItemClickListener;
    this.y = ((QQAppInterface)this.x.getAppRuntime());
    this.b = paramView.findViewById(1912930335);
    this.c = ((ImageView)paramView.findViewById(1912930366));
    this.d = ((TextView)paramView.findViewById(1912930455));
    this.e = ((ImageView)paramView.findViewById(1912930368));
    this.f = ((TextView)paramView.findViewById(1912930449));
    this.g = ((LinearLayout)paramView.findViewById(1912930374));
    this.h = ((ImageView)paramView.findViewById(1912930317));
    this.i = ((ImageView)paramView.findViewById(1912930316));
    this.z = ((ExtendFriendLabelFlowLayout)paramView.findViewById(1912930342));
    this.j = ((ETTextView)paramView.findViewById(1912930454));
    this.k = ((OldExpandVoiceView)paramView.findViewById(1912930367));
    this.l = ((ImageView)paramView.findViewById(1912930318));
    this.m = ((ImageView)paramView.findViewById(1912930458));
    this.m.setOnClickListener(this);
    this.b.setOnTouchListener((View.OnTouchListener)paramView);
    this.b.setOnClickListener(this);
    this.c.setOnClickListener(this);
    this.c.setOnTouchListener(ProfileGuideDialogUtils.a);
    this.h.setOnClickListener(this);
    this.i.setOnClickListener(this);
    this.k.setMode(1);
    this.k.setOnClickListener(this);
    this.k.setActivity(paramSquareItemClickListener);
    this.k.b(true);
    this.l.setOnClickListener(this);
  }
  
  private void e()
  {
    this.t = false;
    this.s = false;
    this.v = 0;
    this.w = 0;
    this.u = 0;
    this.j.setFont(0, System.currentTimeMillis());
    this.b.setBackground(null);
  }
  
  public void a(int paramInt)
  {
    if (paramInt > 10000)
    {
      this.u = paramInt;
      this.t = true;
      this.b.setVisibility(0);
      if ((this.b.getBackground() instanceof VasResDrawable))
      {
        ((VasResDrawable)this.b.getBackground()).a(paramInt);
        return;
      }
      VasResDrawable localVasResDrawable = new VasResDrawable(this.y, paramInt);
      SignatureAdapter localSignatureAdapter = new SignatureAdapter(localVasResDrawable, this.y, 2130847784);
      localSignatureAdapter.a(true);
      localSignatureAdapter.a(new FeedViewHolder.1(this));
      localVasResDrawable.a(localSignatureAdapter);
      this.b.setBackgroundDrawable(localVasResDrawable);
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (paramInt1 != 0)
    {
      if (this.x == null) {
        return;
      }
      this.j.setVisibility(0);
      this.j.setFont(0, System.currentTimeMillis());
      this.j.mMsgId = System.currentTimeMillis();
      this.s = true;
      this.v = paramInt1;
      this.w = paramInt2;
      Object localObject = this.p;
      if (localObject == null)
      {
        this.p = new VasRes(this.y, paramInt1);
        localObject = new SignatureFontAdapter(this.p, this.y, paramInt2);
        localETTextView = this.j;
        ((SignatureFontAdapter)localObject).a(localETTextView, localETTextView.getTextSize(), true);
        this.p.a((VasResAdapter)localObject);
        ((SignatureFontAdapter)localObject).a(-1);
        return;
      }
      localObject = (SignatureFontAdapter)((VasRes)localObject).c();
      ETTextView localETTextView = this.j;
      ((SignatureFontAdapter)localObject).a(localETTextView, localETTextView.getTextSize(), true);
      ((SignatureFontAdapter)this.p.c()).a(paramInt1, paramInt2);
    }
  }
  
  public void a(FeedViewHolder paramFeedViewHolder, StrangerInfo paramStrangerInfo, int paramInt)
  {
    if (paramStrangerInfo.mIsMyFeed)
    {
      paramFeedViewHolder.h.setVisibility(8);
      paramFeedViewHolder.i.setVisibility(8);
    }
    else
    {
      paramFeedViewHolder.h.setVisibility(0);
      paramFeedViewHolder.i.setVisibility(0);
    }
    if (!paramStrangerInfo.mbAllowStrangerVote) {
      paramFeedViewHolder.h.setVisibility(8);
    }
    Object localObject1 = paramFeedViewHolder.k;
    if (TextUtils.isEmpty(paramStrangerInfo.mVoiceUrl)) {
      i1 = 8;
    } else {
      i1 = 0;
    }
    ((OldExpandVoiceView)localObject1).setVisibility(i1);
    int i1 = paramFeedViewHolder.getPosition();
    paramFeedViewHolder.a.setFeedBgParams(i1, paramStrangerInfo.mVoiceUrl, paramInt);
    paramFeedViewHolder.k.setVoiceUrl(paramStrangerInfo.mVoiceUrl);
    paramFeedViewHolder.k.setVoiceDuration(paramStrangerInfo.mVoiceDuration);
    localObject1 = this.o.a(paramStrangerInfo.mUin, paramStrangerInfo.mNickName, paramFeedViewHolder.c);
    paramFeedViewHolder.c.setImageDrawable((Drawable)localObject1);
    paramFeedViewHolder.d.setText(paramStrangerInfo.mNickName);
    paramFeedViewHolder.j.setTextMsg(new QQText(QzoneEmotionUtils.emCodesToQQcodes(paramStrangerInfo.mDeclaration), 3, 24));
    paramFeedViewHolder.j.setTextColor(-16777216);
    localObject1 = paramFeedViewHolder.h;
    if (paramStrangerInfo.mLiked)
    {
      if (paramStrangerInfo.mAvailLikeCount == 0) {
        paramInt = 2130846586;
      } else {
        paramInt = 2130846585;
      }
    }
    else {
      paramInt = 2130846582;
    }
    ((ImageView)localObject1).setImageResource(paramInt);
    VipUtils.a(paramStrangerInfo, paramFeedViewHolder.m);
    paramFeedViewHolder.m.setTag(paramStrangerInfo);
    e();
    if (!SimpleUIUtil.e())
    {
      a(paramStrangerInfo.clothesId);
      a(paramStrangerInfo.fontId, paramStrangerInfo.fontType);
    }
    localObject1 = new ArrayList();
    Object localObject2 = ExtendFriendLabelUtils.a(paramStrangerInfo, BaseApplicationImpl.getContext());
    if (localObject2 != null) {
      ((List)localObject1).add(localObject2);
    }
    localObject2 = ExtendFriendLabelUtils.b(paramStrangerInfo, BaseApplicationImpl.getContext());
    if (localObject2 != null) {
      ((List)localObject1).add(localObject2);
    }
    localObject2 = ExtendFriendLabelUtils.c(paramStrangerInfo, BaseApplicationImpl.getContext());
    if ((localObject2 != null) && (((List)localObject2).size() > 0)) {
      ((List)localObject1).addAll((Collection)localObject2);
    }
    if (((List)localObject1).size() > 0)
    {
      paramFeedViewHolder.z.setVisibility(0);
      localObject2 = paramFeedViewHolder.A;
      if (localObject2 != null) {
        ((ExtendFriendLabelListAdapter)localObject2).a();
      } else {
        paramFeedViewHolder.A = new ExtendFriendLabelListAdapter(BaseApplicationImpl.getContext());
      }
      paramFeedViewHolder.A.a(this.t);
      paramFeedViewHolder.A.a((List)localObject1);
    }
    else
    {
      paramFeedViewHolder.z.setVisibility(8);
    }
    paramFeedViewHolder.z.setAdapter(paramFeedViewHolder.A);
    if ((paramStrangerInfo.mSchoolInfos != null) && (paramStrangerInfo.mSchoolInfos.size() > 0))
    {
      localObject1 = (StrangerInfo.SchoolInfo)paramStrangerInfo.mSchoolInfos.get(0);
      if (localObject1 != null)
      {
        this.g.setVisibility(0);
        if (!TextUtils.isEmpty(((StrangerInfo.SchoolInfo)localObject1).c)) {
          paramFeedViewHolder.f.setText(((StrangerInfo.SchoolInfo)localObject1).c);
        }
        if (((StrangerInfo.SchoolInfo)localObject1).b == 2L) {
          paramFeedViewHolder.e.setImageResource(2130846620);
        } else {
          paramFeedViewHolder.e.setImageResource(2130846621);
        }
      }
      else
      {
        this.g.setVisibility(8);
      }
    }
    else
    {
      this.g.setVisibility(8);
    }
    if ((!this.t) && (!this.s)) {
      paramFeedViewHolder = "1";
    } else {
      paramFeedViewHolder = "2";
    }
    VasWebviewUtil.a("strangers_makefriend", "plaza_show", "", 0, "", paramFeedViewHolder);
    paramFeedViewHolder = new HashMap();
    paramFeedViewHolder.put("feed_uid", paramStrangerInfo.mUin);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel("expose#voice_tab#feed", true, -1L, -1L, paramFeedViewHolder, true, true);
  }
  
  public void a(SignatureTemplateInfo paramSignatureTemplateInfo)
  {
    if (paramSignatureTemplateInfo == null) {
      return;
    }
    if ((paramSignatureTemplateInfo.j != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.j)))
    {
      this.q = Color.parseColor(paramSignatureTemplateInfo.j);
      ETTextView localETTextView = this.j;
      if (localETTextView != null)
      {
        int i1 = this.q;
        if (i1 != 0) {
          localETTextView.setTextColor(i1);
        }
      }
    }
    if ((paramSignatureTemplateInfo.A != null) && (!TextUtils.isEmpty(paramSignatureTemplateInfo.A)))
    {
      this.r = Color.parseColor(paramSignatureTemplateInfo.A);
      if (SignTextEditFragment.a(this.r))
      {
        this.d.setTextColor(-1);
        this.l.setColorFilter(null);
        return;
      }
      this.l.setColorFilter(-1291845633);
      this.d.setTextColor(-16777216);
    }
  }
  
  public boolean a()
  {
    return this.s;
  }
  
  public boolean b()
  {
    return this.t;
  }
  
  public int c()
  {
    return this.u;
  }
  
  public int d()
  {
    return this.v;
  }
  
  public void onClick(View paramView)
  {
    if (this.n != null)
    {
      long l1 = System.currentTimeMillis();
      if ((paramView.getId() != 1912930317) && (l1 - this.n.h() < 500L)) {
        return;
      }
      this.n.a(l1);
      int i1 = getPosition();
      switch (paramView.getId())
      {
      default: 
        return;
      case 2131449972: 
        this.n.c(i1);
        return;
      case 1912930458: 
        VipUtils.a(paramView, (StrangerInfo)paramView.getTag());
        return;
      case 1912930366: 
        this.n.a(i1, 1);
        return;
      case 1912930335: 
        this.n.a(i1, 2);
        return;
      case 1912930318: 
        this.n.f(i1);
        return;
      case 1912930317: 
        this.n.d(i1);
        return;
      }
      this.n.e(i1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.feed.FeedViewHolder
 * JD-Core Version:    0.7.0.1
 */