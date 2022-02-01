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
  private static final char[] jdField_a_of_type_ArrayOfChar = { '…' };
  private static final String jdField_c_of_type_JavaLangString = new String(jdField_a_of_type_ArrayOfChar);
  protected int a;
  private SpannableStringBuilder jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
  @android.support.annotation.Nullable
  private Pair<Integer, Reflect> jdField_a_of_type_AndroidUtilPair;
  private TextView.BufferType jdField_a_of_type_AndroidWidgetTextView$BufferType;
  protected ArticleViewModel a;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  private Object jdField_a_of_type_JavaLangObject;
  private String jdField_a_of_type_JavaLangString = "...";
  private Vector<ClickableSpan> jdField_a_of_type_JavaUtilVector = new Vector();
  public boolean a;
  private int jdField_b_of_type_Int = 5;
  private String jdField_b_of_type_JavaLangString = HardCodeUtil.a(2131712990);
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private boolean jdField_c_of_type_Boolean = false;
  private int d = -1;
  private int e = -1;
  
  public ReadInJoyYAFolderTextView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -15504151;
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @android.support.annotation.Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -15504151;
    b();
  }
  
  public ReadInJoyYAFolderTextView(Context paramContext, @android.support.annotation.Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = -15504151;
    b();
  }
  
  private float a(TextPaint paramTextPaint, SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.jdField_a_of_type_JavaLangString).append(this.jdField_b_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (localObject != null) {
      paramSpannableStringBuilder.setSpan(localObject, paramSpannableStringBuilder.length() - this.jdField_b_of_type_JavaLangString.length(), paramSpannableStringBuilder.length(), 33);
    }
    return paramTextPaint.measureText(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.length());
  }
  
  private int a(int paramInt, CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan)
  {
    int j = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
    int i;
    if (a(paramCharSequence))
    {
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramCharSequence.subSequence(0, paramCharSequence.length() - 1)).append('\n');
      i = paramCharSequence.length() - 1;
    }
    else
    {
      this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramCharSequence.subSequence(0, paramCharSequence.length() - 3)).append('\n');
      i = paramCharSequence.length() - 3;
    }
    a((Spanned)paramCharSequence, paramArrayOfClickableSpan, j);
    return paramInt + i;
  }
  
  private SpannableStringBuilder a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Object localObject = (EmoticonSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), EmoticonSpan.class);
    int i = paramSpannableStringBuilder.length();
    if ((localObject != null) && (localObject.length > 0))
    {
      localObject = localObject[(localObject.length - 1)];
      if (paramSpannableStringBuilder.getSpanEnd(localObject) == i) {
        return new SpannableStringBuilder(paramSpannableStringBuilder, 0, paramSpannableStringBuilder.getSpanStart(localObject));
      }
    }
    return new SpannableStringBuilder(paramSpannableStringBuilder, 0, i - 1);
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
          return a((SpannableStringBuilder)localObject).append(jdField_c_of_type_JavaLangString);
        }
        localObject = paramCharSequence;
        if (paramTextPaint.measureText(localCharSequence.toString()) > paramInt2 - paramInt1) {
          localObject = a((SpannableStringBuilder)localCharSequence).append(jdField_c_of_type_JavaLangString);
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
  
  @NotNull
  private ArrayList<CharSequence> a()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    int k;
    for (int j = 0; i < this.jdField_a_of_type_JavaLangCharSequence.length(); j = k)
    {
      k = j;
      if (this.jdField_a_of_type_JavaLangCharSequence.charAt(i) == '\n')
      {
        localArrayList.add(this.jdField_a_of_type_JavaLangCharSequence.subSequence(j, i));
        k = i + 1;
      }
      i += 1;
    }
    if (j != this.jdField_a_of_type_JavaLangCharSequence.length())
    {
      CharSequence localCharSequence = this.jdField_a_of_type_JavaLangCharSequence;
      localArrayList.add(localCharSequence.subSequence(j, localCharSequence.length()));
    }
    return localArrayList;
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
        paramInt1 = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
        if (a(paramTextPaint)) {
          this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint.subSequence(0, paramTextPaint.length() - 1));
        } else {
          this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint.subSequence(0, paramTextPaint.length() - 3));
        }
        a(paramTextPaint, arrayOfClickableSpan, paramInt1);
        return;
      }
      if (paramInt3 != paramArrayList.size() - 1)
      {
        paramInt1 = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint);
        a(paramTextPaint, arrayOfClickableSpan, paramInt1);
        return;
      }
      if (this.jdField_c_of_type_Int > this.jdField_b_of_type_Int)
      {
        paramInt1 = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
        this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramTextPaint);
        a(paramTextPaint, arrayOfClickableSpan, paramInt1, false);
      }
    }
  }
  
  private void a(DynamicLayout paramDynamicLayout)
  {
    if (Build.VERSION.SDK_INT == 26) {
      try
      {
        int i = paramDynamicLayout.hashCode();
        if ((this.jdField_a_of_type_AndroidUtilPair != null) && (this.jdField_a_of_type_AndroidUtilPair.first != null) && (this.jdField_a_of_type_AndroidUtilPair.second != null) && (((Integer)this.jdField_a_of_type_AndroidUtilPair.first).intValue() == i))
        {
          paramDynamicLayout = (Reflect)this.jdField_a_of_type_AndroidUtilPair.second;
        }
        else
        {
          paramDynamicLayout = Reflect.on(paramDynamicLayout);
          this.jdField_a_of_type_AndroidUtilPair = new Pair(Integer.valueOf(i), paramDynamicLayout);
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
    int i = paramInt - 1;
    paramInt = paramDynamicLayout.getLineStart(i);
    i = paramDynamicLayout.getLineEnd(i);
    paramDynamicLayout = paramDynamicLayout.getText();
    String str1 = paramDynamicLayout.subSequence(paramInt, i).toString();
    String str2 = HardCodeUtil.a(2131712687);
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
  
  private void a(SpannableStringBuilder paramSpannableStringBuilder)
  {
    paramSpannableStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    paramSpannableStringBuilder.append(this.jdField_b_of_type_JavaLangString);
    Object localObject = this.jdField_a_of_type_JavaLangObject;
    if (localObject != null) {
      paramSpannableStringBuilder.setSpan(localObject, paramSpannableStringBuilder.length() - this.jdField_b_of_type_JavaLangString.length(), paramSpannableStringBuilder.length(), 33);
    }
  }
  
  private void a(Spanned paramSpanned, ClickableSpan[] paramArrayOfClickableSpan, int paramInt)
  {
    if ((paramArrayOfClickableSpan != null) && (paramArrayOfClickableSpan.length > 0))
    {
      int i = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.getSpanStart(paramArrayOfClickableSpan[0]);
      int j = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.getSpanEnd(paramArrayOfClickableSpan[0]);
      if ((i >= 0) && (j >= i) && (j < paramInt))
      {
        paramInt = paramSpanned.getSpanStart(paramArrayOfClickableSpan[0]);
        int k = paramSpanned.getSpanEnd(paramArrayOfClickableSpan[0]);
        if ((paramInt == 0) && (k >= paramInt))
        {
          paramInt = Math.min(j + k + 1, this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length());
          this.jdField_a_of_type_AndroidTextSpannableStringBuilder.setSpan(paramArrayOfClickableSpan[0], i, paramInt, 33);
        }
      }
    }
  }
  
  private void a(CharSequence paramCharSequence, ClickableSpan[] paramArrayOfClickableSpan)
  {
    int i = this.jdField_a_of_type_AndroidTextSpannableStringBuilder.length();
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.append(paramCharSequence).append('\n');
    a((Spanned)paramCharSequence, paramArrayOfClickableSpan, i);
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
      a(this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    }
    super.setText(this.jdField_a_of_type_AndroidTextSpannableStringBuilder, this.jdField_a_of_type_AndroidWidgetTextView$BufferType);
  }
  
  private boolean a()
  {
    int i = this.jdField_b_of_type_Int;
    if ((i > 0) && (this.jdField_b_of_type_Boolean))
    {
      int j = this.jdField_c_of_type_Int;
      if ((j < 0) || (j > i)) {
        return true;
      }
    }
    return false;
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
  
  public static void setUgcFolderTextView(UGCFeedsInfo paramUGCFeedsInfo, ReadInJoyYAFolderTextView paramReadInJoyYAFolderTextView, CmpCtxt paramCmpCtxt, SpannableStringBuilder paramSpannableStringBuilder)
  {
    if (paramSpannableStringBuilder == null) {
      paramSpannableStringBuilder = new SpannableStringBuilder();
    }
    if (RIJFeedsType.a(paramUGCFeedsInfo))
    {
      List localList = paramUGCFeedsInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoHandlerBiuInfo.a;
      StringBuilder localStringBuilder = new StringBuilder();
      Object localObject2 = new ArrayList();
      int i = localList.size();
      Object localObject1 = ((BiuCommentInfo)localList.get(i - 1)).mBiuComment;
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
      int j = localStringBuilder.length();
      i -= 2;
      while (i >= 0)
      {
        BiuCommentInfo localBiuCommentInfo = (BiuCommentInfo)localList.get(i);
        long l = localBiuCommentInfo.mUin.longValue();
        paramUGCFeedsInfo = ContactUtils.a(RIJQQAppInterfaceUtil.a(), String.valueOf(l), true);
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
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).jdField_a_of_type_Int = j;
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).jdField_b_of_type_Int = (j + paramUGCFeedsInfo.length());
        ((ComponentHeaderNewSocial.BiuUserStruct)localObject1).jdField_a_of_type_Long = l;
        ((List)localObject2).add(localObject1);
        j = localStringBuilder.length();
        i -= 1;
      }
      paramUGCFeedsInfo = new SpannableStringBuilder(new QQText(localStringBuilder, 7, 16));
      localObject1 = ((List)localObject2).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ComponentHeaderNewSocial.BiuUserStruct)((Iterator)localObject1).next();
        paramUGCFeedsInfo.setSpan(new CommonBasicComponent.UserSpan(((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Long, -3355444, paramCmpCtxt), ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_a_of_type_Int, ((ComponentHeaderNewSocial.BiuUserStruct)localObject2).jdField_b_of_type_Int, 17);
      }
      paramSpannableStringBuilder.append(paramUGCFeedsInfo);
    }
    else if (!TextUtils.isEmpty(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString))
    {
      try
      {
        paramSpannableStringBuilder.append(new QQText(EmotionCodecUtils.b(paramUGCFeedsInfo.jdField_a_of_type_JavaLangString), 7, 16));
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
    long l = paramAbsBaseArticleInfo.mChannelID;
    if (paramAbsBaseArticleInfo.isPGCShortContent())
    {
      if ((l != 0L) && (!DailyModeConfigHandler.c((int)l))) {
        return Aladdin.getConfig(168).getIntegerFromString("channel_textlines", 7);
      }
      AladdinConfig localAladdinConfig = Aladdin.getConfig(168);
      int i = localAladdinConfig.getIntegerFromString("main_channel_textlines", 3);
      int j = paramAbsBaseArticleInfo.mResolvedFeedType;
      switch (j)
      {
      default: 
        switch (j)
        {
        default: 
          return i;
        case 134: 
          return 2147483647;
        }
      case 111: 
        return localAladdinConfig.getIntegerFromString("main_channel_multiple_image_textlines", i);
      case 110: 
        return localAladdinConfig.getIntegerFromString("main_channel_single_image_textlines", i);
      }
      return localAladdinConfig.getIntegerFromString("main_channel_pure_textlines", i);
    }
    if (l == 0L) {
      return 3;
    }
    return 7;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_JavaUtilVector.size() > 0)
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilVector.iterator();
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
    if (!a()) {
      return;
    }
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
    TextPaint localTextPaint = getPaint();
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder = new SpannableStringBuilder();
    float f1 = a(localTextPaint, this.jdField_a_of_type_AndroidTextSpannableStringBuilder);
    this.jdField_a_of_type_AndroidTextSpannableStringBuilder.clear();
    ArrayList localArrayList = a();
    float f2 = paramInt3 - paramInt1;
    paramInt4 = 0;
    paramInt2 = 0;
    int i = 0;
    while ((i < this.jdField_b_of_type_Int - 1) && (paramInt4 < localArrayList.size()))
    {
      int j = i + 1;
      CharSequence localCharSequence1 = a(localArrayList, paramInt4, paramInt2);
      CharSequence localCharSequence2 = a(paramInt1, paramInt3, localTextPaint, TextUtils.ellipsize(localCharSequence1, localTextPaint, f2, TextUtils.TruncateAt.END));
      ClickableSpan[] arrayOfClickableSpan = a(j, localCharSequence2);
      if (localCharSequence2.equals(localCharSequence1))
      {
        a(localCharSequence2, arrayOfClickableSpan);
        paramInt4 += 1;
        paramInt2 = 0;
        i = j;
      }
      else
      {
        i = j;
        if (localCharSequence2.length() > 0)
        {
          paramInt2 = a(paramInt2, localCharSequence2, arrayOfClickableSpan);
          i = j;
        }
      }
    }
    a(paramInt1, paramInt3, localTextPaint, f1, localArrayList, paramInt4, paramInt2, i);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.jdField_b_of_type_Int > 0)
    {
      Object localObject = getLayout();
      if ((localObject instanceof DynamicLayout))
      {
        localObject = (DynamicLayout)localObject;
        a((DynamicLayout)localObject);
        this.jdField_c_of_type_Int = ((DynamicLayout)localObject).getLineCount();
        paramInt1 = getCompoundPaddingTop();
        paramInt2 = getCompoundPaddingBottom();
        paramInt2 = this.jdField_b_of_type_Int * getLineHeight() + (paramInt1 + paramInt2);
        paramInt1 = paramInt2;
        if (Build.VERSION.SDK_INT >= 16) {
          paramInt1 = (int)(paramInt2 - getLineSpacingExtra());
        }
        if ((this.jdField_c_of_type_Int >= this.jdField_b_of_type_Int) && (paramInt1 > 0)) {
          setMeasuredDimension(getMeasuredWidth(), paramInt1);
        }
        if (this.jdField_a_of_type_Boolean) {
          a((DynamicLayout)localObject, this.jdField_c_of_type_Int);
        }
      }
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1 = super.onTouchEvent(paramMotionEvent);
    int i;
    do
    {
      try
      {
        i = paramMotionEvent.getActionMasked();
        int j = (int)paramMotionEvent.getX();
        int k = (int)paramMotionEvent.getY();
        int m = getTotalPaddingLeft();
        int n = getTotalPaddingTop();
        int i1 = getScrollX();
        int i2 = getScrollY();
        paramMotionEvent = getLayout();
        j = paramMotionEvent.getOffsetForHorizontal(paramMotionEvent.getLineForVertical(k - n + i2), j - m + i1);
        paramMotionEvent = getText();
        if (!TextUtils.isEmpty(paramMotionEvent))
        {
          if (!(paramMotionEvent instanceof Spannable)) {
            return bool1;
          }
          paramMotionEvent = (Spannable)getText();
          ClickableSpan[] arrayOfClickableSpan = (ClickableSpan[])paramMotionEvent.getSpans(j, j, ClickableSpan.class);
          if ((arrayOfClickableSpan != null) && (arrayOfClickableSpan.length != 0))
          {
            if (i == 0)
            {
              a();
              this.jdField_a_of_type_JavaLangObject = arrayOfClickableSpan[0];
              this.d = paramMotionEvent.getSpanStart(arrayOfClickableSpan[0]);
              this.e = paramMotionEvent.getSpanEnd(arrayOfClickableSpan[0]);
              if ((this.d < 0) || (this.e < this.d) || (!(arrayOfClickableSpan[0] instanceof ClickableSpanPressed))) {
                break;
              }
              ((ClickableSpanPressed)arrayOfClickableSpan[0]).a(true);
              this.jdField_a_of_type_JavaUtilVector.add(arrayOfClickableSpan[0]);
              return true;
              this.jdField_a_of_type_JavaLangObject = null;
              if ((this.d >= 0) && (this.e >= this.d))
              {
                if ((arrayOfClickableSpan[0] instanceof ClickableSpanPressed)) {
                  ((ClickableSpanPressed)arrayOfClickableSpan[0]).a(false);
                }
                Selection.removeSelection(paramMotionEvent);
                this.d = -1;
                this.e = -1;
              }
              a();
              return true;
            }
          }
          else
          {
            if ((this.d >= 0) && (this.e >= this.d))
            {
              if ((this.jdField_a_of_type_JavaLangObject != null) && ((this.jdField_a_of_type_JavaLangObject instanceof ClickableSpanPressed)))
              {
                ((ClickableSpanPressed)this.jdField_a_of_type_JavaLangObject).a(false);
                this.jdField_a_of_type_JavaLangObject = null;
              }
              Selection.removeSelection(paramMotionEvent);
              this.d = -1;
              this.e = -1;
            }
            a();
            boolean bool2 = this.jdField_c_of_type_Boolean;
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
    } while ((i == 1) || (i == 3) || (i == 4));
    return true;
  }
  
  public void setCustomViewLinkTextColor(int paramInt)
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityArticleViewModel;
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
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void setLinkedTextColor(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public void setMaxLines(int paramInt)
  {
    super.setMaxLines(paramInt);
    this.jdField_b_of_type_Int = paramInt;
  }
  
  public void setModel(IReadInJoyModel paramIReadInJoyModel)
  {
    if ((paramIReadInJoyModel != null) && (paramIReadInJoyModel.a() != null)) {
      this.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityArticleViewModel = paramIReadInJoyModel.a().articleViewModel;
    }
  }
  
  public void setMoreSpan(Object paramObject)
  {
    this.jdField_a_of_type_JavaLangObject = paramObject;
  }
  
  public void setShouldCallClick(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setSpanText(String paramString)
  {
    this.jdField_b_of_type_JavaLangString = paramString;
  }
  
  public void setText(CharSequence paramCharSequence, TextView.BufferType paramBufferType)
  {
    Object localObject = paramCharSequence;
    if ((paramCharSequence instanceof QQText)) {
      localObject = new SpannableStringBuilder(paramCharSequence);
    }
    super.setText((CharSequence)localObject, paramBufferType);
    this.jdField_c_of_type_Int = -1;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_JavaLangCharSequence = ((CharSequence)localObject);
    this.jdField_a_of_type_AndroidWidgetTextView$BufferType = paramBufferType;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.widget.ReadInJoyYAFolderTextView
 * JD-Core Version:    0.7.0.1
 */