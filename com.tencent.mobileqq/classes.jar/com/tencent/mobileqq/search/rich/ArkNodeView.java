package com.tencent.mobileqq.search.rich;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.item.ArkAppRootLayout;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ArkNodeView
  extends RichNodeViewBase
  implements ArkAppView.ArkAppViewEvent
{
  private View b;
  private ArkAppView c;
  private LinearLayout d;
  private boolean e = true;
  private boolean f = false;
  private WeakReference<IArkNodeViewEvent> g;
  
  public ArkNodeView(IRichNode paramIRichNode, Context paramContext)
  {
    super(paramIRichNode, paramContext);
  }
  
  public View a(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131627774, null, false);
    this.b = paramContext;
    this.c = ((ArkAppView)this.b.findViewById(2131428760));
    this.d = null;
    ((ArkAppRootLayout)paramContext).setDisableParentReturn(false);
    return this.b;
  }
  
  public void a()
  {
    this.f = false;
    a(1);
    Object localObject = this.b;
    if (localObject != null) {
      ((View)localObject).setVisibility(0);
    }
    localObject = this.d;
    if (localObject != null) {
      ((LinearLayout)localObject).setVisibility(8);
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject = this.g;
    if (localObject == null) {
      return;
    }
    localObject = (IArkNodeViewEvent)((WeakReference)localObject).get();
    if (localObject == null) {
      return;
    }
    ((IArkNodeViewEvent)localObject).a(paramInt);
  }
  
  public void a(ArkNodeContainer paramArkNodeContainer)
  {
    ArkAppView localArkAppView = this.c;
    if (localArkAppView != null)
    {
      if (paramArkNodeContainer == null) {
        return;
      }
      localArkAppView.a(paramArkNodeContainer, this);
    }
  }
  
  public void a(IArkNodeViewEvent paramIArkNodeViewEvent)
  {
    this.g = new WeakReference(paramIArkNodeViewEvent);
  }
  
  public void a(String paramString, int paramInt, boolean paramBoolean)
  {
    this.f = true;
    a(1);
    Object localObject = this.d;
    if (localObject == null) {
      return;
    }
    if (this.e)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ArkNodeView", 2, "onLoadFailed, show no result");
      }
      this.b.setVisibility(8);
      a(false);
      return;
    }
    ((LinearLayout)localObject).setVisibility(0);
    if (paramBoolean) {
      this.d.setOnClickListener(new ArkNodeView.1(this));
    } else {
      this.d.setOnClickListener(null);
    }
    localObject = (TextView)this.d.findViewById(2131444564);
    if (localObject != null) {
      if (paramString == null) {
        ((TextView)localObject).setText(this.d.getContext().getResources().getString(2131887067));
      } else {
        ((TextView)localObject).setText(paramString);
      }
    }
    paramString = this.d.findViewById(2131444557);
    if (paramString != null)
    {
      if (paramBoolean) {
        paramInt = 2130838754;
      } else {
        paramInt = 2130838753;
      }
      paramString.setBackgroundDrawable(paramString.getResources().getDrawable(paramInt));
    }
  }
  
  public void a(boolean paramBoolean)
  {
    boolean bool = paramBoolean;
    if (paramBoolean)
    {
      bool = paramBoolean;
      if (this.f)
      {
        bool = paramBoolean;
        if (this.e) {
          bool = false;
        }
      }
    }
    super.a(bool);
  }
  
  public void dn_()
  {
    LinearLayout localLinearLayout = this.d;
    if (localLinearLayout != null) {
      localLinearLayout.setVisibility(0);
    }
  }
  
  public void do_() {}
  
  public void i()
  {
    this.b = null;
    ArkAppView localArkAppView = this.c;
    if (localArkAppView != null)
    {
      localArkAppView.a();
      this.c = null;
    }
    this.d = null;
    super.i();
  }
  
  public void j() {}
  
  public View k()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeView
 * JD-Core Version:    0.7.0.1
 */