package com.tencent.xweb.extension.video;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class VideoStatusLayout
  extends RelativeLayout
{
  private ImageView a;
  private VideoDotPercentIndicator b;
  private TextView c;
  private TextView d;
  private LinearLayout e;
  private VideoStatusLayout.a f;
  private int g = 1000;
  
  public VideoStatusLayout(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }
  
  public VideoStatusLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }
  
  private void a(Context paramContext)
  {
    LayoutInflater.from(paramContext).inflate(2131629287, this);
    this.a = ((ImageView)findViewById(2131435489));
    this.b = ((VideoDotPercentIndicator)findViewById(2131440770));
    this.c = ((TextView)findViewById(2131448660));
    this.d = ((TextView)findViewById(2131447252));
    this.e = ((LinearLayout)findViewById(2131437031));
    this.f = new VideoStatusLayout.a(this, null);
    setVisibility(8);
  }
  
  public void a()
  {
    setVisibility(0);
    removeCallbacks(this.f);
    postDelayed(this.f, this.g);
  }
  
  public void setBrightProgress(int paramInt)
  {
    this.b.setProgress(paramInt);
    this.b.setVisibility(0);
    this.d.setText(2131918204);
    this.e.setVisibility(0);
    this.a.setImageResource(2130853728);
    this.c.setVisibility(8);
  }
  
  public void setDuration(int paramInt)
  {
    this.g = paramInt;
  }
  
  public void setImageResource(int paramInt)
  {
    this.a.setImageResource(paramInt);
  }
  
  public void setVideoTimeProgress(String paramString)
  {
    this.c.setText(paramString);
    this.c.setVisibility(0);
    this.e.setVisibility(8);
  }
  
  public void setVolumnProgress(int paramInt)
  {
    this.b.setProgress(paramInt);
    this.b.setVisibility(0);
    this.d.setText(2131918205);
    this.e.setVisibility(0);
    this.a.setImageResource(2130853738);
    this.c.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.extension.video.VideoStatusLayout
 * JD-Core Version:    0.7.0.1
 */