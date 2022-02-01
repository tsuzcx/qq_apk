package com.tencent.mobileqq.qassistant.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.mobileqq.qassistant.core.IViewPresenter;
import com.tencent.mobileqq.qassistant.data.CommandInfo;
import com.tencent.mobileqq.qassistant.data.FriendItemInfo;
import com.tencent.mobileqq.qassistant.data.VoiceItemInfo;
import com.tencent.mobileqq.qassistant.listener.IPanelDragListener;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import mqq.app.MobileQQ;

public class VoiceView
  implements IViewPresenter, IPanelDragListener
{
  private Context a = MobileQQ.sMobileQQ;
  private View b;
  private VoicePanelSlideContainer c;
  private RecyclerView d;
  private ImageView e;
  private View f;
  private VoiceAdapter g;
  private IViewPresenter h;
  private TextView i;
  private TextView j;
  
  public VoiceView(IViewPresenter paramIViewPresenter)
  {
    this.h = paramIViewPresenter;
  }
  
  private void c(boolean paramBoolean)
  {
    View localView = this.f;
    if (localView != null)
    {
      int k;
      if (paramBoolean) {
        k = 0;
      } else {
        k = 4;
      }
      localView.setVisibility(k);
    }
  }
  
  private void h()
  {
    this.b = LayoutInflater.from(this.a).inflate(2131624260, null);
    this.c = ((VoicePanelSlideContainer)this.b.findViewById(2131446076));
    this.i = ((TextView)this.b.findViewById(2131439962));
    this.j = ((TextView)this.b.findViewById(2131439963));
    this.e = ((ImageView)this.b.findViewById(2131428817));
    this.f = this.b.findViewById(2131446075);
    this.d = ((RecyclerView)this.b.findViewById(2131449973));
    i();
    j();
    this.i.setVisibility(8);
    this.j.setVisibility(8);
    this.j.setOnClickListener(new VoiceView.1(this));
  }
  
  private void i()
  {
    LinearLayoutManager localLinearLayoutManager = new LinearLayoutManager(this.a, 1, false);
    this.d.setLayoutManager(localLinearLayoutManager);
    this.g = new VoiceAdapter(this.a);
    this.g.a(this);
    this.d.setAdapter(this.g);
  }
  
  private void j()
  {
    VoicePanelSlideContainer localVoicePanelSlideContainer = this.c;
    if (localVoicePanelSlideContainer != null) {
      localVoicePanelSlideContainer.setPanelDragListener(this);
    }
  }
  
  public void a()
  {
    IViewPresenter localIViewPresenter = this.h;
    if (localIViewPresenter != null) {
      localIViewPresenter.a();
    }
  }
  
  public void a(int paramInt)
  {
    IViewPresenter localIViewPresenter = this.h;
    if (localIViewPresenter != null) {
      localIViewPresenter.a(paramInt);
    }
  }
  
  public void a(CommandInfo paramCommandInfo, List<VoiceItemInfo> paramList)
  {
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      VoiceAdapter localVoiceAdapter = this.g;
      if (localVoiceAdapter != null) {
        localVoiceAdapter.a(paramCommandInfo, paramList);
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("VoiceView", 2, "showCommandView infoList is empty");
    }
  }
  
  public void a(FriendItemInfo paramFriendItemInfo)
  {
    IViewPresenter localIViewPresenter = this.h;
    if (localIViewPresenter != null) {
      localIViewPresenter.a(paramFriendItemInfo);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    IViewPresenter localIViewPresenter = this.h;
    if (localIViewPresenter != null) {
      localIViewPresenter.a(paramBoolean);
    }
  }
  
  public void b()
  {
    this.g = null;
    this.d = null;
    this.e = null;
    this.b = null;
  }
  
  public void b(boolean paramBoolean)
  {
    c(paramBoolean);
  }
  
  public View c()
  {
    h();
    return this.b;
  }
  
  public List<VoiceItemInfo> d()
  {
    VoiceAdapter localVoiceAdapter = this.g;
    if (localVoiceAdapter != null) {
      return localVoiceAdapter.a();
    }
    return null;
  }
  
  public int e()
  {
    VoiceAdapter localVoiceAdapter = this.g;
    if (localVoiceAdapter != null) {
      return localVoiceAdapter.b();
    }
    return 3;
  }
  
  public CommandInfo f()
  {
    VoiceAdapter localVoiceAdapter = this.g;
    if (localVoiceAdapter != null) {
      return localVoiceAdapter.c();
    }
    return null;
  }
  
  public boolean g()
  {
    VoicePanelSlideContainer localVoicePanelSlideContainer = this.c;
    return (localVoicePanelSlideContainer != null) && (localVoicePanelSlideContainer.a());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.view.VoiceView
 * JD-Core Version:    0.7.0.1
 */