package com.tencent.mobileqq.wink.editor.music.fragments;

import android.view.View;
import androidx.fragment.app.Fragment;
import com.tencent.qqlive.module.videoreport.inject.fragment.ReportAndroidXFragment;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/wink/editor/music/fragments/MusicMenuBaseFragment;", "Landroidx/fragment/app/Fragment;", "layoutId", "", "(I)V", "Companion", "qq-wink-impl_release"}, k=1, mv={1, 1, 16})
public class MusicMenuBaseFragment
  extends ReportAndroidXFragment
{
  public static final MusicMenuBaseFragment.Companion a = new MusicMenuBaseFragment.Companion(null);
  private HashMap b;
  
  public MusicMenuBaseFragment(int paramInt)
  {
    super(paramInt);
  }
  
  public View a(int paramInt)
  {
    if (this.b == null) {
      this.b = new HashMap();
    }
    View localView2 = (View)this.b.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = getView();
      if (localView1 == null) {
        return null;
      }
      localView1 = localView1.findViewById(paramInt);
      this.b.put(Integer.valueOf(paramInt), localView1);
    }
    return localView1;
  }
  
  public void a()
  {
    HashMap localHashMap = this.b;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.music.fragments.MusicMenuBaseFragment
 * JD-Core Version:    0.7.0.1
 */