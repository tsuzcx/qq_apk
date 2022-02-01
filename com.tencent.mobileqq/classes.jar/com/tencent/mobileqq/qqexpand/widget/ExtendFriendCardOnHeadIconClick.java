package com.tencent.mobileqq.qqexpand.widget;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import com.tencent.biz.webviewplugin.NewReportPlugin;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqexpand.bean.chat.ExpandFriendData;
import com.tencent.mobileqq.qqexpand.chat.utils.LimitChatUtil;
import com.tencent.mobileqq.qqexpand.utils.IExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.URLDrawableDecodeHandler;
import com.tencent.mobileqq.qqexpand.widget.voice.ExpandVoiceView;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.widget.RoundedCornerImageViewNoPadding;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.Semaphore;
import mqq.os.MqqHandler;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ExtendFriendCardOnHeadIconClick
  extends QPublicBaseFragment
{
  public static ExtendFriendCardOnHeadIconClick.LRUCache<String, String> a = new ExtendFriendCardOnHeadIconClick.LRUCache(10, null);
  public static HashMap<String, Long> b = new HashMap();
  private String c;
  private String d;
  private int e;
  private String f;
  private List<String> g;
  private List<String> h;
  private String i;
  private int j;
  private String k;
  private String l;
  private boolean m = false;
  private JSONObject n;
  private String o;
  private String p;
  private int q;
  private int r;
  private Semaphore s;
  private BaseQQAppInterface t;
  private View u;
  
  private void a()
  {
    JSONObject localJSONObject = new JSONObject(this.o).optJSONObject("infos");
    this.c = localJSONObject.optString("avatar");
    Object localObject = localJSONObject.optJSONObject("base_info");
    if (localObject != null)
    {
      this.d = ((JSONObject)localObject).optString("nick");
      this.f = ((JSONObject)localObject).optString("constellation");
      this.e = ((JSONObject)localObject).optInt("gender");
    }
    localObject = localJSONObject.optJSONObject("expand_info");
    if (localObject != null)
    {
      this.i = ((JSONObject)localObject).optString("declarationa");
      this.k = ((JSONObject)localObject).optString("voice_url");
      this.j = ((JSONObject)localObject).optInt("voice_duration");
      this.l = ((JSONObject)localObject).optString("voice_color");
    }
    localObject = localJSONObject.optJSONArray("personal_labels");
    int i1;
    if (localObject != null)
    {
      i1 = 0;
      while (i1 < ((JSONArray)localObject).length())
      {
        this.g.add(((JSONArray)localObject).optString(i1));
        i1 += 1;
      }
    }
    localObject = localJSONObject.optJSONObject("pictures_wall_urls");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).optJSONArray("pictures_wall_pic");
      if (localObject != null)
      {
        i1 = 0;
        while (i1 < ((JSONArray)localObject).length())
        {
          this.h.add(((JSONArray)localObject).optString(i1));
          i1 += 1;
        }
      }
    }
    this.m = localJSONObject.has("wangzhe_record");
    if (this.m)
    {
      this.n = localJSONObject.optJSONObject("wangzhe_record");
      if (this.n.length() == 0) {
        this.m = false;
      }
    }
    ExpandVoiceView.a(this.t);
  }
  
  private void a(View paramView, int paramInt)
  {
    List localList = this.h;
    if (localList != null)
    {
      if (localList.isEmpty()) {
        return;
      }
      a(paramView, paramInt, (ArrayList)this.h);
    }
  }
  
  private void a(View paramView, int paramInt, ArrayList<String> paramArrayList)
  {
    if ((paramView != null) && (paramArrayList != null))
    {
      if (paramArrayList.size() == 0) {
        return;
      }
      int i1;
      if (paramInt >= 0)
      {
        i1 = paramInt;
        if (paramInt < paramArrayList.size()) {}
      }
      else
      {
        i1 = 0;
      }
      paramView.setOnClickListener(new -..Lambda.ExtendFriendCardOnHeadIconClick.eNuK7RPS1br84Zn0PoVSzLOllfc(this, i1, paramArrayList, paramView));
    }
  }
  
  private void a(String paramString1, String paramString2, String paramString3, int paramInt)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("frompage", Integer.toString(paramInt));
    paramString1 = paramString1.concat("#").concat(paramString2).concat("#").concat(paramString3);
    ((IExpandReportUtils)QRoute.api(IExpandReportUtils.class)).onUserActionToTunnel(paramString1, true, -1L, -1L, localHashMap, true, true);
  }
  
  private void b()
  {
    if (!g())
    {
      localObject1 = (ImageView)this.u.findViewById(1912930412);
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(1912864768));
      ((ImageView)localObject1).setVisibility(0);
      localObject2 = (RelativeLayout)this.u.findViewById(1912930411);
      localObject3 = new LinearLayout.LayoutParams(-1, ViewUtils.dpToPx(207.0F));
      ((LinearLayout.LayoutParams)localObject3).topMargin = ViewUtils.dpToPx(8.0F);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = 0;
      ((RelativeLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject3);
      ((ImageView)localObject1).setOnClickListener(new -..Lambda.ExtendFriendCardOnHeadIconClick.1XIWGP_DsM6pW21NSff9MOo6muA(this));
    }
    Object localObject1 = (RoundedCornerImageViewNoPadding)this.u.findViewById(1912930375);
    ((RoundedCornerImageViewNoPadding)localObject1).setCorner(ViewUtils.dpToPx(4.0F));
    Object localObject2 = this.h;
    if ((localObject2 != null) && (!((List)localObject2).isEmpty()))
    {
      ((RoundedCornerImageViewNoPadding)localObject1).setImageDrawable(URLDrawable.getDrawable((String)this.h.get(0), null));
      h();
    }
    else
    {
      ((RoundedCornerImageViewNoPadding)localObject1).setImageDrawable(getResources().getDrawable(1912864778));
    }
    a((View)localObject1, 0);
    localObject1 = (ExpandVoiceView)this.u.findViewById(1912930367);
    if ((this.j != 0) && (!TextUtils.isEmpty(this.k)))
    {
      ((ExpandVoiceView)localObject1).setVoiceDuration(this.j);
      ((ExpandVoiceView)localObject1).setVoiceUrl(this.k);
      ((ExpandVoiceView)localObject1).a = true;
      ((ExpandVoiceView)localObject1).setMode(3);
      ((ExpandVoiceView)localObject1).setActivity((QBaseActivity)getContext());
      ((ExpandVoiceView)localObject1).setVisibility(0);
      ((ExpandVoiceView)localObject1).setOnClickListener(new -..Lambda.ExtendFriendCardOnHeadIconClick.hXixzSr_WZARy8qo6eA0KHViXcY(this, (ExpandVoiceView)localObject1));
    }
    else
    {
      ((ExpandVoiceView)localObject1).setVisibility(8);
    }
    localObject1 = (ImageView)this.u.findViewById(1912930358);
    localObject2 = this.c;
    if ((localObject2 != null) && (!TextUtils.isEmpty((CharSequence)localObject2)))
    {
      localObject2 = URLDrawable.getDrawable(this.c, null);
      ((URLDrawable)localObject2).setDecodeHandler(URLDrawableDecodeHandler.a);
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject2);
      localObject2 = new ArrayList();
      ((ArrayList)localObject2).add(this.c);
      a((View)localObject1, 0, (ArrayList)localObject2);
    }
    localObject1 = (TextView)this.u.findViewById(1912930386);
    ((TextView)localObject1).setText(this.d);
    ((TextView)localObject1).setTextColor(-16777216);
    ((TextView)localObject1).setTextSize(20.0F);
    localObject1 = (ImageView)this.u.findViewById(1912930350);
    localObject2 = (TextView)this.u.findViewById(1912930457);
    Object localObject3 = (LinearLayout)this.u.findViewById(1912930351);
    int i1 = this.e;
    if (i1 == 1)
    {
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(1912864780));
      ((LinearLayout)localObject3).setBackgroundResource(1912864782);
    }
    else if (i1 == 2)
    {
      ((ImageView)localObject1).setImageDrawable(getResources().getDrawable(1912864779));
      ((LinearLayout)localObject3).setBackgroundColor(getResources().getColor(1912733699));
    }
    else
    {
      ((ImageView)localObject1).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
    }
    localObject3 = (TextView)this.u.findViewById(1912930323);
    String str = this.f;
    if ((str != null) && (!TextUtils.isEmpty(str)))
    {
      ((TextView)localObject3).setText(this.f);
      ((TextView)localObject3).setTextSize(12.0F);
      ((TextView)localObject2).setTextSize(12.0F);
      if (this.e == 2)
      {
        ((TextView)localObject3).setTextColor(getResources().getColor(1912733697));
        ((TextView)localObject2).setTextColor(getResources().getColor(1912733701));
      }
      else
      {
        ((TextView)localObject3).setTextColor(getResources().getColor(1912733696));
        ((TextView)localObject2).setTextColor(getResources().getColor(1912733700));
      }
    }
    else
    {
      ((TextView)localObject3).setVisibility(8);
      ((TextView)localObject2).setVisibility(8);
      ((LinearLayout.LayoutParams)((ImageView)localObject1).getLayoutParams()).rightMargin = ViewUtils.dpToPx(4.0F);
    }
    localObject1 = this.i;
    if ((localObject1 != null) && (!TextUtils.isEmpty((CharSequence)localObject1)))
    {
      localObject1 = (TextView)this.u.findViewById(1912930326);
      ((TextView)localObject1).setText(this.i);
      ((TextView)localObject1).setMaxLines(4);
      ((TextView)localObject1).setVisibility(0);
    }
    localObject1 = this.u.findViewById(1912930363);
    if (!this.m)
    {
      ((View)localObject1).setVisibility(8);
    }
    else
    {
      ((ExtendFriendHonorOfKingRecordView)this.u.findViewById(1912930347)).setData(this.n);
      ((View)localObject1).setVisibility(0);
    }
    localObject1 = (LinearLayout)this.u.findViewById(1912930340);
    ((LinearLayout)localObject1).setBackgroundColor(Color.rgb(0, 0, 0));
    ((LinearLayout)localObject1).getBackground().setAlpha(127);
    localObject1 = (TextView)this.u.findViewById(1912930304);
    if (g())
    {
      ((TextView)localObject1).setText(1913061379);
      ((TextView)localObject1).setOnClickListener(new ExtendFriendCardOnHeadIconClick.1(this));
    }
    else
    {
      ((TextView)localObject1).setText(1913061376);
      ((TextView)localObject1).setOnClickListener(new ExtendFriendCardOnHeadIconClick.2(this));
    }
    ((TextView)localObject1).setTextColor(-1);
    ((TextView)localObject1).setTextSize(17.0F);
    ((TextView)localObject1).setGravity(17);
    ((LinearLayout)this.u.findViewById(1912930443)).setOnClickListener(new -..Lambda.ExtendFriendCardOnHeadIconClick.aQH6bzR1gSv_KifUjp2pTXmRQB8(this));
  }
  
  private int c()
  {
    return 3094;
  }
  
  private void d()
  {
    NewReportPlugin.a(getQBaseActivity(), 1044, this.p, getQBaseActivity().getCurrentAccountUinFromRuntime(), null);
  }
  
  private void e()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 1.0F, 1, 0.0F);
    localTranslateAnimation.setDuration(400L);
    this.u.post(new ExtendFriendCardOnHeadIconClick.3(this, localTranslateAnimation));
  }
  
  private void f()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, 0.0F, 1, 0.0F, 1, 1.0F);
    localTranslateAnimation.setDuration(400L);
    this.u.post(new ExtendFriendCardOnHeadIconClick.4(this, localTranslateAnimation));
    this.u.postDelayed(new ExtendFriendCardOnHeadIconClick.5(this), 400L);
  }
  
  private boolean g()
  {
    return this.p.equals(getQBaseActivity().getCurrentAccountUinFromRuntime());
  }
  
  private void h()
  {
    if (this.h.size() == 1) {
      return;
    }
    int i5 = ViewUtils.dpToPx(2.0F);
    LinearLayout localLinearLayout = (LinearLayout)this.u.findViewById(1912930394);
    localLinearLayout.removeAllViews();
    int i3 = ViewUtils.dpToPx(2.0F);
    int i4 = ViewUtils.dpToPx(10.0F);
    int i1 = this.h.size() - 1;
    while (i1 > 0)
    {
      RoundCornerImageView localRoundCornerImageView = new RoundCornerImageView(getContext());
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(ViewUtils.dpToPx(34.0F), ViewUtils.dpToPx(34.0F));
      int i2;
      if (i1 == 1) {
        i2 = i4;
      } else {
        i2 = i3;
      }
      localLayoutParams.rightMargin = i2;
      localRoundCornerImageView.setLayoutParams(localLayoutParams);
      localRoundCornerImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localRoundCornerImageView.setImageDrawable(URLDrawable.getDrawable((String)this.h.get(i1), null));
      localRoundCornerImageView.setCorner(i5, i5, i5, i5);
      localRoundCornerImageView.setBorder(true);
      localRoundCornerImageView.setBorderWidth(ViewUtils.dpToPx(0.5F));
      localRoundCornerImageView.setColor(-1);
      localRoundCornerImageView.setVisibility(0);
      a(localRoundCornerImageView, i1);
      localLinearLayout.addView(localRoundCornerImageView);
      i1 -= 1;
    }
    localLinearLayout.setVisibility(0);
  }
  
  private void i()
  {
    LimitChatUtil.a(this.t, Long.valueOf(Long.parseLong(this.p)), new ExtendFriendCardOnHeadIconClick.6(this));
  }
  
  private void j()
  {
    if (this.p.equals(this.t.getCurrentUin()))
    {
      this.q = 0;
      return;
    }
    this.q = ExpandFriendData.getMatchSrc(this.t, this.p);
  }
  
  private void k()
  {
    ExpandVoiceView localExpandVoiceView = (ExpandVoiceView)this.u.findViewById(1912930367);
    if (localExpandVoiceView.a()) {
      localExpandVoiceView.c();
    }
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    if (paramInt1 != 8000) {
      return;
    }
    if (paramInt2 == -1)
    {
      if ((paramIntent != null) && (paramIntent.getStringExtra("key_extend_friend_info_json") != null))
      {
        this.o = paramIntent.getStringExtra("key_extend_friend_info_json");
        this.h.clear();
        a.put(this.t.getCurrentUin(), this.o);
        try
        {
          a();
          b();
          this.u.postInvalidate();
          return;
        }
        catch (JSONException paramIntent)
        {
          paramIntent.printStackTrace();
          return;
        }
      }
      QLog.e("ExtendFriendCardOnHeadIconClick", 1, "intent data is empty!");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendCardOnHeadIconClick", 2, "didn't set data successfully!");
    }
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.g = new ArrayList();
    this.h = new ArrayList();
    this.s = new Semaphore(1);
    this.t = ((BaseQQAppInterface)getQBaseActivity().getAppRuntime());
    paramBundle = getActivity().getIntent();
    this.p = paramBundle.getStringExtra("targetUin");
    this.r = paramBundle.getIntExtra("fromPage", 0);
    if (ExtendFriendCardOnHeadIconClick.LRUCache.shouldRefreshData(this.p)) {
      ExtendFriendCardOnHeadIconClick.LRUCache.removeOutDatedData(this.p);
    }
    this.o = ((String)a.get(this.p));
    j();
    paramBundle = this.o;
    if (((paramBundle == null) || (TextUtils.isEmpty(paramBundle))) && (this.s.tryAcquire())) {
      i();
    }
  }
  
  @Nullable
  public View onCreateView(@NonNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    this.u = paramLayoutInflater.inflate(1912995841, paramViewGroup, false);
    ThreadManager.getSubThreadHandler().post(new -..Lambda.ExtendFriendCardOnHeadIconClick.Laf8Z0IR8kq9iR4mV04FefncMqw(this));
    return this.u;
  }
  
  public void onFinish()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[fragment]onFinish: invoked. this: ");
      ((StringBuilder)localObject).append(this);
      ((StringBuilder)localObject).append(" activity: ");
      ((StringBuilder)localObject).append(getActivity());
      QLog.d("ExtendFriendCardOnHeadIconClick", 2, ((StringBuilder)localObject).toString());
    }
    super.onFinish();
    Object localObject = getActivity();
    if (localObject != null) {
      ((Activity)localObject).overridePendingTransition(0, 1912668162);
    }
  }
  
  public boolean overrideFinish()
  {
    boolean bool = super.overrideFinish();
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.overridePendingTransition(0, 1912668162);
    }
    k();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.widget.ExtendFriendCardOnHeadIconClick
 * JD-Core Version:    0.7.0.1
 */