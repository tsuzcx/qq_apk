package dov.com.qq.im.AECamera.panel.material;

import aciy;
import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import bgzx;

public class AEGridView
  extends RecyclerView
{
  private Context a;
  
  public AEGridView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AEGridView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    this.a = paramContext;
    int i = aciy.a(60.0F, this.a.getResources());
    int j = aciy.a(12.0F, this.a.getResources());
    int k = aciy.a(10.0F, this.a.getResources());
    int m = this.a.getResources().getDisplayMetrics().widthPixels;
    int n = (m - k) / (i + k);
    setPadding((m - i * n) / (n + 1), 0, 0, j * 4);
    setClipToPadding(false);
    setLayoutManager(new GridLayoutManager(getContext(), n));
    addItemDecoration(new bgzx(this, n, k));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.panel.material.AEGridView
 * JD-Core Version:    0.7.0.1
 */