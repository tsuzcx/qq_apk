package com.tencent.theme;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.StateSet;
import android.util.Xml;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class SkinnableColorStateList
  extends ColorStateList
{
  public static final Parcelable.Creator<ColorStateList> CREATOR;
  static Constructor b;
  static Field c;
  private static final int[][] g = { new int[0] };
  private static final int[][] h = new int[0][];
  Object a;
  private int[][] d;
  private int[] e;
  private int f = -65536;
  private int i;
  private int j;
  private boolean k;
  private boolean l;
  private long m;
  public j skinData;
  
  static
  {
    CREATOR = new SkinnableColorStateList.1();
    if (SkinEngine.a) {}
    try
    {
      b = Class.forName("android.content.res.ColorStateList$ColorStateListFactory").getConstructor(new Class[] { ColorStateList.class });
      b.setAccessible(true);
      c = ColorStateList.class.getDeclaredField("mFactory");
      c.setAccessible(true);
      return;
    }
    catch (Exception localException)
    {
      b = null;
      c = null;
    }
  }
  
  public SkinnableColorStateList(int[][] paramArrayOfInt, int[] paramArrayOfInt1)
  {
    super(h, null);
    this.d = paramArrayOfInt;
    this.e = paramArrayOfInt1;
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length > 0))
    {
      this.f = paramArrayOfInt1[0];
      while (n < paramArrayOfInt.length)
      {
        if (paramArrayOfInt[n].length == 0) {
          this.f = paramArrayOfInt1[n];
        }
        n += 1;
      }
    }
    if (SkinEngine.a) {
      a();
    }
  }
  
  private int a(int paramInt)
  {
    return idealByteArraySize(paramInt * 4) / 4;
  }
  
  private static SkinnableColorStateList a(SkinEngine paramSkinEngine, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    Object localObject = paramXmlPullParser.getName();
    if (((String)localObject).equals("selector"))
    {
      localObject = new SkinnableColorStateList((int[][])null, null);
      ((SkinnableColorStateList)localObject).b(paramSkinEngine, paramResources, paramXmlPullParser, paramAttributeSet, paramBoolean);
      return localObject;
    }
    throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": invalid drawable tag " + (String)localObject);
  }
  
  private void a()
  {
    try
    {
      Object localObject = b.newInstance(new Object[] { this });
      c.set(this, localObject);
      this.a = localObject;
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void b(SkinEngine paramSkinEngine, Resources paramResources, XmlPullParser paramXmlPullParser, AttributeSet paramAttributeSet, boolean paramBoolean)
  {
    int i8 = paramXmlPullParser.getDepth() + 1;
    int i5 = 20;
    int i4 = 0;
    Object localObject1 = new int[20];
    paramResources = new int[20][];
    int n;
    int i1;
    int i3;
    int i2;
    Object localObject2;
    int i6;
    int i7;
    label150:
    label172:
    Object localObject3;
    for (;;)
    {
      n = paramXmlPullParser.next();
      if (n == 1) {
        break label1035;
      }
      i1 = paramXmlPullParser.getDepth();
      if ((i1 < i8) && (n == 3)) {
        break label1035;
      }
      if ((n == 2) && (i1 <= i8) && (paramXmlPullParser.getName().equals("item")))
      {
        i3 = 0;
        i1 = -65536;
        i2 = 0;
        n = 0;
        int i9 = paramAttributeSet.getAttributeCount();
        localObject2 = new int[i9];
        i6 = 0;
        if (i6 < i9)
        {
          if (!paramBoolean) {
            break label403;
          }
          i7 = paramAttributeSet.getAttributeNameResource(i6);
          if (i7 != 0) {
            break;
          }
        }
        int[] arrayOfInt = StateSet.trimStateSet((int[])localObject2, n);
        if (i3 == 0) {
          break label997;
        }
        i1 = paramSkinEngine.getColor(i3);
        if ((i4 == 0) || (arrayOfInt.length == 0)) {
          this.f = i1;
        }
        localObject3 = paramResources;
        localObject2 = localObject1;
        n = i5;
        if (i4 + 1 >= i5)
        {
          n = a(i4 + 1);
          localObject2 = new int[n];
          System.arraycopy(localObject1, 0, localObject2, 0, i4);
          localObject1 = new int[n][];
          System.arraycopy(paramResources, 0, localObject1, 0, i4);
          paramResources = (Resources)localObject1;
          localObject3 = paramResources;
        }
        localObject2[i4] = i1;
        localObject3[i4] = arrayOfInt;
        i4 += 1;
        paramResources = (Resources)localObject3;
        localObject1 = localObject2;
        i5 = n;
      }
    }
    if (i7 == 16843173)
    {
      i3 = paramAttributeSet.getAttributeResourceValue(i6, 0);
      if (i3 != 0) {
        break label1078;
      }
      i2 = paramAttributeSet.getAttributeIntValue(i6, i1);
      i1 = 1;
    }
    for (;;)
    {
      i7 = i1;
      i1 = i2;
      for (i2 = i7;; i2 = 1)
      {
        i6 += 1;
        break;
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (;;)
        {
          localObject2[n] = i7;
          n += 1;
          i7 = i1;
          i1 = i2;
          i2 = i7;
          break;
          i7 = -i7;
        }
        label403:
        localObject3 = paramAttributeSet.getAttributeName(i6);
        if (!"color".equals(localObject3)) {
          break label444;
        }
        i1 = Color.parseColor(paramAttributeSet.getAttributeValue(i6));
      }
      label444:
      if ("state_window_focused".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16842909;; i7 = -16842909)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_selected".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16842913;; i7 = -16842913)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_focused".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16842908;; i7 = -16842908)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_enabled".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16842910;; i7 = -16842910)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_pressed".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16842919;; i7 = -16842919)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_checked".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16842912;; i7 = -16842912)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_activated".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16843518;; i7 = -16843518)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_accelerated".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16843547;; i7 = -16843547)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_hovered".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16843623;; i7 = -16843623)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if ("state_drag_can_accept".equals(localObject3))
      {
        if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
        for (i7 = 16843624;; i7 = -16843624)
        {
          localObject2[n] = i7;
          n += 1;
          break;
        }
      }
      if (!"state_drag_hovered".equals(localObject3)) {
        break label150;
      }
      if (paramAttributeSet.getAttributeBooleanValue(i6, false)) {}
      for (i7 = 16843625;; i7 = -16843625)
      {
        localObject2[n] = i7;
        n += 1;
        break;
      }
      label997:
      if (i2 != 0) {
        break label172;
      }
      throw new XmlPullParserException(paramXmlPullParser.getPositionDescription() + ": <item> tag requires a 'android:color' attribute.");
      label1035:
      this.e = new int[i4];
      this.d = new int[i4][];
      System.arraycopy(localObject1, 0, this.e, 0, i4);
      System.arraycopy(paramResources, 0, this.d, 0, i4);
      return;
      label1078:
      i7 = i1;
      i1 = i2;
      i2 = i7;
    }
  }
  
  public static SkinnableColorStateList createFromXml(SkinEngine paramSkinEngine, Resources paramResources, XmlPullParser paramXmlPullParser, boolean paramBoolean)
  {
    AttributeSet localAttributeSet;
    try
    {
      localAttributeSet = Xml.asAttributeSet(paramXmlPullParser);
      int n;
      do
      {
        n = paramXmlPullParser.next();
      } while ((n != 2) && (n != 1));
      if (n != 2) {
        throw new XmlPullParserException("No start tag found");
      }
    }
    catch (Exception paramSkinEngine)
    {
      if (SkinEngine.DEBUG) {
        Log.e("SkinEngine", "", paramSkinEngine);
      }
      return new SkinnableColorStateList(g, new int[] { -65281 });
    }
    paramSkinEngine = a(paramSkinEngine, paramResources, paramXmlPullParser, localAttributeSet, paramBoolean);
    return paramSkinEngine;
  }
  
  public static int idealByteArraySize(int paramInt)
  {
    int n = 4;
    for (;;)
    {
      int i1 = paramInt;
      if (n < 32)
      {
        if (paramInt <= (1 << n) - 12) {
          i1 = (1 << n) - 12;
        }
      }
      else {
        return i1;
      }
      n += 1;
    }
  }
  
  void a(SkinnableColorStateList paramSkinnableColorStateList)
  {
    this.d = paramSkinnableColorStateList.d;
    this.e = paramSkinnableColorStateList.e;
    this.f = paramSkinnableColorStateList.f;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public int getColorForState(int[] paramArrayOfInt, int paramInt)
  {
    int n = 0;
    int[][] arrayOfInt = (int[][])this.d.clone();
    int i2 = arrayOfInt.length;
    int i3 = this.e.length;
    this.i = i2;
    this.j = i3;
    this.k = false;
    this.l = false;
    this.m = SystemClock.uptimeMillis();
    for (;;)
    {
      int i1 = paramInt;
      if (n < i2)
      {
        if ((!StateSet.stateSetMatches(arrayOfInt[n], paramArrayOfInt)) || (i3 <= n)) {
          break label109;
        }
        this.l = true;
        i1 = paramInt;
        if (n < this.e.length) {
          i1 = this.e[n];
        }
      }
      return i1;
      label109:
      if (i3 <= n)
      {
        this.k = true;
        return paramInt;
      }
      n += 1;
    }
  }
  
  public int[] getColors()
  {
    return this.e;
  }
  
  public int getDefaultColor()
  {
    return this.f;
  }
  
  public int[][] getStateSpecs()
  {
    return this.d;
  }
  
  public boolean isStateful()
  {
    return true;
  }
  
  public void reset()
  {
    this.i = 0;
    this.j = 0;
    this.k = false;
    this.l = false;
    this.m = 0L;
  }
  
  public String toString()
  {
    return "ColorStateList{mStateSpecs=" + Arrays.deepToString(this.d) + "mColors=" + Arrays.toString(this.e) + "mDefaultColor=" + this.f + "mSetLength=" + this.i + "mColorLength=" + this.j + "mOutOfIndexFlag=" + this.k + "mReturnFromStateSetFlag=" + this.l + "mLastCallTs=" + this.m + '}';
  }
  
  public ColorStateList withAlpha(int paramInt)
  {
    int[] arrayOfInt = new int[this.e.length];
    int i1 = arrayOfInt.length;
    int n = 0;
    while (n < i1)
    {
      arrayOfInt[n] = (this.e[n] & 0xFFFFFF | paramInt << 24);
      n += 1;
    }
    return new ColorStateList(this.d, arrayOfInt);
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int n = this.d.length;
    paramParcel.writeInt(n);
    paramInt = 0;
    while (paramInt < n)
    {
      paramParcel.writeIntArray(this.d[paramInt]);
      paramInt += 1;
    }
    paramParcel.writeIntArray(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.theme.SkinnableColorStateList
 * JD-Core Version:    0.7.0.1
 */