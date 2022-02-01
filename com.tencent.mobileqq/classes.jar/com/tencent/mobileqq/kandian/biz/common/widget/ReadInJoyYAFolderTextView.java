package com.tencent.mobileqq.kandian.biz.common.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.DynamicLayout;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.text.style.ClickableSpan;
import android.util.AttributeSet;
import android.util.Pair;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView.BufferType;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.view.widget.text.ClickableSpanPressed;
import com.tencent.mobileqq.kandian.biz.pts.component.CmpCtxt;
import com.tencent.mobileqq.kandian.biz.pts.component.CommonBasicComponent.UserSpan;
import com.tencent.mobileqq.kandian.biz.pts.component.ComponentHeaderNewSocial.BiuUserStruct;
import com.tencent.mobileqq.kandian.repo.aladdin.handlers.DailyModeConfigHandler;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.ArticleViewModel;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UGCFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.handler.BiuCommentInfo;
import com.tencent.mobileqq.kandian.repo.handler.BiuInfo;
import com.tencent.mobileqq.service.message.EmotionCodecUtils;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.text.style.EmoticonSpan;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.launcher.dynamic.Reflect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import org.jetbrains.annotations.NotNull;

public class ReadInJoyYAFolderTextView
  extends TextView
{
  private static final char[] k = { '…' };
  private static final String l = new String(k);
  protected ArticleViewModel a;
  public boolean b = false;
  protected int c = -15504151;
  private CharSequence d;
  private String e = "...";
  private String f = HardCodeUtil.a(2131910554);
  private int g = 5;
  private TextView.BufferType h;
  private Object i;
  private boolean j;
  private int m = -1;
  private boolean n = false;
  @android.support.annotation.Nullable
  private Pair<Integer, Reflect> o;
  private SpannableStringBuilder p = new SpannableStringBuilder();
  private int q = -1;
  private int r = -1;
  private Vector<ClickableSpan> s = new Vector();
  
  public ReadInJoyYAFolderTextView(Context paramContext)
  {
    super(paramContext);
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @android.support.annotation.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @android.support.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private float a(TextPaint paramTextPaint, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.e).append(this.f);
    Object localObject = this.i;
    if (localObject != null) {
      paramSpannableStringBuilder.setSpan(localObject, paramSpannableStringBuilder.length() - this.f.length(), paramSpannableStringBuilder.length(), 33);
    }
    return paramTextPaint.measureText(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.length());
  }
  
  private int a(int paramInt, CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan)
  {
    int i2 = this.p.length();
    int i1;
    if (a(paramCharSequence))
    {
      this.p.append(paramCharSequence.subSequence(0, paramCharSequence.length() - 1)).append('\n');
      i1 = paramCharSequence.length() - 1;
    }
    else
    {
      this.p.append(paramCharSequence.subSequence(0, paramCharSequence.length() - 3)).append('\n');
      i1 = paramCharSequence.length() - 3;
    }
    a((Spanned)paramCharSequence, paramArrayOfClickableSpan, i2);
    return paramInt + i1;
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = (EmoticonSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), EmoticonSpan.class);
    int i1 = paramSpannableStringBuilder.length();
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[(localObject.length - 1)];
      if (paramSpannableStringBuilder.getSpanEnd(localObject) == i1) {
        return new SpannableStringBuilder(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.getSpanStart(localObject));
      }
    }
    return new SpannableStringBuilder(paramSpannableStringBuilder, 0, i1 - 1);
  }
  
  @NotNull
  private CharSequence a(int paramInt1, int paramInt2, TextPaint paramTextPaint, CharSequence paramCharSequence)
  {
    Object localObject = paramCharSequence;
    if (paramCharSequence.length() > 4)
    {
      localObject = paramCharSequence;
      if ((paramCharSequence instanceof SpannableStringBuilder))
      {
        localObject = paramCharSequence.subSequence(0, paramCharSequence.length() - 3);
        CharSequence localCharSequence = paramCharSequence.subSequence(0, paramCharSequence.length() - 1);
        if ((paramCharSequence.charAt(paramCharSequence.length() - 1) != '…') && (paramTextPaint.measureText(((CharSequence)localObject).toString()) > paramInt2 - paramInt1)) {
          return a((SpannableStringBuilder)localObject).append(l);
        }
        localObject = paramCharSequence;
        if (paramTextPaint.measureText(localCharSequence.toString()) > paramInt2 - paramInt1) {
          localObject = a((SpannableStringBuilder)localCharSequence).append(l);
        }
      }
    }
    return localObject;
  }
  
  private CharSequence a(ArrayList<CharSequence> paramArrayList, int paramInt1, int paramInt2)
  {
    paramArrayList = (CharSequence)paramArrayList.get(paramInt1);
    return paramArrayList.subSequence(paramInt2, paramArrayList.length());
  }
  
  private void a(int paramInt1, int paramInt2, TextPaint paramTextPaint, float paramFloat, ArrayList<CharSequence> paramArrayList, int paramInt3, int paramInt4, int paramInt5)
  {
    if (paramInt3 < paramArrayList.size())
    {
      CharSequence localCharSequence = a(paramArrayList, paramInt3, paramInt4);
      paramTextPaint = TextUtils.ellipsize(localCharSequence, paramTextPaint, paramInt2 - paramInt1 - paramFloat, TextUtils.TruncateAt.END);
      ClickableSpan[] arrayOfClickableSpan = a(paramInt5, paramTextPaint);
      if ((!paramTextPaint.equals(localCharSequence)) && (paramTextPaint.length() > 0))
      {
        paramInt1 = this.p.length();
        if (a(paramTextPaint)) {
          this.p.append(paramTextPaint.subSequence(0, paramTextPaint.length() - 1));
        } else {
          this.p.append(paramTextPaint.subSequence(0, paramTextPaint.length() - 3));
        }
        a(paramTextPaint, arrayOfClickableSpan, paramInt1);
        return;
      }
      if (paramInt3 != paramArrayList.size() - 1)
      {
        paramInt1 = this.p.length();
        this.p.append(paramTextPaint);
        a(paramTextPaint, arrayOfClickableSpan, paramInt1);
        return;
      }
      if (this.m > this.g)
      {
        paramInt1 = this.p.length();
        this.p.append(paramTextPaint);
        a(paramTextPaint, arrayOfClickableSpan, paramInt1, false);
      }
    }
  }
  
  private void a(DynamicLayout paramDynamicLayout)
  {
    if (Build.VERSION.SDK_INT == 26) {
      try
      {
        int i1 = paramDynamicLayout.hashCode();
        if ((this.o != null) && (this.o.first != null) && (this.o.second != null) && (((Integer)this.o.first).intValue() == i1))
        {
          paramDynamicLayout = (Reflect)this.o.second;
        }
        else
        {
          paramDynamicLayout = Reflect.on(paramDynamicLayout);
          this.o = new Pair(Integer.valueOf(i1), paramDynamicLayout);
        }
        paramDynamicLayout.set("sStaticLayout", null);
        return;
      }
      catch (Exception paramDynamicLayout)
      {
        QLog.e("ReadInJoyYAFolderTextView", 2, paramDynamicLayout.getMessage());
      }
    }
  }
  
  private void a(DynamicLayout paramDynamicLayout, int paramInt)
  {
    int i1 = paramInt - 1;
    paramInt = paramDynamicLayout.getLineStart(i1);
    i1 = paramDynamicLayout.getLineEnd(i1);
    paramDynamicLayout = paramDynamicLayout.getText();
    String str1 = paramDynamicLayout.subSequence(paramInt, i1).toString();
    String str2 = HardCodeUtil.a(2131910265);
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if ((!str1.equals(str2.substring(1))) && (!str1.equals(str2.substring(2))) && (!str1.equals(str2.substring(3))))
    {
      if (str1.equals(" "))
      {
        localSpannableStringBuilder.append(paramDynamicLayout.subSequence(0, paramDynamicLayout.length() - 1));
        super.setText(localSpannableStringBuilder);
      }
    }
    else
    {
      localSpannableStringBuilder.append(paramDynamicLayout.subSequence(0, paramDynamicLayout.length() - str2.length())).append('\n').append(paramDynamicLayout.subSequence(paramDynamicLayout.length() - str2.length(), paramDynamicLayout.length()));
      super.setText(localSpannableStringBuilder);
    }
  }
  
  private void a(Spanned paramSpanned, ClickableSpan[] paramArrayOfClickableSpan, int paramInt)
  {
    if ((paramArrayOfClickableSpan != null) && (paramArrayOfClickableSpan.length > 0))
    {
      int i1 = this.p.getSpanStart(paramArrayOfClickableSpan[0]);
      int i2 = this.p.getSpanEnd(paramArrayOfClickableSpan[0]);
      if ((i1 >= 0) && (i2 >= i1) && (i2 < paramInt))
      {
        paramInt = paramSpanned.getSpanStart(paramArrayOfClickableSpan[0]);
        int i3 = paramSpanned.getSpanEnd(paramArrayOfClickableSpan[0]);
        if ((paramInt == 0) && (i3 >= paramInt))
        {
          paramInt = Math.min(i2 + i3 + 1, this.p.length());
          this.p.setSpan(paramArrayOfClickableSpan[0], i1, paramInt, 33);
        }
      }
    }
  }
  
  private void a(CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan)
  {
    int i1 = this.p.length();
    this.p.append(paramCharSequence).append('\n');
    a((Spanned)paramCharSequence, paramArrayOfClickableSpan, i1);
  }
  
  private void a(CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan, int paramInt)
  {
    a(paramCharSequence, paramArrayOfClickableSpan, paramInt, true);
  }
  
  private void a(CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan, int paramInt, boolean paramBoolean)
  {
    if ((paramCharSequence instanceof Spanned)) {
      a((Spanned)paramCharSequence, paramArrayOfClickableSpan, paramInt);
    }
    if (paramBoolean) {
      setSpan(this.p);
    }
    super.setText(this.p, this.h);
  }
  
  private boolean a(CharSequence paramCharSequence)
  {
    return paramCharSequence.charAt(paramCharSequence.length() - 1) == '…';
  }
  
  @org.jetbrains.annotations.Nullable
  private ClickableSpan[] a(int paramInt, CharSequence paramCharSequence)
  {
    if (((paramCharSequence instanceof Spanned)) && (paramInt > 1)) {
      return (ClickableSpan[])((Spanned)paramCharSequence).getSpans(0, paramCharSequence.length(), ClickableSpan.class);
    }
    return null;
  }
  
  private void b()
  {
    setMovementMethod(ReadInJoyYAFolderTextView.ClickableMovementMethod.a());
  }
  
  private boolean c()
  {
    int i1 = this.g;
    if ((i1 > 0) && (this.j))
    {
      int i2 = this.m;
      if ((i2 < 0) || (i2 > i1)) {
        return true;
      }
    }
    return false;
  }
  
  @NotNull
  private ArrayList<CharSequence> getParagraphs()
  {
    ArrayList localArrayList = new ArrayList();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < this.d.length(); i2 = i3)
    {
      i3 = i2;
      if (this.d.charAt(i1) == '\n')
      {
        localArrayList.add(this.d.subSequence(i2, i1));
        i3 = i1 + 1;
      }
      i1 += 1;
    }
    if (i2 != this.d.length())
    {
      CharSequence localCharSequence = this.d;
      localArrayList.add(localCharSequence.subSequence(i2, localCharSequence.length()));
    }
    return localArrayList;
  }
  
  private void setSpan(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.e);
    paramSpannableStringBuilder.append(this.f);
    Object localObject = this.i;
    if (localObject != null) {
      paramSpannableStringBuilder.setSpan(localObject, paramSpannableStringBuilder.length() - this.f.length(), paramSpannableStringBuilder.length(), 33);
    }
  }
  
  public static void setUgcFolderTextView(UGCFeedsInfo paramUGCFeedsInfo, ReadInJoyYAFolderTextView paramReadInJoyYAFolderTextView, CmpCtxt paramCmpCtxt, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder == null) {
      paramSpannableStringBuilder = new SpannableStringBuilder();
    }
    if (RIJFeedsType.a(paramUGCFeedsInfo))
    {
      List localList = paramUGCFeedsInfo.h.a;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = new ArrayList();
      int i1 = localList.size();
      Object localObject1 = ((BiuCommentInfo)localList.get(i1 - 1)).mBiuComment;
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && ((((String)localObject1).startsWith(":")) || (((String)localObject1).startsWith("："))))
      {
        paramUGCFeedsInfo = ((String)localObject1).substring(1);
      }
      else
      {
        paramUGCFeedsInfo = (UGCFeedsInfo)localObject1;
        if (localObject1 == null) {
          paramUGCFeedsInfo = "";
        }
      }
      localStringBuilder.append(paramUGCFeedsInfo);
      int i2 = localStringBuilder.length();
      i1 -= 2;
      while (i1 >= 0)
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i1);
        long l1 = localBiuCommentInfo.mUin.longValue();
        paramUGCFeedsInfo = ContactUtils.a(RIJQQAppInterfaceUtil.e(), String.valueOf(l1), true);
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("@");
        ((StringBuilder)localObject1).append(paramUGCFeedsInfo);
        localObject1 = ((StringBuilder)localObject1).toString();
        paramUGCFeedsInfo = (UGCFeedsInfo)localObject1;
        if (localBiuCommentInfo.mOpType == 1)
        {
          paramUGCFeedsInfo = new StringBuilder();
          paramUGCFeedsInfo.append((String)localObject1);
          paramUGCFeedsInfo.append(" ");
          paramUGCFeedsInfo = paramUGCFeedsInfo.toString();
        }
        if (localBiuCommentInfo.mBiuComment == null) {
          localObject1 = "";
        } else {
          localObject1 = localBiuCommentInfo.mBiuComment;
        }
        localStringBuilder.append(paramUGCFeedsInfo);
        localStringBuilder.append((String)localObject1);
        localObject1 = new ComponentHeaderNewSocial.BiuUserStruct();
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).a = i2;
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).b = (i2 + paramUGCFeedsInfo.length());
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).c = l1;
        ((List)localObject2).add(localObject1);
        i2 = localStringBuilder.length();
        i1 -= 1;
      }
      paramUGCFeedsInfo = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject1).next();
        paramUGCFeedsInfo.setSpan(new CommonBasicComponent.UserSpan(((ComponentHeaderNewSocial.BiuUserStruct)localObject2).c, -3355444, paramCmpCtxt), ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).a, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).b, 17);
      }
      paramSpannableStringBuilder.append(paramUGCFeedsInfo);
    }
    else if (!TextUtils.isEmpty(paramUGCFeedsInfo.f))
    {
      try
      {
        paramSpannableStringBuilder.append(new QQText(EmotionCodecUtils.c(paramUGCFeedsInfo.f), 7, 16));
      }
      catch (Exception paramUGCFeedsInfo)
      {
        QLog.d("ReadInJoyYAFolderTextView", 1, "parse bytes_comments failed ", paramUGCFeedsInfo);
      }
    }
    paramReadInJoyYAFolderTextView.setText(paramSpannableStringBuilder);
  }
  
  public int a(AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return 7;
    }
    long l1 = paramAbsBaseArticleInfo.mChannelID;
    if (paramAbsBaseArticleInfo.isPGCShortContent())
    {
      if ((l1 != 0L) && (!DailyModeConfigHandler.c((int)l1))) {
        return Aladdin.getConfig(168).getIntegerFromString("channel_textlines", 7);
      }
      AladdinConfig localAladdinConfig = Aladdin.getConfig(168);
      int i1 = localAladdinConfig.getIntegerFromString("main_channel_textlines", 3);
      int i2 = paramAbsBaseArticleInfo.mResolvedFeedType;
      switch (i2)
      {
      default: 
        switch (i2)
        {
        default: 
          return i1;
        case 134: 
          return 2147483647;
        }
      case 111: 
        return localAladdinConfig.getIntegerFromString("main_channel_multiple_image_textlines", i1);
      case 110: 
        return localAladdinConfig.getIntegerFromString("main_channel_single_image_textlines", i1);
      }
      return localAladdinConfig.getIntegerFromString("main_channel_pure_textlines", i1);
    }
    if (l1 == 0L) {
      return 3;
    }
    return 7;
  }
  
  public void a()
  {
    if (this.s.size() > 0)
    {
      Iterator localIterator = this.s.iterator();
      if (localIterator.hasNext())
      {
        ClickableSpan localClickableSpan = (ClickableSpan)localIterator.next();
        if ((localClickableSpan instanceof ClickableSpanPressed)) {
          ((ClickableSpanPressed)localClickableSpan).a(false);
        }
        localIterator.remove();
      }
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (!c()) {
      return;
    }
    this.j = false;
    this.p.clear();
    TextPaint localTextPaint = getPaint();
    this.p = new SpannableStringBuilder();
    float f1 = a(localTextPaint, this.p);
    this.p.clear();
    ArrayList localArrayList = getParagraphs();
    float f2 = paramInt3 - paramInt1;
    paramInt4 = 0;
    paramInt2 = 0;
    int i1 = 0;
    while ((i1 < this.g - 1) && (paramInt4 < localArrayList.size()))
    {
      int i2 = i1 + 1;
      CharSequence localCharSequence1 = a(localArrayList, paramInt4, paramInt2);
      CharSequence localCharSequence2 = a(paramInt1, paramInt3, localTextPaint, TextUtils.ellipsize(localCharSequence1, localTextPaint, f2, TextUtils.TruncateAt.END));
      ClickableSpan[] arrayOfClickableSpan = a(i2, localCharSequence2);
      if (localCharSequence2.equals(localCharSequence1))
      {
        a(localCharSequence2, arrayOfClickableSpan);
        paramInt4 += 1;
        paramInt2 = 0;
        i1 = i2;
      }
      else
      {
        i1 = i2;
        if (localCharSequence2.length() > 0)
        {
          paramInt2 = a(paramInt2, localCharSequence2, arrayOfClickableSpan);
          i1 = i2;
        }
      }
    }
    a(paramInt1, paramInt3, localTextPaint, f1, localArrayList, paramInt4, paramInt2, i1);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.g > 0)
    {
      Object localObject = getLayout();
      if ((localObject instanceof DynamicLayout))
      {
        localObject = (DynamicLayout)localObject;
        a((DynamicLayout)localObject);
        this.m = ((DynamicLayout)localObject).getLineCount();
        paramInt1 = getCompoundPaddingTop();
        paramInt2 = getCompoundPaddingBottom();
        paramInt2 = this.g * getLineHeight() + (paramInt1 + paramInt2);
        paramInt1 = paramInt2;
        if (Build.VERSION.SDK_INT >= 16) {
          paramInt1 = (int)(paramInt2 - getLineSpacingExtra());
        }
        if ((this.m >= this.g) && (paramInt1 > 0)) {
          setMeasuredDimension(getMeasuredWidth(), paramInt1);
        }
        if (this.b) {
          a((DynamicLayout)localObject, this.m);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = super.onTouchEvent(paramMotionEvent);
    int i1;
    do
    {
      try
      {
        i1 = paramMotionEvent.getActionMasked();
        int i2 = (int)paramMotionEvent.getX();
        int i3 = (int)paramMotionEvent.getY();
        int i4 = getTotalPaddingLeft();
        int i5 = getTotalPaddingTop();
        int i6 = getScrollX();
        int i7 = getScrollY();
        paramMotionEvent = getLayout();
        i2 = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(i3 - i5 + i7), i2 - i4 + i6);
        paramMotionEvent = getText();
        if (!TextUtils.isEmpty(paramMotionEvent))
        {
          if (!(paramMotionEvent instanceof Spannable)) {
            return bool1;
          }
          paramMotionEvent = (Spannable)getText();
          ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(i2, i2, ClickableSpan.class);
          if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length != 0))
          {
            if (i1 == 0)
            {
              a();
              this.i = arrayOfClickableSpan[0];
              this.q = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
              this.r = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
              if ((this.q < 0) || (this.r < this.q) || (!(arrayOfClickableSpan[0] instanceof ClickableSpanPressed))) {
                break;
              }
              ((ClickableSpanPressed)arrayOfClickableSpan[0]).a(true);
              this.s.add(arrayOfClickableSpan[0]);
              return true;
              this.i = null;
              if ((this.q >= 0) && (this.r >= this.q))
              {
                if ((arrayOfClickableSpan[0] instanceof ClickableSpanPressed)) {
                  ((ClickableSpanPressed)arrayOfClickableSpan[0]).a(false);
                }
                Selection.removeSelection(paramMotionEvent);
                this.q = -1;
                this.r = -1;
              }
              a();
              return true;
            }
          }
          else
          {
            if ((this.q >= 0) && (this.r >= this.q))
            {
              if ((this.i != null) && ((this.i instanceof ClickableSpanPressed)))
              {
                ((ClickableSpanPressed)this.i).a(false);
                this.i = null;
              }
              Selection.removeSelection(paramMotionEvent);
              this.q = -1;
              this.r = -1;
            }
            a();
            boolean bool2 = this.n;
            return (bool2) && (bool1);
          }
        }
        else
        {
          return bool1;
        }
      }
      catch (Exception paramMotionEvent)
      {
        if (QLog.isDevelopLevel()) {
          paramMotionEvent.printStackTrace();
        }
        return bool1;
      }
    } while ((i1 == 1) || (i1 == 3) || (i1 == 4));
    return true;
  }
  
  public void setCustomViewLinkTextColor(int paramInt)
  {
    Object localObject = this.a;
    if (localObject != null)
    {
      ((ArticleViewModel)localObject).a(paramInt);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setCustomViewLinkTextColor | link color ");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("ReadInJoyYAFolderTextView", 1, ((StringBuilder)localObject).toString());
    }
  }
  
  public void setEllipsis(String paramString)
  {
    this.e = paramString;
  }
  
  public void setLinkedTextColor(int paramInt)
  {
    this.c = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.g = paramInt;
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.k() != null)) {
      this.a = paramIReadInJoyModel.k().articleViewModel;
    }
  }
  
  public void setMoreSpan(Object paramObject)
  {
    this.i = paramObject;
  }
  
  public void setShouldCallClick(boolean paramBoolean)
  {
    this.n = paramBoolean;
  }
  
  public void setSpanText(String paramString)
  {
    this.f = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if ((paramCharSequence instanceof QQText)) {
      localObject = new SpannableStringBuilder(paramCharSequence);
    }
    super.setText((CharSequence)localObject, paramBufferType);
    this.m = -1;
    this.j = true;
    this.d = ((CharSequence)localObject);
    this.h = paramBufferType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView
 * JD-Core Version:    0.7.0.1
 */