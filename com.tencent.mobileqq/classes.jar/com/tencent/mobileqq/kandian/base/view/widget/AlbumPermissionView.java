package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.app.utils.PermissionUtils;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppActivity;
import mqq.app.QQPermissionCallback;

public class AlbumPermissionView
  extends LinearLayout
  implements View.OnClickListener
{
  private Context a;
  private View b;
  private TextView c;
  private QQPermissionCallback d;
  
  public AlbumPermissionView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AlbumPermissionView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AlbumPermissionView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    LayoutInflater.from(paramContext).inflate(2131626016, this, true);
    setOrientation(1);
    setGravity(17);
    this.b = findViewById(2131448427);
    this.c = ((TextView)findViewById(2131448810));
    this.b.setOnClickListener(this);
  }
  
  public boolean a()
  {
    if (Build.VERSION.SDK_INT > 23) {
      return PermissionUtils.isStorePermissionEnable(BaseApplication.getContext());
    }
    return true;
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131448427) {
      PermissionUtils.requestStorePermission((AppActivity)this.a, 10000, this.d);
    }
  }
  
  public void setCallback(QQPermissionCallback paramQQPermissionCallback)
  {
    this.d = paramQQPermissionCallback;
  }
  
  public void setContextStyleBlack(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.c.setTextColor(this.a.getResources().getColor(2131168480));
      return;
    }
    this.c.setTextColor(this.a.getResources().getColor(2131165578));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.AlbumPermissionView
 * JD-Core Version:    0.7.0.1
 */