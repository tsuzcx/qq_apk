package com.tencent.open.agent;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.open.agent.auth.INewAuthorityContract.Presenter;
import com.tencent.open.agent.entity.Permission;
import com.tencent.open.agent.entity.VirtualAccountInfo;
import com.tencent.open.agent.util.QQLiteStatusUtil;
import com.tencent.open.agent.util.SSOLog;
import com.tencent.widget.SwipListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class OpenCardContainer
  extends BaseCardContainer
{
  private static final int[] m = { 2131888438 };
  private static final int[] n = { 2130839698 };
  private static final int[] o = { 2131438111 };
  protected OpenAuthorityAccountView k;
  public OpenCardContainer.VirtualAccountAdapter l;
  private LayoutInflater p;
  private ImageView q;
  private TextView r;
  private TextView s;
  private View t;
  private View u;
  private String v = "";
  private OpenCardContainer.UpdateStatusBarListener w;
  private INewAuthorityContract.Presenter x;
  
  public OpenCardContainer(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.p = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
  }
  
  private void a(ImageView paramImageView, String paramString)
  {
    if (paramImageView == null) {
      return;
    }
    Object localObject = null;
    URLDrawable localURLDrawable;
    try
    {
      Drawable localDrawable = this.a.getResources().getDrawable(2130841060);
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      SSOLog.c("OpenCardContainer", "-->create color drawable oom.", localOutOfMemoryError);
      localURLDrawable = null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localURLDrawable;
    localURLDrawableOptions.mFailedDrawable = localURLDrawable;
    try
    {
      localURLDrawable = URLDrawable.getDrawable(paramString, localURLDrawableOptions);
      paramString = localURLDrawable;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      SSOLog.b("OpenCardContainer", new Object[] { "setVirtualIcon exception url=", paramString, ",excption=", localIllegalArgumentException.toString() });
      paramString = localObject;
    }
    if (paramString != null)
    {
      paramString.setDecodeHandler(QQLiteStatusUtil.c());
      if (paramString.getStatus() == 2) {
        paramString.restartDownload();
      }
      if (paramString.getStatus() != 2)
      {
        paramImageView.setImageDrawable(paramString);
        return;
      }
      SSOLog.a("OpenCardContainer", new Object[] { "getImageError: " });
    }
  }
  
  private void b(int paramInt)
  {
    if (paramInt >= 3)
    {
      this.t.setVisibility(8);
      this.u.setVisibility(0);
      return;
    }
    this.t.setVisibility(0);
    this.u.setVisibility(8);
  }
  
  private void g()
  {
    this.g.setVisibility(0);
    if ((this.a instanceof QBaseActivity)) {
      ImmersiveUtils.setStatusTextColor(false, ((QBaseActivity)this.a).getWindow());
    }
    if ((this.a instanceof PublicFragmentActivityForOpenSDK))
    {
      OpenCardContainer.UpdateStatusBarListener localUpdateStatusBarListener = this.w;
      if (localUpdateStatusBarListener != null)
      {
        localUpdateStatusBarListener.a();
        break label104;
      }
    }
    if ((this.a instanceof AuthorityActivity)) {
      ((AuthorityActivity)this.a).a();
    } else if ((this.a instanceof QuickLoginAuthorityActivity)) {
      ((QuickLoginAuthorityActivity)this.a).i();
    }
    label104:
    int i = (int)(this.a.getResources().getDisplayMetrics().widthPixels * 0.6426666F);
    int j = this.f.getHeight();
    a(this.h, i, i - j, null);
  }
  
  protected void a()
  {
    SSOLog.b("OpenCardContainer", new Object[] { "displayCoverContainer " });
    if (!this.d)
    {
      this.d = true;
      g();
    }
  }
  
  public void a(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("switchToMode -->mode: ");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(", mMode=");
    localStringBuilder.append(this.e);
    SSOLog.a("OpenCardContainer", new Object[] { localStringBuilder.toString() });
    b(this.v);
    this.e = paramInt;
  }
  
  public void a(String paramString, Bitmap paramBitmap)
  {
    setVisibility(0);
    if (!TextUtils.isEmpty(paramString)) {
      this.r.setText(paramString);
    }
    if (paramBitmap != null) {
      this.q.setImageBitmap(paramBitmap);
    }
  }
  
  public boolean a(List<Permission> paramList, String paramString)
  {
    Object localObject = paramList;
    if (paramList == null) {
      localObject = new ArrayList();
    }
    this.c.clear();
    if (!TextUtils.isEmpty(paramString)) {
      this.s.setText(paramString);
    }
    if (((List)localObject).isEmpty())
    {
      SSOLog.a("OpenCardContainer", new Object[] { "authList isEmpty" });
    }
    else
    {
      paramList = new StringBuilder(((List)localObject).size() * 128);
      paramString = ((List)localObject).iterator();
      while (paramString.hasNext())
      {
        localObject = (Permission)paramString.next();
        Permission localPermission = new Permission();
        localPermission.d = ((Permission)localObject).d;
        localPermission.a = ((Permission)localObject).a;
        localPermission.e = ((Permission)localObject).e;
        localPermission.c = ((Permission)localObject).c;
        localPermission.b = ((Permission)localObject).b;
        paramList.append(localPermission.toString());
        paramList.append("\n");
        this.c.add(localPermission);
      }
      SSOLog.a("OpenCardContainer", new Object[] { paramList.toString() });
    }
    boolean bool;
    if (this.c.size() == 0) {
      bool = true;
    } else {
      bool = false;
    }
    if (bool)
    {
      paramList = this.h;
      a(1);
      SSOLog.a("OpenCardContainer", new Object[] { "--> has been authority." });
      a(paramList, a(this.v));
      return bool;
    }
    a(0);
    SSOLog.a("OpenCardContainer", new Object[] { "--> has not been authority." });
    return bool;
  }
  
  public void b()
  {
    OpenAuthorityAccountView localOpenAuthorityAccountView = this.k;
    if (localOpenAuthorityAccountView != null) {
      localOpenAuthorityAccountView.f();
    }
  }
  
  public void c()
  {
    if (!this.d) {
      return;
    }
    try
    {
      g();
      return;
    }
    catch (Exception localException)
    {
      SSOLog.c("OpenCardContainer", "Exception", localException);
    }
  }
  
  public void c(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      OpenAuthorityAccountView localOpenAuthorityAccountView = this.k;
      if (localOpenAuthorityAccountView != null) {
        localOpenAuthorityAccountView.a(paramString);
      }
    }
  }
  
  public long getSelectVid()
  {
    if ((OpenCardContainer.VirtualAccountAdapter.a(this.l) != null) && (OpenCardContainer.VirtualAccountAdapter.a(this.l).size() > 0))
    {
      Iterator localIterator = OpenCardContainer.VirtualAccountAdapter.a(this.l).iterator();
      while (localIterator.hasNext())
      {
        VirtualAccountInfo localVirtualAccountInfo = (VirtualAccountInfo)localIterator.next();
        if (localVirtualAccountInfo.d) {
          return localVirtualAccountInfo.c;
        }
      }
    }
    return 0L;
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("onFinishInflate ");
    ((StringBuilder)localObject).append(Log.getStackTraceString(new Throwable()));
    SSOLog.a("OpenCardContainer", new Object[] { ((StringBuilder)localObject).toString() });
    this.k = ((OpenAuthorityAccountView)super.findViewById(2131427489));
    this.k.setOnClickListener(new OpenCardContainer.1(this));
    this.q = ((ImageView)super.findViewById(2131428628));
    this.r = ((TextView)super.findViewById(2131428630));
    this.s = ((TextView)super.findViewById(2131428635));
    localObject = super.findViewById(2131428627);
    ((View)localObject).setFocusable(true);
    ((View)localObject).setFocusableInTouchMode(true);
    ((View)localObject).requestFocus();
    this.t = super.findViewById(2131431510);
    this.u = super.findViewById(2131449946);
    localObject = (SwipListView)super.findViewById(2131449947);
    this.l = new OpenCardContainer.VirtualAccountAdapter(this, this.a);
    ((SwipListView)localObject).setAdapter(this.l);
    ((SwipListView)localObject).setDragEnable(true);
    ((SwipListView)localObject).setOverScrollFlingMode(2);
    ((SwipListView)localObject).setOnItemClickListener(new OpenCardContainer.2(this));
  }
  
  public void setCurrentAppId(String paramString)
  {
    this.v = paramString;
  }
  
  public void setOnUpdateStatusBarListener(OpenCardContainer.UpdateStatusBarListener paramUpdateStatusBarListener)
  {
    this.w = paramUpdateStatusBarListener;
  }
  
  public void setPresenter(INewAuthorityContract.Presenter paramPresenter)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("setPresenter ");
    localStringBuilder.append(Log.getStackTraceString(new Throwable()));
    SSOLog.a("OpenCardContainer", new Object[] { localStringBuilder.toString() });
    this.x = paramPresenter;
    this.t.setOnClickListener(new OpenCardContainer.3(this));
    this.k.setAccountEventListener(new OpenCardContainer.4(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenCardContainer
 * JD-Core Version:    0.7.0.1
 */