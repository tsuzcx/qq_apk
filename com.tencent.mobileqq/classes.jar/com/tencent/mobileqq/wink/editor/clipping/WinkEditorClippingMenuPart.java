package com.tencent.mobileqq.wink.editor.clipping;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.MutableLiveData;
import com.tencent.biz.richframework.part.BasePartFragment;
import com.tencent.mobileqq.wink.editor.WinkEditorViewModel;
import com.tencent.mobileqq.wink.editor.WinkVideoTavCut;
import com.tencent.mobileqq.wink.editor.menu.MenuType;
import com.tencent.mobileqq.wink.editor.menu.WinkEditorMenuPart;
import com.tencent.mobileqq.wink.editor.template.WinkEditorTemplateViewModel;
import com.tencent.videocut.model.MediaModel;
import com.tencent.videocut.render.extension.MediaClipExtensionKt;
import java.util.ArrayList;
import java.util.Collection;

public class WinkEditorClippingMenuPart
  extends WinkEditorMenuPart
{
  private WinkEditorTemplateViewModel g;
  
  private void s()
  {
    FragmentManager localFragmentManager = j().getFragmentManager();
    WinkEditorClippingFragment localWinkEditorClippingFragment = (WinkEditorClippingFragment)localFragmentManager.findFragmentByTag("CLIPPING");
    Bundle localBundle = new Bundle();
    Object localObject = new ArrayList();
    if ((q() instanceof WinkVideoTavCut)) {
      if (this.g.f()) {
        localObject = MediaClipExtensionKt.b(this.g.i());
      } else {
        localObject = ((WinkVideoTavCut)q()).l().videos;
      }
    }
    localBundle.putParcelableArrayList("CLIP_RESOURCE_MODEL", new ArrayList((Collection)localObject));
    Long localLong = (Long)this.c.i().getValue();
    localObject = localLong;
    if (localLong == null) {
      localObject = Long.valueOf(0L);
    }
    localBundle.putLong("CLIP_CURRENT_PLAY_TIME", ((Long)localObject).longValue());
    if (localWinkEditorClippingFragment == null)
    {
      localObject = new WinkEditorClippingFragment();
      ((WinkEditorClippingFragment)localObject).setArguments(localBundle);
      localFragmentManager.beginTransaction().add(2131433667, (Fragment)localObject, "CLIPPING").addToBackStack(null).hide(j()).commit();
      return;
    }
    localWinkEditorClippingFragment.setArguments(localBundle);
    localFragmentManager.beginTransaction().show(localWinkEditorClippingFragment).hide(j()).commit();
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.a(paramInt1, paramInt2, paramIntent);
    Object localObject = j().getFragmentManager();
    if (localObject != null)
    {
      localObject = (WinkEditorClippingFragment)((FragmentManager)localObject).findFragmentByTag("CLIPPING");
      if (localObject != null) {
        ((WinkEditorClippingFragment)localObject).onActivityResult(paramInt1, paramInt2, paramIntent);
      }
    }
  }
  
  protected void c(View paramView)
  {
    super.c(paramView);
    this.g = ((WinkEditorTemplateViewModel)a(WinkEditorTemplateViewModel.class));
  }
  
  public int d()
  {
    return 2131430793;
  }
  
  @NonNull
  public MenuType e()
  {
    return MenuType.CLIPPING;
  }
  
  public void f()
  {
    super.f();
    s();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingMenuPart
 * JD-Core Version:    0.7.0.1
 */