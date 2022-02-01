package com.tencent.mobileqq.richmediabrowser;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.richmediabrowser.model.AIOBrowserModel;
import com.tencent.mobileqq.richmediabrowser.presenter.AIOBrowserPresenter;
import com.tencent.mobileqq.richmediabrowser.view.AIOBrowserScene;
import com.tencent.richmediabrowser.api.BrowserParamsBuilder;
import com.tencent.richmediabrowser.core.IBrowserBuilder;

public class AIOBrowserBuilder
  implements IBrowserBuilder
{
  private Context a;
  private AIOBrowserPresenter b;
  private AIOBrowserScene c;
  private AIOBrowserModel d;
  private BrowserParamsBuilder e;
  
  public AIOBrowserBuilder(Context paramContext)
  {
    this.a = paramContext;
  }
  
  public AIOBrowserPresenter a()
  {
    return this.b;
  }
  
  public void a(BrowserParamsBuilder paramBrowserParamsBuilder)
  {
    this.e = paramBrowserParamsBuilder;
  }
  
  public void buildComplete()
  {
    this.b.buildComplete();
    this.c.buildComplete();
    this.d.buildComplete();
  }
  
  public void buildModel()
  {
    this.d.buildModel();
  }
  
  public void buildParams(Intent paramIntent)
  {
    this.b.buildParams(paramIntent);
    this.c.buildParams(paramIntent);
    this.d.buildParams(paramIntent);
  }
  
  public void buildPresenter()
  {
    this.b = new AIOBrowserPresenter();
    this.b.setParamsBuilder(this.e);
    this.c = new AIOBrowserScene(this.a, this.b);
    this.b.a(this.c);
    this.d = new AIOBrowserModel(this.b);
    this.b.a(this.d);
  }
  
  public void buildView()
  {
    this.c.buildView();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.AIOBrowserBuilder
 * JD-Core Version:    0.7.0.1
 */