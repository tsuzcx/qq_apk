package com.tencent.mobileqq.wink.view;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.mobileqq.vas.ui.IVasPagViewApi;
import com.tencent.mobileqq.vas.ui.VasPagView;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.libpag.PAGFile;
import org.libpag.PAGView;

public class AutoTemplateProgressView
  extends FrameLayout
{
  private FrameLayout a;
  private RoundProgressBar b;
  private RoundCornerImageView c;
  private ImageView d;
  private VasPagView e;
  private AutoTemplateProgressView.CloseProgressListener f;
  
  public AutoTemplateProgressView(@NonNull @NotNull Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public AutoTemplateProgressView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  public AutoTemplateProgressView(@NonNull @NotNull Context paramContext, @androidx.annotation.Nullable @org.jetbrains.annotations.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }
  
  private void a(PAGView paramPAGView, String paramString)
  {
    if (a(paramString))
    {
      paramString = PAGFile.Load(getContext().getResources().getAssets(), paramString);
      if (paramString != null)
      {
        paramPAGView.setComposition(paramString);
        paramPAGView.setRepeatCount(0);
        paramPAGView.play();
      }
    }
  }
  
  private boolean a(String paramString)
  {
    Object localObject = getContext().getResources().getAssets();
    try
    {
      localObject = ((AssetManager)localObject).list("");
      int i = 0;
      while (i < localObject.length)
      {
        boolean bool = localObject[i].equals(paramString.trim());
        if (bool) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void a()
  {
    this.e.g().a(new AutoTemplateProgressView.2(this));
  }
  
  public void a(int paramInt)
  {
    this.b.setProgress(paramInt);
  }
  
  public void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131628235, this, true);
    this.a = ((FrameLayout)findViewById(2131442809));
    this.b = ((RoundProgressBar)findViewById(2131442025));
    this.d = ((ImageView)findViewById(2131429764));
    this.e = ((VasPagView)findViewById(2131450007));
    this.e.g().a();
    this.d.setOnClickListener(new AutoTemplateProgressView.1(this));
    this.c = ((RoundCornerImageView)findViewById(2131442022));
    this.c.setCorner(ViewUtils.dpToPx(8.0F));
    this.c.setColor(872415231);
  }
  
  public void b()
  {
    this.e.g().a(new AutoTemplateProgressView.3(this));
  }
  
  public void setCloseProgressListener(AutoTemplateProgressView.CloseProgressListener paramCloseProgressListener)
  {
    this.f = paramCloseProgressListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.view.AutoTemplateProgressView
 * JD-Core Version:    0.7.0.1
 */