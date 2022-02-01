package com.tencent.mobileqq.guild.mainframe.container.discover.shareelement;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.widget.ImageView;
import com.tencent.mobileqq.utils.ViewUtils;
import java.util.Arrays;

public class ShareElementInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ShareElementInfo> CREATOR = new ShareElementInfo.1();
  private int[] a;
  private int[] b;
  private float[] c;
  private float[] d;
  private int e;
  private int f;
  private int g;
  private int h;
  private int i;
  private int j;
  private int k;
  private int l;
  private int m;
  private int n;
  private float o;
  private float p;
  private float q;
  private float r;
  private int s;
  
  public ShareElementInfo()
  {
    this.a = new int[2];
    this.b = new int[2];
    this.c = new float[9];
    this.d = new float[9];
  }
  
  protected ShareElementInfo(Parcel paramParcel)
  {
    this.a = paramParcel.createIntArray();
    this.b = paramParcel.createIntArray();
    this.c = paramParcel.createFloatArray();
    this.d = paramParcel.createFloatArray();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.h = paramParcel.readInt();
    this.i = paramParcel.readInt();
    this.j = paramParcel.readInt();
    this.k = paramParcel.readInt();
    this.l = paramParcel.readInt();
    this.m = paramParcel.readInt();
    this.n = paramParcel.readInt();
    this.o = paramParcel.readFloat();
    this.p = paramParcel.readFloat();
    this.q = paramParcel.readFloat();
    this.r = paramParcel.readFloat();
    this.s = paramParcel.readInt();
  }
  
  private void a(Context paramContext)
  {
    if (this.s == 1)
    {
      this.o = (this.i / this.k);
      f1 = this.j;
      i1 = this.l;
      this.p = (f1 / i1);
      this.q = 0.0F;
      this.r = i1;
      this.m = (this.a[0] - this.b[0] - ViewUtils.dpToPx(2.0F));
      this.n = ((int)(this.a[1] - this.l * (1.0F - this.p) - this.b[1] - -ViewUtils.dpToPx(2.0F)));
      return;
    }
    float f1 = this.i;
    int i1 = this.k;
    this.o = (f1 / i1);
    f1 = this.j;
    int i2 = this.l;
    this.p = (f1 / i2);
    this.q = i1;
    this.r = i2;
    this.m = ((int)(this.a[0] - i1 * this.o - this.b[0] - ViewUtils.dpToPx(2.0F)));
    this.n = ((int)(this.a[1] - this.l * (1.0F - this.p) - this.b[1] - -ViewUtils.dpToPx(2.0F)));
  }
  
  public int a()
  {
    return this.m;
  }
  
  public void a(ImageView paramImageView, int paramInt)
  {
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      this.s = paramInt;
      paramImageView.getImageMatrix().getValues(this.c);
      Rect localRect = paramImageView.getDrawable().getBounds();
      this.e = ((int)(localRect.width() * this.c[0]));
      this.f = ((int)(localRect.height() * this.c[4]));
      this.i = paramImageView.getWidth();
      this.j = paramImageView.getHeight();
      paramImageView.getLocationOnScreen(this.a);
      return;
    }
    throw new NullPointerException("original ImageView or ImageView drawable must not null");
  }
  
  void a(ImageView paramImageView, Context paramContext)
  {
    if ((paramImageView != null) && (paramImageView.getDrawable() != null))
    {
      paramImageView.getImageMatrix().getValues(this.d);
      Rect localRect = paramImageView.getDrawable().getBounds();
      this.g = ((int)(localRect.width() * this.d[0]));
      this.h = ((int)(localRect.height() * this.d[4]));
      this.k = paramImageView.getWidth();
      this.l = paramImageView.getHeight();
      paramImageView.getLocationOnScreen(this.b);
      a(paramContext);
      return;
    }
    throw new NullPointerException("target ImageView or ImageView drawable must not null");
  }
  
  public int b()
  {
    return this.n;
  }
  
  public float c()
  {
    return this.o;
  }
  
  public float d()
  {
    return this.p;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public float e()
  {
    return this.q;
  }
  
  public float f()
  {
    return this.r;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ShareElementInfo{\nmOriginalLocation=");
    localStringBuilder.append(Arrays.toString(this.a));
    localStringBuilder.append("\n, mTargetLocation=");
    localStringBuilder.append(Arrays.toString(this.b));
    localStringBuilder.append("\n, mOriginalValues=");
    localStringBuilder.append(Arrays.toString(this.c));
    localStringBuilder.append("\n, mTargetValues=");
    localStringBuilder.append(Arrays.toString(this.d));
    localStringBuilder.append("\n, mOriginalWidth=");
    localStringBuilder.append(this.e);
    localStringBuilder.append("\n, mOriginalHeight=");
    localStringBuilder.append(this.f);
    localStringBuilder.append("\n, mTargetWidth=");
    localStringBuilder.append(this.g);
    localStringBuilder.append("\n, mTargetHeight=");
    localStringBuilder.append(this.h);
    localStringBuilder.append("\n, mOriginalViewWidth=");
    localStringBuilder.append(this.i);
    localStringBuilder.append("\n, mOriginalViewHeight=");
    localStringBuilder.append(this.j);
    localStringBuilder.append("\n, mTargetViewWidth=");
    localStringBuilder.append(this.k);
    localStringBuilder.append("\n, mTargetViewHeight=");
    localStringBuilder.append(this.l);
    localStringBuilder.append("\n, mCenterOffsetX=");
    localStringBuilder.append(this.m);
    localStringBuilder.append("\n, mCenterOffsetY=");
    localStringBuilder.append(this.n);
    localStringBuilder.append("\n, mScaleX=");
    localStringBuilder.append(this.o);
    localStringBuilder.append("\n, mScaleY=");
    localStringBuilder.append(this.p);
    localStringBuilder.append("\n, mPivotX=");
    localStringBuilder.append(this.q);
    localStringBuilder.append("\n, mPivotY=");
    localStringBuilder.append(this.r);
    localStringBuilder.append("\n, mIsEven=");
    localStringBuilder.append(this.s);
    localStringBuilder.append("\n");
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeIntArray(this.a);
    paramParcel.writeIntArray(this.b);
    paramParcel.writeFloatArray(this.c);
    paramParcel.writeFloatArray(this.d);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeInt(this.h);
    paramParcel.writeInt(this.i);
    paramParcel.writeInt(this.j);
    paramParcel.writeInt(this.k);
    paramParcel.writeInt(this.l);
    paramParcel.writeInt(this.m);
    paramParcel.writeInt(this.n);
    paramParcel.writeFloat(this.o);
    paramParcel.writeFloat(this.p);
    paramParcel.writeFloat(this.q);
    paramParcel.writeFloat(this.r);
    paramParcel.writeInt(this.s);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.mainframe.container.discover.shareelement.ShareElementInfo
 * JD-Core Version:    0.7.0.1
 */