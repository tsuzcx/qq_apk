package com.tencent.mobileqq.kandian.biz.video.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.BaseVideoPlayParam;
import java.net.URL;

public class VideoCountDownView
  extends RelativeLayout
{
  public final int a;
  public final int b;
  public final int c;
  private Context d;
  private TextView e;
  private Button f;
  private Button g;
  private KandianUrlImageView h;
  private View i;
  private ImageView j;
  private ImageView k;
  private ImageView l;
  private ImageView m;
  private ImageView n;
  private boolean o;
  private BaseVideoPlayParam p;
  
  public VideoCountDownView(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public VideoCountDownView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public VideoCountDownView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.d = paramContext;
    this.a = getResources().getDimensionPixelOffset(2131297307);
    this.b = getResources().getDimensionPixelOffset(2131297295);
    this.c = getResources().getDimensionPixelOffset(2131297297);
    d();
  }
  
  private void d()
  {
    LayoutInflater.from(this.d).inflate(2131626420, this);
    this.e = ((TextView)findViewById(2131448810));
    this.f = ((Button)findViewById(2131429990));
    this.g = ((Button)findViewById(2131429957));
    this.h = ((KandianUrlImageView)findViewById(2131436650));
    this.i = findViewById(2131433911);
    this.j = ((ImageView)findViewById(2131436573));
    this.k = ((ImageView)findViewById(2131436574));
    this.l = ((ImageView)findViewById(2131436575));
    this.m = ((ImageView)findViewById(2131436576));
    this.n = ((ImageView)findViewById(2131436577));
    Drawable localDrawable = getResources().getDrawable(2130844333);
    int i1 = this.a;
    localDrawable.setBounds(0, 0, i1, i1);
    this.f.setCompoundDrawables(localDrawable, null, null, null);
    localDrawable = getResources().getDrawable(2130844329);
    localDrawable.setBounds(0, 0, this.b, this.c);
    this.g.setCompoundDrawables(localDrawable, null, null, null);
  }
  
  public void a()
  {
    this.e.setVisibility(8);
  }
  
  public void a(int paramInt)
  {
    this.e.setText(getResources().getString(2131915585, new Object[] { Integer.valueOf(paramInt), this.p.a }));
  }
  
  public void a(URL paramURL)
  {
    try
    {
      this.h.setVisibility(0);
      this.h.setImage(paramURL);
      return;
    }
    catch (Exception paramURL)
    {
      paramURL.printStackTrace();
    }
  }
  
  public void b()
  {
    this.h.setVisibility(8);
  }
  
  public void c()
  {
    this.g.setVisibility(8);
    this.e.setVisibility(8);
  }
  
  public void setIsXgMode(boolean paramBoolean)
  {
    this.o = paramBoolean;
  }
  
  public void setNextVideoInfo(BaseVideoPlayParam paramBaseVideoPlayParam)
  {
    this.p = paramBaseVideoPlayParam;
    if (this.p == null) {
      return;
    }
    this.g.setVisibility(0);
    this.e.setVisibility(0);
    if (this.o)
    {
      this.e.setText(getResources().getString(2131915586, new Object[] { this.p.a }));
      this.g.setText(getResources().getString(2131915584, new Object[] { VideoFeedsHelper.c(paramBaseVideoPlayParam.c) }));
      return;
    }
    this.g.setText(getResources().getString(2131915587));
  }
  
  public void setOnCustomClickListener(View.OnClickListener paramOnClickListener)
  {
    this.f.setOnClickListener(paramOnClickListener);
    this.i.setOnClickListener(paramOnClickListener);
    this.j.setOnClickListener(paramOnClickListener);
    this.k.setOnClickListener(paramOnClickListener);
    this.l.setOnClickListener(paramOnClickListener);
    this.m.setOnClickListener(paramOnClickListener);
    this.n.setOnClickListener(paramOnClickListener);
    this.g.setOnClickListener(paramOnClickListener);
    this.e.setOnClickListener(paramOnClickListener);
  }
  
  public void setTitle(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.video.view.VideoCountDownView
 * JD-Core Version:    0.7.0.1
 */