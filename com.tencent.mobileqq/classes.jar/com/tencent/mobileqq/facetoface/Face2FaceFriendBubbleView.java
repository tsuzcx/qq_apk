package com.tencent.mobileqq.facetoface;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.FaceDrawable;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class Face2FaceFriendBubbleView
  extends FrameLayout
{
  private static final int[] a = { 2131433821, 2131433803 };
  private LinearLayout b;
  private ImageView c = null;
  private ImageView d = null;
  private ImageView e = null;
  private View f = null;
  private ProgressBar g = null;
  private TextView h = null;
  private Animation i = null;
  private Animation j = null;
  private HashMap<View, Integer> k = null;
  private String l = null;
  private int m = 1;
  private String n = "";
  private int o = 0;
  private int p = 0;
  private int q = 1;
  private Animation.AnimationListener r = new Face2FaceFriendBubbleView.1(this);
  private Animation.AnimationListener s = new Face2FaceFriendBubbleView.2(this);
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 0);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131624772, this);
    this.b = ((LinearLayout)findViewById(2131433819));
    this.c = ((ImageView)findViewById(2131433779));
    this.d = ((ImageView)findViewById(2131447968));
    this.f = findViewById(2131433821);
    this.e = ((ImageView)findViewById(2131433820));
    this.g = ((ProgressBar)findViewById(2131446337));
    this.h = ((TextView)findViewById(2131433805));
    this.h.setContentDescription("");
    this.i = AnimationUtils.loadAnimation(paramContext, 2130772089);
    this.j = AnimationUtils.loadAnimation(paramContext, 2130772088);
    this.i.setAnimationListener(this.r);
    this.j.setAnimationListener(this.s);
  }
  
  public void a()
  {
    int i2 = a.length;
    Object localObject = this.k;
    if (localObject == null) {
      this.k = new HashMap(i2);
    } else if (!((HashMap)localObject).isEmpty()) {
      this.k.clear();
    }
    int i1 = 0;
    while (i1 < i2)
    {
      localObject = findViewById(a[i1]);
      int i3 = ((View)localObject).getVisibility();
      this.k.put(localObject, Integer.valueOf(i3));
      if (i3 == 0)
      {
        Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772086);
        localAnimation.setAnimationListener(new Face2FaceFriendBubbleView.DetailViewAnimationListener(this, 1, (View)localObject));
        ((View)localObject).startAnimation(localAnimation);
      }
      i1 += 1;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, Face2FaceUserData paramFace2FaceUserData)
  {
    if (paramFace2FaceUserData == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(Face2FaceAddFriendActivity.a, 2, "bindFriendInfo Face2FaceUserData is Null~~~~~");
      }
      return;
    }
    setTag(paramFace2FaceUserData);
    this.l = paramFace2FaceUserData.f;
    this.m = paramFace2FaceUserData.e;
    this.n = paramFace2FaceUserData.f;
    boolean bool = paramFace2FaceUserData instanceof Face2FaceGroupProfile;
    Object localObject;
    if (bool)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramFace2FaceUserData.f);
      ((StringBuilder)localObject).append("_");
      ((StringBuilder)localObject).append(((Face2FaceGroupProfile)paramFace2FaceUserData).b);
      this.n = ((StringBuilder)localObject).toString();
    }
    String str = paramFace2FaceUserData.f;
    int i2 = this.m;
    int i1;
    if (i2 == 1)
    {
      paramFace2FaceUserData = (NearbyUser)paramFace2FaceUserData;
      if (TextUtils.isEmpty(paramFace2FaceUserData.b)) {
        paramFace2FaceUserData = paramFace2FaceUserData.c;
      } else {
        paramFace2FaceUserData = paramFace2FaceUserData.b;
      }
      this.h.setLines(1);
      this.d.setVisibility(8);
      localObject = paramFace2FaceUserData;
      i1 = i2;
    }
    else
    {
      localObject = str;
      i1 = i2;
      if (i2 == 2) {
        if ((paramFace2FaceUserData instanceof Face2FaceUserProfile))
        {
          localObject = ((Face2FaceUserProfile)paramFace2FaceUserData).a;
          this.h.setLines(1);
          this.d.setVisibility(8);
          i1 = 1;
        }
        else
        {
          localObject = str;
          i1 = i2;
          if (bool)
          {
            paramFace2FaceUserData = ((Face2FaceGroupProfile)paramFace2FaceUserData).a;
            this.d.setVisibility(0);
            if (this.o < 1)
            {
              this.p = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297352);
              this.o = BaseApplicationImpl.getContext().getResources().getDrawable(2130840342).getIntrinsicWidth();
            }
            this.h.setLines(2);
            this.h.setMaxWidth(this.p - this.o);
            localObject = paramFace2FaceUserData;
            i1 = i2;
            if (QLog.isColorLevel())
            {
              localObject = new StringBuilder();
              ((StringBuilder)localObject).append("nickMaxWidth = ");
              ((StringBuilder)localObject).append(this.p);
              ((StringBuilder)localObject).append(", flagWidth = ");
              ((StringBuilder)localObject).append(this.o);
              ((StringBuilder)localObject).append(", realWidth = ");
              ((StringBuilder)localObject).append(this.p - this.o);
              QLog.e("zivonchen", 2, ((StringBuilder)localObject).toString());
              i1 = i2;
              localObject = paramFace2FaceUserData;
            }
          }
        }
      }
    }
    if (localObject == null)
    {
      paramFace2FaceUserData = this.l;
    }
    else
    {
      paramFace2FaceUserData = (Face2FaceUserData)localObject;
      if (TextUtils.isEmpty(((String)localObject).trim())) {
        paramFace2FaceUserData = this.l;
      }
    }
    this.h.setText(paramFace2FaceUserData);
    a(paramQQAppInterface, this.l, i1);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramQQAppInterface = FaceDrawable.getFaceDrawable(paramQQAppInterface, 1, paramString);
      this.c.setImageDrawable(paramQQAppInterface);
      return;
    }
    if (paramInt == 2)
    {
      paramQQAppInterface = FaceDrawable.getFaceDrawable(paramQQAppInterface, 4, paramString);
      this.c.setImageDrawable(paramQQAppInterface);
    }
  }
  
  public void a(String paramString)
  {
    this.h.setText(paramString);
  }
  
  public void b()
  {
    int i2 = a.length;
    Object localObject = this.k;
    if ((localObject != null) && (((HashMap)localObject).size() == i2))
    {
      int i1 = 0;
      while (i1 < i2)
      {
        localObject = findViewById(a[i1]);
        if ((((Integer)this.k.get(localObject)).intValue() == 0) && (((View)localObject).getVisibility() == 4))
        {
          Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772087);
          localAnimation.setAnimationListener(new Face2FaceFriendBubbleView.DetailViewAnimationListener(this, 0, (View)localObject));
          ((View)localObject).startAnimation(localAnimation);
        }
        i1 += 1;
      }
      this.k.clear();
      return;
    }
    localObject = this.k;
    if (localObject != null) {
      ((HashMap)localObject).clear();
    }
    if (QLog.isColorLevel()) {
      QLog.e(Face2FaceAddFriendActivity.a, 2, "restoreAndHideLables error: ids.size not equals cache.size~~~~~");
    }
  }
  
  public Face2FaceUserData getBindFriendInfo()
  {
    if (getTag() != null) {
      return (Face2FaceUserData)getTag();
    }
    return null;
  }
  
  public String getDisplayName()
  {
    String str2 = this.h.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2.trim())) {
      str1 = this.l;
    }
    return str1;
  }
  
  public String getIdentify()
  {
    return this.n;
  }
  
  public int getStatus()
  {
    return this.q;
  }
  
  public String getUin()
  {
    return this.l;
  }
  
  public int getUinType()
  {
    return this.m;
  }
  
  public void setStatusWithAnimation(int paramInt)
  {
    if (paramInt != 1)
    {
      if ((paramInt == 2) || (paramInt == 3) || (paramInt == 4))
      {
        this.q = paramInt;
        if (this.f.getVisibility() == 0)
        {
          this.f.startAnimation(this.j);
        }
        else
        {
          if (this.f.getVisibility() == 8) {
            this.f.setVisibility(4);
          }
          this.f.startAnimation(this.i);
        }
      }
    }
    else
    {
      this.q = paramInt;
      if (this.f.getVisibility() == 0) {
        this.f.startAnimation(this.j);
      }
    }
    String str = getDisplayName();
    Object localObject;
    if (paramInt == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131902311));
      localObject = ((StringBuilder)localObject).toString();
    }
    else if (paramInt == 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(str);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131902309));
      localObject = ((StringBuilder)localObject).toString();
    }
    else
    {
      localObject = str;
      if (paramInt == 4)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append(HardCodeUtil.a(2131902313));
        localObject = ((StringBuilder)localObject).toString();
      }
    }
    this.c.setContentDescription((CharSequence)localObject);
    this.b.setContentDescription((CharSequence)localObject);
  }
  
  public void setStatusWithoutAnimation(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return;
          }
          this.q = paramInt;
          this.g.setVisibility(0);
          this.e.setImageResource(2130840325);
          this.e.setVisibility(0);
          this.f.setVisibility(0);
          return;
        }
        this.q = paramInt;
        this.g.setVisibility(8);
        this.e.setImageResource(2130840324);
        this.e.setVisibility(0);
        this.f.setVisibility(0);
        return;
      }
      this.q = paramInt;
      this.g.setVisibility(8);
      this.e.setImageResource(2130840323);
      this.e.setVisibility(0);
      this.f.setVisibility(0);
      return;
    }
    this.q = paramInt;
    this.f.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView
 * JD-Core Version:    0.7.0.1
 */