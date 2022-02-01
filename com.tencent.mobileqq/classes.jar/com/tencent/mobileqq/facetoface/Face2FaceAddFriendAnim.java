package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Face2FaceAddFriendAnim
{
  public static byte[] z = new byte[0];
  List<Integer> A = Arrays.asList(new Integer[] { Integer.valueOf(2131433684), Integer.valueOf(2131433686), Integer.valueOf(2131433687), Integer.valueOf(2131433688), Integer.valueOf(2131433689), Integer.valueOf(2131433690), Integer.valueOf(2131433691), Integer.valueOf(2131433692), Integer.valueOf(2131433693), Integer.valueOf(2131433685) });
  public QQAppInterface B;
  public Context C;
  int a = 1;
  double b = 0.0D;
  float c = 0.0F;
  float d = 0.0F;
  boolean e = false;
  int f = -1;
  boolean g = false;
  public int h;
  public int i;
  ImageView j;
  public List<Face2FaceFriendBubbleView> k;
  List<Integer> l;
  List<Integer> m;
  Map<String, Integer> n;
  List<Integer> o;
  List<Integer> p;
  int q = 0;
  int r = -1;
  int s;
  Face2FaceUserData t = null;
  int u = 0;
  int v = 0;
  int w = 0;
  int x = 0;
  RotateAnimation y;
  
  public Face2FaceAddFriendAnim(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    this.B = paramQQAppInterface;
    this.C = paramContext;
  }
  
  private static int b(int paramInt1, int paramInt2)
  {
    double d1 = Math.random();
    double d2 = paramInt2 - paramInt1 + 1;
    Double.isNaN(d2);
    double d3 = paramInt1;
    Double.isNaN(d3);
    return (int)(d1 * d2 + d3);
  }
  
  public float a(int paramInt1, int paramInt2)
  {
    double d1 = Math.random();
    double d2 = paramInt2 - paramInt1;
    Double.isNaN(d2);
    double d3 = paramInt1;
    Double.isNaN(d3);
    return (float)(d1 * d2 + d3);
  }
  
  public Face2FaceFriendBubbleView a(String paramString)
  {
    if (this.n.containsKey(paramString)) {
      return (Face2FaceFriendBubbleView)this.k.get(((Integer)this.n.get(paramString)).intValue());
    }
    return null;
  }
  
  public void a()
  {
    this.n.clear();
    this.l.clear();
    this.m.clear();
    this.o.clear();
    this.p.clear();
    this.k.clear();
  }
  
  public void a(int paramInt)
  {
    Face2FaceFriendBubbleView localFace2FaceFriendBubbleView = (Face2FaceFriendBubbleView)this.k.get(paramInt);
    if ((localFace2FaceFriendBubbleView != null) && (localFace2FaceFriendBubbleView.getIdentify() != null) && (this.n.containsKey(localFace2FaceFriendBubbleView.getIdentify())))
    {
      this.n.remove(localFace2FaceFriendBubbleView.getIdentify());
      localFace2FaceFriendBubbleView.setVisibility(4);
      localFace2FaceFriendBubbleView.setStatusWithoutAnimation(1);
      localFace2FaceFriendBubbleView.setClickable(false);
      if (QLog.isColorLevel())
      {
        String str = Face2FaceAddFriendActivity.a;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("removeShowedFriendMap uinToHoleIndex remove( ");
        localStringBuilder.append(localFace2FaceFriendBubbleView.getIdentify());
        localStringBuilder.append(", ");
        localStringBuilder.append(paramInt);
        localStringBuilder.append(" )");
        QLog.d(str, 2, localStringBuilder.toString());
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    if (this.C == null) {
      return;
    }
    long l1 = 750L;
    if (paramInt == 1)
    {
      this.d = a(45, 180);
      if (a(0, 1) < 0.5D) {
        this.d *= -1.0F;
      }
      l1 = a(800, 1500);
    }
    RotateAnimation localRotateAnimation = new RotateAnimation(this.c, this.d, 1, 0.5F, 1, 0.5F);
    localRotateAnimation.setDuration(l1);
    localRotateAnimation.setFillAfter(true);
    localRotateAnimation.setInterpolator(new Face2FaceAddFriendAnim.EaseInOutElasticInterpolator(this));
    this.j.startAnimation(localRotateAnimation);
    localRotateAnimation.setAnimationListener(new Face2FaceAddFriendAnim.3(this, paramInt, paramBoolean));
  }
  
  public void a(QQAppInterface paramQQAppInterface, View paramView, int paramInt, String paramString)
  {
    Context localContext = this.C;
    if (localContext == null) {
      return;
    }
    this.h = localContext.getResources().getDisplayMetrics().widthPixels;
    this.i = this.C.getResources().getDisplayMetrics().heightPixels;
    this.j = ((ImageView)paramView.findViewById(2131431179));
    if ((paramInt == 1) && (!TextUtils.isEmpty(paramString)))
    {
      ((ImageView)paramView.findViewById(2131431180)).setVisibility(4);
      this.j.setImageResource(2130840321);
      paramString = paramQQAppInterface.getTroopFaceBitmap(paramString, (byte)3, false, false);
      paramQQAppInterface = paramString;
      if (paramString == null) {
        paramQQAppInterface = ImageUtil.g();
      }
      paramString = (ImageView)paramView.findViewById(2131447939);
      paramString.setImageBitmap(paramQQAppInterface);
      paramString.setVisibility(0);
    }
    this.k = new ArrayList();
    paramInt = 0;
    while (paramInt < 10)
    {
      paramQQAppInterface = (Face2FaceFriendBubbleView)paramView.findViewById(((Integer)this.A.get(paramInt)).intValue());
      paramQQAppInterface.setStatusWithAnimation(1);
      paramQQAppInterface.setOnClickListener((View.OnClickListener)this.C);
      this.k.add(paramQQAppInterface);
      paramInt += 1;
    }
    this.l = new LinkedList();
    this.n = new HashMap();
    this.m = new LinkedList();
    this.m.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7), Integer.valueOf(8), Integer.valueOf(9) }));
    this.o = new LinkedList();
    this.o.addAll(Arrays.asList(new Integer[] { Integer.valueOf(2), Integer.valueOf(3), Integer.valueOf(4), Integer.valueOf(5), Integer.valueOf(6), Integer.valueOf(7) }));
    this.p = new LinkedList();
    this.p.addAll(Arrays.asList(new Integer[] { Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(8), Integer.valueOf(9) }));
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean)
  {
    Object localObject1;
    Object localObject2;
    if ((paramFace2FaceUserData != null) && (this.C != null))
    {
      localObject1 = paramFace2FaceUserData.f;
      if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramFace2FaceUserData.f);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(((Face2FaceGroupProfile)paramFace2FaceUserData).b);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      int i1;
      if (this.n.containsKey(localObject1)) {
        i1 = ((Integer)this.n.get(localObject1)).intValue();
      } else {
        i1 = -1;
      }
      if (i1 == -1)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = Face2FaceAddFriendActivity.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear uin ");
          ((StringBuilder)localObject2).append(paramFace2FaceUserData.f.substring(0, 4));
          ((StringBuilder)localObject2).append(" is not in the hole");
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          localObject1 = Face2FaceAddFriendActivity.b;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear uin ");
          ((StringBuilder)localObject2).append(paramFace2FaceUserData.f.substring(0, 4));
          ((StringBuilder)localObject2).append(" is not in the hole");
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
          this.u += 1;
        }
        return;
      }
      localObject1 = (Face2FaceFriendBubbleView)this.k.get(i1);
      if (paramBoolean)
      {
        localObject2 = new ScaleAnimation(1.0F, 0.4F, 1.0F, 0.4F, 1, 0.5F, 1, 0.5F);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.0F);
        AnimationSet localAnimationSet = new AnimationSet(true);
        localAnimationSet.addAnimation((Animation)localObject2);
        localAnimationSet.addAnimation(localAlphaAnimation);
        localAnimationSet.setDuration(1000L);
        localAnimationSet.setFillAfter(true);
        localAnimationSet.setInterpolator(new Face2FaceAddFriendAnim.EaseOutQuartInterpolator(this));
        localAnimationSet.setAnimationListener(new Face2FaceAddFriendAnim.2(this));
        if (localObject1 != null) {
          ((Face2FaceFriendBubbleView)localObject1).startAnimation(localAnimationSet);
        }
      }
      if (localObject1 != null)
      {
        if (QLog.isColorLevel())
        {
          localObject1 = Face2FaceAddFriendActivity.a;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear uin ");
          ((StringBuilder)localObject2).append(paramFace2FaceUserData.f.substring(0, 4));
          QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
        }
        if (this.l.contains(Integer.valueOf(i1))) {
          this.l.remove(Integer.valueOf(i1));
        }
        a(i1);
        ((Face2FaceAddFriendActivity)this.C).c(paramFace2FaceUserData);
        this.m.add(Integer.valueOf(i1));
        if ((i1 >= 2) && (i1 <= 7))
        {
          this.o.add(Integer.valueOf(i1));
          return;
        }
        if (((i1 >= 0) && (i1 <= 1)) || ((i1 >= 8) && (i1 <= 9))) {
          this.p.add(Integer.valueOf(i1));
        }
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = Face2FaceAddFriendActivity.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startFriendDisappearAnimation disappear data is ");
      ((StringBuilder)localObject2).append(paramFace2FaceUserData);
      ((StringBuilder)localObject2).append(" mContext ");
      ((StringBuilder)localObject2).append(this.C);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void a(Face2FaceUserData paramFace2FaceUserData, boolean paramBoolean1, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    Object localObject1;
    label235:
    Object localObject2;
    if ((paramFace2FaceUserData != null) && (this.C != null))
    {
      if (this.m.size() == 1) {
        i1 = ((Integer)this.m.get(0)).intValue();
      }
      for (;;)
      {
        i3 = i1;
        break label235;
        if (this.m.size() <= 1) {
          break;
        }
        if (this.o.size() == 1)
        {
          i1 = ((Integer)this.o.get(0)).intValue();
        }
        else if (this.o.size() > 1)
        {
          localObject1 = this.o;
          i1 = ((Integer)((List)localObject1).get(b(0, ((List)localObject1).size() - 1))).intValue();
        }
        else if (this.p.size() == 0)
        {
          i1 = ((Integer)this.p.get(0)).intValue();
        }
        else
        {
          if (this.p.size() <= 1) {
            break;
          }
          localObject1 = this.p;
          i1 = ((Integer)((List)localObject1).get(b(0, ((List)localObject1).size() - 1))).intValue();
        }
      }
      int i3 = -1;
      if (i3 == -1) {
        return;
      }
      localObject1 = (Face2FaceFriendBubbleView)this.k.get(i3);
      this.s = i3;
      if (localObject1 == null) {
        return;
      }
      this.t = paramFace2FaceUserData;
      ((Face2FaceFriendBubbleView)localObject1).a(this.B, paramFace2FaceUserData);
      ((Face2FaceFriendBubbleView)localObject1).setVisibility(0);
      ((Face2FaceFriendBubbleView)localObject1).setClickable(true);
      StringBuilder localStringBuilder;
      if (QLog.isColorLevel()) {
        if (!TextUtils.isEmpty(paramFace2FaceUserData.f))
        {
          localObject2 = Face2FaceAddFriendActivity.a;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("startFriendInAnimation get ( currentUin= ");
          localStringBuilder.append(paramFace2FaceUserData.f.substring(0, 4));
          localStringBuilder.append(" , index = ");
          localStringBuilder.append(i3);
          localStringBuilder.append(" )");
          QLog.d((String)localObject2, 2, localStringBuilder.toString());
        }
        else
        {
          QLog.d(Face2FaceAddFriendActivity.a, 2, "startFriendInAnimation get  currentUin= null");
        }
      }
      this.a = 1;
      this.g = false;
      this.f = -1;
      localObject2 = new int[2];
      this.j.getLocationOnScreen((int[])localObject2);
      int i7 = localObject2[0] + (this.j.getWidth() >> 1);
      int i9 = localObject2[1] + (this.j.getHeight() >> 1);
      localObject2 = new int[2];
      ((Face2FaceFriendBubbleView)localObject1).getLocationOnScreen((int[])localObject2);
      int i8 = localObject2[0] + (((Face2FaceFriendBubbleView)localObject1).getWidth() >> 1);
      int i10 = localObject2[1] + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
      int i5 = Math.abs(i7 - i8);
      int i6 = Math.abs(i9 - i10);
      double d1 = i5;
      double d2 = i6;
      Double.isNaN(d1);
      Double.isNaN(d2);
      this.b = (d1 / d2);
      int i1 = ((Face2FaceFriendBubbleView)localObject1).getWidth();
      if (i5 == 0)
      {
        i1 = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + i9;
        if (i10 > i9) {
          i1 = this.i - i9 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
        }
      }
      else
      {
        i1 = ((i1 >> 1) + i7) * i6 / i5;
      }
      int i2 = localObject2[0] + ((Face2FaceFriendBubbleView)localObject1).getWidth();
      int i4 = i1 - i6;
      if (i10 > i9) {
        this.a = 2;
      }
      if (i8 > i7)
      {
        i2 = this.h - localObject2[0];
        if (i10 < i9) {
          this.a = 5;
        } else {
          this.a = 6;
        }
      }
      if ((i1 - i9 < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) && (i1 - (this.i - i9) < ((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1))
      {
        i1 = i2;
        i2 = i4;
      }
      else
      {
        if (i10 < i9)
        {
          i2 = (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1) + i9;
          i1 = localObject2[1] + ((Face2FaceFriendBubbleView)localObject1).getHeight();
          if (i8 < i7) {
            this.a = 3;
          } else {
            this.a = 4;
          }
        }
        for (;;)
        {
          break;
          i2 = i1;
          i1 = i4;
          if (i10 <= i9) {
            break;
          }
          i2 = this.i - i9 + (((Face2FaceFriendBubbleView)localObject1).getHeight() >> 1);
          i1 = this.i - localObject2[1];
          if (i8 < i7) {
            this.a = 7;
          } else {
            this.a = 8;
          }
        }
        i4 = i2 * i5 / i6 - i5;
        i2 = i1;
        i1 = i4;
      }
      switch (this.a)
      {
      default: 
        break;
      case 8: 
        this.f = 1;
        this.g = true;
        break;
      case 7: 
        i1 = -i1;
        this.f = -1;
        this.g = true;
        break;
      case 6: 
        this.f = 1;
        this.g = true;
        break;
      case 5: 
        i2 = -i2;
        this.f = 1;
        this.g = false;
        break;
      case 4: 
        i2 = -i2;
        this.f = 1;
        this.g = false;
        break;
      case 3: 
        i1 = -i1;
        i2 = -i2;
        this.f = -1;
        this.g = false;
        break;
      case 2: 
        i1 = -i1;
        this.f = -1;
        this.g = true;
        break;
      case 1: 
        i1 = -i1;
        i2 = -i2;
        this.f = -1;
        this.g = false;
      }
      d1 = this.b;
      boolean bool = this.g;
      localObject2 = new TranslateAnimation(i1, 0.0F, i2, 0.0F);
      ((TranslateAnimation)localObject2).setDuration(400L);
      ((TranslateAnimation)localObject2).setInterpolator(new Face2FaceAddFriendAnim.EaseOutQuartInterpolator(this));
      ((TranslateAnimation)localObject2).setAnimationListener(new Face2FaceAddFriendAnim.1(this, paramFace2FaceUserData, i3, d1, bool, paramBoolean3, paramFace2FaceUserData, paramBoolean1, paramBoolean2, (Face2FaceFriendBubbleView)localObject1, paramInt));
      ((Face2FaceFriendBubbleView)localObject1).startAnimation((Animation)localObject2);
      localObject1 = paramFace2FaceUserData.f;
      if ((paramFace2FaceUserData instanceof Face2FaceGroupProfile))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramFace2FaceUserData.f);
        ((StringBuilder)localObject1).append("_");
        ((StringBuilder)localObject1).append(((Face2FaceGroupProfile)paramFace2FaceUserData).b);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      this.n.put(localObject1, Integer.valueOf(i3));
      ((Face2FaceAddFriendActivity)this.C).a(paramFace2FaceUserData, paramBoolean1, paramBoolean2);
      if (QLog.isColorLevel())
      {
        localObject2 = Face2FaceAddFriendActivity.b;
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("uinToHoleIndex put identify=");
        localStringBuilder.append((String)localObject1);
        QLog.d((String)localObject2, 2, localStringBuilder.toString());
      }
      this.m.remove(Integer.valueOf(i3));
      if (this.o.contains(Integer.valueOf(i3))) {
        this.o.remove(Integer.valueOf(i3));
      } else if (this.p.contains(Integer.valueOf(i3))) {
        this.p.remove(Integer.valueOf(i3));
      }
      if (QLog.isColorLevel())
      {
        localObject1 = Face2FaceAddFriendActivity.a;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("startFriendInAnimation currentUIn= ");
        ((StringBuilder)localObject2).append(paramFace2FaceUserData.f.substring(0, 4));
        ((StringBuilder)localObject2).append(" startAnimation OK");
        QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
      }
      return;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = Face2FaceAddFriendActivity.a;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("startFriendInAnimation  data is ");
      ((StringBuilder)localObject2).append(paramFace2FaceUserData);
      ((StringBuilder)localObject2).append(" mContext ");
      ((StringBuilder)localObject2).append(this.C);
      QLog.d((String)localObject1, 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  public void b()
  {
    if (this.C == null) {
      return;
    }
    long l1 = a(800, 1200);
    float f1 = this.d;
    int i1 = (int)a(5, 12);
    if (this.e)
    {
      this.e = false;
      this.d = (this.c - i1);
    }
    else
    {
      this.e = true;
      this.d = (this.c + i1);
    }
    float f2 = this.d;
    if (f1 == f2)
    {
      float f3 = this.c;
      if (f2 > f3) {
        this.d = (f3 - i1);
      } else {
        this.d = (f3 + i1);
      }
    }
    this.y = new RotateAnimation(f1, this.d, 1, 0.5F, 1, 0.5F);
    this.y.setDuration(l1);
    this.y.setFillAfter(true);
    this.y.setInterpolator(new Face2FaceAddFriendAnim.EaseInOutElasticInterpolator(this));
    this.j.startAnimation(this.y);
    this.y.setAnimationListener(new Face2FaceAddFriendAnim.4(this));
  }
  
  public void b(String paramString)
  {
    if ((this.n.containsKey(paramString)) && (!this.l.contains(paramString))) {
      this.l.add(this.n.get(paramString));
    }
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Face2FaceAddFriendActivity", 2, "stopCompassShakeAnimation");
    }
    Object localObject = this.y;
    if (localObject != null) {
      ((RotateAnimation)localObject).cancel();
    }
    localObject = this.j;
    if (localObject != null) {
      ((ImageView)localObject).clearAnimation();
    }
  }
  
  public void c(String paramString)
  {
    if (this.n.containsKey(paramString)) {
      this.l.remove(this.n.get(paramString));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceAddFriendAnim
 * JD-Core Version:    0.7.0.1
 */