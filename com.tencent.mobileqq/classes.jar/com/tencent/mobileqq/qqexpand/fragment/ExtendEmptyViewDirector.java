package com.tencent.mobileqq.qqexpand.fragment;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.component.media.image.ImageLoader;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Method;

public class ExtendEmptyViewDirector
{
  private static Method a;
  private final View b;
  private final TextView c;
  private final View d;
  private final ImageView e;
  private final TextView f;
  private final TextView g;
  private int h = 0;
  private String i = "";
  
  public ExtendEmptyViewDirector(View paramView)
  {
    this.b = paramView.findViewById(2131443555);
    this.c = ((TextView)paramView.findViewById(2131443557));
    this.d = paramView.findViewById(2131443997);
    this.e = ((ImageView)paramView.findViewById(2131443996));
    this.f = ((TextView)paramView.findViewById(2131443999));
    this.g = ((TextView)paramView.findViewById(2131443998));
    try
    {
      ImageLoader.getInstance().downloadImageOnly("https://sola.gtimg.cn/aoi/sola/20200526111437_Jxz3xRir1X.png", null);
      return;
    }
    catch (Throwable paramView)
    {
      QLog.w("ExtendEmptyViewDirector", 1, "init: failed to download image", paramView);
    }
  }
  
  @Nullable
  private static Method a(ImageView paramImageView)
  {
    Method localMethod = a;
    if (localMethod != null) {
      return localMethod;
    }
    try
    {
      a = paramImageView.getClass().getMethod("setAsyncImage", new Class[] { String.class });
    }
    catch (Throwable paramImageView)
    {
      QLog.w("ExtendEmptyViewDirector", 1, "getSetAsyncImageMethod: failed", paramImageView);
    }
    return a;
  }
  
  private void a(ImageView paramImageView, @NonNull String paramString)
  {
    if (this.i.equals(paramString)) {
      return;
    }
    Method localMethod = a(paramImageView);
    if (localMethod == null) {
      return;
    }
    try
    {
      localMethod.invoke(paramImageView, new Object[] { paramString });
      this.i = paramString;
      return;
    }
    catch (Throwable paramImageView)
    {
      QLog.w("ExtendEmptyViewDirector", 1, "setAsyncImage: failed", paramImageView);
    }
  }
  
  public void a()
  {
    if (this.h == 0) {
      return;
    }
    this.b.setVisibility(8);
    this.d.setVisibility(8);
    this.h = 0;
  }
  
  public void b()
  {
    if (this.h == 1) {
      return;
    }
    this.b.setVisibility(0);
    this.d.setVisibility(8);
    this.c.setText(2131915059);
    this.h = 1;
  }
  
  public void c()
  {
    if (this.h == 2) {
      return;
    }
    this.b.setVisibility(0);
    this.d.setVisibility(8);
    this.c.setText("刷新失败，请下拉重试");
    this.h = 2;
  }
  
  public void d()
  {
    if (this.h == 3) {
      return;
    }
    this.b.setVisibility(8);
    this.d.setVisibility(0);
    this.f.setText("什么都没找到哦");
    this.g.setText("没有搜索到相关内容");
    a(this.e, "https://sola.gtimg.cn/aoi/sola/20200508145045_234LrOf7V4.png");
    this.h = 3;
  }
  
  public void e()
  {
    if (this.h == 4) {
      return;
    }
    this.b.setVisibility(8);
    this.d.setVisibility(0);
    this.f.setText("无法连接到互联网");
    this.g.setText("请关闭飞行模式或检查设备的网络设置");
    a(this.e, "https://sola.gtimg.cn/aoi/sola/20200526111437_Jxz3xRir1X.png");
    this.h = 4;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.fragment.ExtendEmptyViewDirector
 * JD-Core Version:    0.7.0.1
 */