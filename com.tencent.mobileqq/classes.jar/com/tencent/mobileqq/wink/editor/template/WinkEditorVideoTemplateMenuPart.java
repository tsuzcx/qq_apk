package com.tencent.mobileqq.wink.editor.template;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaMaterial;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.wink.editor.WinkMaterialViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.music.viewmodel.MusicVolumeControlViewModel;
import com.tencent.mobileqq.wink.view.AutoTemplateProgressView;
import com.tencent.mobileqq.wink.view.WinkMaterialPanel;
import java.io.File;

public class WinkEditorVideoTemplateMenuPart
  extends WinkEditorMenuPart
{
  private WinkMaterialPanel g;
  private VideoTemplateMaterialPanelContentAdapter h;
  private AutoTemplateProgressView i;
  private boolean j = false;
  private boolean k = false;
  private MetaMaterial l = null;
  private WinkEditorTemplateViewModel m;
  private MusicVolumeControlViewModel n;
  
  private void a(MetaMaterial paramMetaMaterial)
  {
    if ((q() instanceof WinkVideoTavCut)) {
      this.m.a(((WinkVideoTavCut)q()).l(), paramMetaMaterial, this.n.e());
    }
  }
  
  private boolean a(String paramString)
  {
    return new File(paramString).exists();
  }
  
  public void a(View paramView)
  {
    super.a(paramView);
    this.i = ((AutoTemplateProgressView)paramView.findViewById(2131446978));
    this.i.setCloseProgressListener(new -..Lambda.WinkEditorVideoTemplateMenuPart.QRvlKJVLk2w_aAPa5SCvgR_4S1M(this));
    this.i.setVisibility(8);
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
    this.n = ((MusicVolumeControlViewModel)new ViewModelProvider(j().getActivity()).get(MusicVolumeControlViewModel.class));
    this.m = ((WinkEditorTemplateViewModel)a(WinkEditorTemplateViewModel.class));
    this.m.b().observe(j(), new -..Lambda.WinkEditorVideoTemplateMenuPart.nGQYO3Xy_2lNCPpWy5Rp8s7Tdh8(this));
    this.g = ((WinkMaterialPanel)paramView.findViewById(2131437998));
    this.g.setOnClearButtonClickListener(new -..Lambda.WinkEditorVideoTemplateMenuPart.EN6bvaR5lBXnP_9fPc5IEsHh40s(this));
    this.h = new VideoTemplateMaterialPanelContentAdapter(g());
    this.h.a(new WinkEditorVideoTemplateMenuPart.1(this));
    p().getVideoTemplatesVOLiveData().observe(j(), new -..Lambda.WinkEditorVideoTemplateMenuPart.XjzxuI4f_i0niWXY7BOVpYRY4b0(this));
  }
  
  public int d()
  {
    return 2131449455;
  }
  
  @NonNull
  public MenuType e()
  {
    return MenuType.VIDEO_TEMPLATE;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.template.WinkEditorVideoTemplateMenuPart
 * JD-Core Version:    0.7.0.1
 */