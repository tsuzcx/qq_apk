package com.tencent.mobileqq.extendfriend.widget;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.contacts.topentry.CTEntryListView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendCardUtils;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qqexpand.bean.entrance.BannerInfo;
import com.tencent.mobileqq.qqexpand.bean.entrance.EntranceInfo;
import com.tencent.mobileqq.qqexpand.manager.IExpandManager;
import com.tencent.mobileqq.qqexpand.network.ExpandObserver;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.mobileqq.tianshu.ui.RedTouch;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.qqlive.module.videoreport.constants.ClickPolicy;
import com.tencent.qqlive.module.videoreport.constants.ExposurePolicy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.json.JSONObject;

public class ExtendFriendContactEntranceContainer
  extends FrameLayout
{
  private final Context a;
  private QQAppInterface b;
  private CTEntryListView c;
  private ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter d;
  private RelativeLayout e;
  private TextView f;
  private URLImageView g;
  private RedTouch h;
  private int i = 0;
  private BannerInfo j;
  private List<EntranceInfo> k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private final ExpandObserver o = new ExtendFriendContactEntranceContainer.1(this);
  
  public ExtendFriendContactEntranceContainer(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendContactEntranceContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendContactEntranceContainer(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.a = paramContext;
    e();
    h();
  }
  
  private void a(int paramInt)
  {
    if (paramInt <= 0)
    {
      this.i = 0;
      this.h.g();
      return;
    }
    this.i = paramInt;
    j();
    BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
    this.h.setMaxNum(99);
    this.h.setUseNewStyle(true);
    localRedTypeInfo.red_content.set(String.valueOf(paramInt));
    localRedTypeInfo.red_desc.set("{'cn':'#FF0000'}");
    localRedTypeInfo.red_type.set(5);
    this.h.a(localRedTypeInfo);
  }
  
  private void a(EntranceInfo paramEntranceInfo)
  {
    HashMap localHashMap = new HashMap(1);
    localHashMap.put("kl_entry", Integer.valueOf(paramEntranceInfo.a));
    VideoReport.reportEvent("dt_clck", this.c, localHashMap);
  }
  
  private void a(String paramString)
  {
    if ((!paramString.startsWith("http")) && (!paramString.startsWith("https")))
    {
      paramString = JumpParser.a(this.b, this.a, paramString);
      if (paramString != null) {
        paramString.a();
      }
    }
    else
    {
      Intent localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      this.a.startActivity(localIntent);
    }
  }
  
  private void e()
  {
    LayoutInflater.from(this.a).inflate(2131627421, this, true);
    this.c = ((CTEntryListView)findViewById(2131432579));
    this.e = ((RelativeLayout)findViewById(2131439100));
    this.f = ((TextView)findViewById(2131439101));
    this.g = ((URLImageView)findViewById(2131432688));
    View localView = findViewById(2131432689);
    this.h = new RedTouch(getContext(), localView).c(53).a();
    this.b = ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    this.b.addObserver(this.o);
    a(this.b);
    this.e.setOnClickListener(new ExtendFriendContactEntranceContainer.2(this));
    this.d = new ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter(this, null);
    this.c.setAdapter(this.d);
    this.c.setOverScrollMode(2);
    f();
  }
  
  private void f()
  {
    this.m = ThemeUtil.isNowThemeIsNight(this.b, false, null);
    this.l = SimpleUIUtil.e();
    if (this.m) {
      this.g.setColorFilter(Color.parseColor("#959595"));
    } else {
      this.g.clearColorFilter();
    }
    i();
  }
  
  private void g()
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendContactEntranceContainer.4(this));
  }
  
  private void h()
  {
    VideoReport.setPageId(this, "pg_kl_contact");
    i();
    VideoReport.setElementId(this.e, "em_kl_top_entrance");
    VideoReport.setElementExposePolicy(this.e, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.e, ClickPolicy.REPORT_NONE);
    j();
    VideoReport.setElementId(this.c, "em_kl_function_entrance");
    VideoReport.setElementExposePolicy(this.c, ExposurePolicy.REPORT_NONE);
    VideoReport.setElementClickPolicy(this.c, ClickPolicy.REPORT_NONE);
  }
  
  private void i()
  {
    int i1;
    if (this.l) {
      i1 = 2;
    } else {
      i1 = 1;
    }
    VideoReport.setPageParams(this, "qqtype", Integer.valueOf(i1));
  }
  
  private void j()
  {
    RelativeLayout localRelativeLayout = this.e;
    int i1;
    if (this.i > 0) {
      i1 = 1;
    } else {
      i1 = 2;
    }
    VideoReport.setElementParam(localRelativeLayout, "kl_red_dot", Integer.valueOf(i1));
  }
  
  private void k()
  {
    if (!this.n) {
      return;
    }
    int i1 = 1;
    HashMap localHashMap = new HashMap(1);
    if (this.i <= 0) {
      i1 = 2;
    }
    localHashMap.put("kl_red_dot", Integer.valueOf(i1));
    VideoReport.reportEvent("dt_imp", this.e, localHashMap);
  }
  
  private void l()
  {
    if (this.n)
    {
      if (this.k == null) {
        return;
      }
      int i1 = 0;
      while (i1 < this.k.size())
      {
        HashMap localHashMap = new HashMap(1);
        localHashMap.put("kl_entry", Integer.valueOf(((EntranceInfo)this.k.get(i1)).a));
        VideoReport.reportEvent("dt_imp", this.c, localHashMap);
        i1 += 1;
      }
    }
  }
  
  private void m()
  {
    int i1 = 1;
    HashMap localHashMap = new HashMap(1);
    if (this.i <= 0) {
      i1 = 2;
    }
    localHashMap.put("kl_red_dot", Integer.valueOf(i1));
    VideoReport.reportEvent("dt_clck", this.e, localHashMap);
  }
  
  public void a()
  {
    this.n = false;
    setData();
    k();
    l();
    IExpandManager localIExpandManager = (IExpandManager)this.b.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localIExpandManager != null) {
      localIExpandManager.b(false);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.b.addObserver(this.o);
    setData();
    paramQQAppInterface = (IExpandManager)this.b.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.b(false);
    }
    a(this.b);
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    ThreadManager.getSubThreadHandler().post(new ExtendFriendContactEntranceContainer.3(this, paramAppRuntime));
  }
  
  public void b()
  {
    setData();
    boolean bool = ExtendFriendCardUtils.b(this.b);
    IExpandManager localIExpandManager = (IExpandManager)this.b.getManager(QQManagerFactory.EXTEND_FRIEND_MANAGER);
    if (localIExpandManager != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onRefresh forceFresh:");
        localStringBuilder.append(bool);
        QLog.d("ExtendFriendContactEntranceContainer", 2, localStringBuilder.toString());
      }
      localIExpandManager.b(bool);
    }
  }
  
  public void c()
  {
    this.b.removeObserver(this.o);
  }
  
  public void d()
  {
    f();
    this.d.notifyDataSetChanged();
  }
  
  public void setData()
  {
    if (!ExtendFriendCardUtils.b(this.b))
    {
      setVisibility(8);
      return;
    }
    Object localObject1 = ExtendFriendCardUtils.a(this.b);
    if (localObject1 == null)
    {
      setVisibility(8);
      return;
    }
    g();
    this.j = ExtendFriendCardUtils.a((JSONObject)localObject1);
    Object localObject2 = this.j;
    if (localObject2 != null)
    {
      this.n = true;
      if (!TextUtils.isEmpty(((BannerInfo)localObject2).a)) {
        this.f.setText(this.j.a);
      }
      if (!TextUtils.isEmpty(this.j.b))
      {
        localObject2 = URLDrawable.URLDrawableOptions.obtain();
        ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = getResources().getDrawable(2130846565);
        ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = getResources().getDrawable(2130846610);
        localObject2 = URLDrawable.getDrawable(this.j.b, (URLDrawable.URLDrawableOptions)localObject2);
        this.g.setImageDrawable((Drawable)localObject2);
      }
      setVisibility(0);
    }
    localObject1 = ExtendFriendCardUtils.b((JSONObject)localObject1);
    if ((localObject1 != null) && ((this.k == null) || (((List)localObject1).size() != this.k.size())))
    {
      this.d = new ExtendFriendContactEntranceContainer.ExtendEntranceListAdapter(this, null);
      this.c.setAdapter(this.d);
    }
    this.k = ((List)localObject1);
    if (this.k != null) {
      this.d.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.widget.ExtendFriendContactEntranceContainer
 * JD-Core Version:    0.7.0.1
 */