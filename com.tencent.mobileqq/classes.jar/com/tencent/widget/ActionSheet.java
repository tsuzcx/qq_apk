package com.tencent.widget;

import amag;
import amah;
import amai;
import amak;
import amal;
import android.annotation.TargetApi;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableStringBuilder;
import android.util.Pair;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.util.AccessibilityUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class ActionSheet
  extends Dialog
{
  private int jdField_a_of_type_Int = -1;
  private Context jdField_a_of_type_AndroidContentContext;
  private Resources jdField_a_of_type_AndroidContentResResources;
  private Handler jdField_a_of_type_AndroidOsHandler;
  private SparseArray jdField_a_of_type_AndroidUtilSparseArray;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  public LinearLayout a;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout;
  private ActionSheet.OnButtonClickListener jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener;
  private ActionSheet.OnDismissListener jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener;
  private ActionSheet.WatchDismissActions jdField_a_of_type_ComTencentWidgetActionSheet$WatchDismissActions;
  private ActionSheet.onPreShowListener jdField_a_of_type_ComTencentWidgetActionSheet$onPreShowListener;
  private CharSequence jdField_a_of_type_JavaLangCharSequence;
  public Object a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  private HashMap jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private HashSet jdField_a_of_type_JavaUtilHashSet;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = 300;
  private View.OnClickListener jdField_b_of_type_AndroidViewView$OnClickListener = new amak(this);
  private CharSequence jdField_b_of_type_JavaLangCharSequence;
  private HashMap jdField_b_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private View.OnClickListener jdField_c_of_type_AndroidViewView$OnClickListener = new amal(this);
  private CharSequence jdField_c_of_type_JavaLangCharSequence;
  private HashMap jdField_c_of_type_JavaUtilHashMap = new HashMap();
  public boolean c;
  private HashMap jdField_d_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_d_of_type_Boolean = true;
  private HashMap jdField_e_of_type_JavaUtilHashMap = new HashMap();
  private boolean jdField_e_of_type_Boolean;
  private boolean f = true;
  private boolean g;
  
  public ActionSheet(Context paramContext)
  {
    this(paramContext, false, false);
  }
  
  public ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramContext, paramBoolean1, paramBoolean2, true);
  }
  
  @TargetApi(14)
  protected ActionSheet(Context paramContext, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    super(paramContext, 2131624574);
    if (Build.VERSION.SDK_INT >= 14) {
      getWindow().setDimAmount(0.5F);
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_b_of_type_Boolean = paramBoolean1;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_AndroidContentResResources = paramContext.getResources();
    this.jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
    if ((paramBoolean3) && (ImmersiveUtils.isSupporImmersive() == 1)) {
      getWindow().addFlags(67108864);
    }
    if (paramBoolean2)
    {
      requestWindowFeature(1);
      getWindow().setFlags(1024, 1024);
    }
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968598, null));
    super.setContentView(this.jdField_a_of_type_AndroidViewViewGroup);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362807));
    this.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)this.jdField_a_of_type_AndroidViewViewGroup.findViewById(2131362808));
    this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(null);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = this.jdField_c_of_type_AndroidViewView$OnClickListener;
  }
  
  private int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    case 1: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    case 2: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    case 4: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    case 3: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493055);
    case 5: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    case 6: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    case 7: 
      return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493059);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getColor(2131493331);
  }
  
  public static ActionSheet a(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131624573);
    }
    return paramContext;
  }
  
  public static ActionSheet a(Context paramContext, boolean paramBoolean)
  {
    paramContext = new ActionSheet(paramContext, false, true, paramBoolean);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131624573);
    }
    return paramContext;
  }
  
  private void a(TextView paramTextView, boolean paramBoolean)
  {
    if (paramTextView == null) {
      return;
    }
    if (paramBoolean)
    {
      paramTextView.setContentDescription(getContext().getString(2131427458) + paramTextView.getText());
      return;
    }
    paramTextView.setContentDescription(getContext().getString(2131427459) + paramTextView.getText());
  }
  
  public static ActionSheet b(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, false, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131624573);
    }
    return paramContext;
  }
  
  public static ActionSheet c(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, false);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131624573);
    }
    return paramContext;
  }
  
  public static ActionSheet d(Context paramContext)
  {
    paramContext = new ActionSheet(paramContext, true, true);
    if (Build.VERSION.SDK_INT != 23) {
      paramContext.getWindow().setWindowAnimations(2131624573);
    }
    return paramContext;
  }
  
  private void e()
  {
    if (this.jdField_c_of_type_Boolean) {
      return;
    }
    Object localObject1;
    Object localObject2;
    if (this.jdField_a_of_type_JavaLangCharSequence != null)
    {
      localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968601, null);
      ((View)localObject1).setBackgroundDrawable(this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837532));
      ((View)localObject1).setOnClickListener(new amag(this));
      localObject2 = (TextView)((View)localObject1).findViewById(2131362815);
      ((TextView)localObject2).setVisibility(0);
      ((TextView)localObject2).setText(this.jdField_a_of_type_JavaLangCharSequence);
      ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_JavaLangCharSequence);
      if (this.jdField_b_of_type_JavaLangCharSequence != null)
      {
        localObject2 = (TextView)((View)localObject1).findViewById(2131362816);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_b_of_type_JavaLangCharSequence);
        ((TextView)localObject2).setContentDescription(this.jdField_b_of_type_JavaLangCharSequence);
      }
      this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1, 0);
    }
    for (int i = 1;; i = 0)
    {
      if (this.jdField_e_of_type_Boolean) {
        i = 1;
      }
      if (this.jdField_a_of_type_JavaUtilArrayList != null)
      {
        int j = i + this.jdField_a_of_type_JavaUtilArrayList.size();
        int k = this.jdField_a_of_type_JavaUtilArrayList.size();
        i = 0;
        if (i < k)
        {
          localObject2 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968600, null);
          TextView localTextView = (TextView)((View)localObject2).findViewById(2131362811);
          localObject1 = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(i);
          localTextView.setText((CharSequence)((Pair)localObject1).first);
          AccessibilityUtil.b(localTextView, Button.class.getName());
          if ((this.jdField_a_of_type_JavaUtilHashMap != null) && (this.jdField_a_of_type_JavaUtilHashMap.size() > 0))
          {
            localObject3 = (ActionMenuItem)this.jdField_a_of_type_JavaUtilHashMap.get(((Pair)localObject1).first);
            if ((localObject3 != null) && (((ActionMenuItem)localObject3).jdField_b_of_type_Int != 0)) {
              localTextView.setId(((ActionMenuItem)localObject3).jdField_b_of_type_Int);
            }
          }
          Object localObject3 = (ImageView)((View)localObject2).findViewById(2131362813);
          RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
          localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 15.0F);
          ((ImageView)localObject3).setLayoutParams(localLayoutParams);
          if (this.jdField_b_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i)))
          {
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageDrawable((Drawable)this.jdField_b_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
            label397:
            localObject3 = (ImageView)((View)localObject2).findViewById(2131362814);
            localLayoutParams = (RelativeLayout.LayoutParams)((ImageView)localObject3).getLayoutParams();
            if ((this.jdField_d_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) && (((Integer)this.jdField_d_of_type_JavaUtilHashMap.get(Integer.valueOf(i))).intValue() == 0))
            {
              localLayoutParams.width = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localLayoutParams.height = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 28.0F);
              localLayoutParams.addRule(15);
            }
            localLayoutParams.rightMargin = DisplayUtil.a(this.jdField_a_of_type_AndroidContentContext, 5.0F);
            ((ImageView)localObject3).setLayoutParams(localLayoutParams);
            if (!this.jdField_c_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
              break label741;
            }
            ((ImageView)localObject3).setVisibility(0);
            ((ImageView)localObject3).setImageDrawable((Drawable)this.jdField_c_of_type_JavaUtilHashMap.get(Integer.valueOf(i)));
            label552:
            if (((Integer)((Pair)localObject1).second).intValue() != 9) {
              break label757;
            }
            if (this.jdField_e_of_type_JavaUtilHashMap.containsKey(Integer.valueOf(i))) {
              localTextView.setTextColor(Color.parseColor((String)this.jdField_e_of_type_JavaUtilHashMap.get(Integer.valueOf(i))));
            }
            label604:
            if ((i != 0) || (j != k) || (j != 1)) {
              break label780;
            }
            localObject1 = a(0);
            label625:
            ((View)localObject2).setBackgroundDrawable((Drawable)localObject1);
            ((View)localObject2).setId(i);
            ((View)localObject2).setOnClickListener(this.jdField_b_of_type_AndroidViewView$OnClickListener);
            this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject2);
            if (this.jdField_a_of_type_Boolean)
            {
              if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
                this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
              }
              this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localObject2);
              if (i != this.jdField_a_of_type_Int) {
                break label836;
              }
              ((View)localObject2).findViewById(2131362812).setVisibility(0);
              a(localTextView, true);
            }
          }
          for (;;)
          {
            i += 1;
            break;
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label397;
            label741:
            ((ImageView)localObject3).setImageDrawable(null);
            ((ImageView)localObject3).setVisibility(8);
            break label552;
            label757:
            localTextView.setTextColor(a(((Integer)((Pair)localObject1).second).intValue()));
            break label604;
            label780:
            if ((i == 0) && (j == k) && (j > 1))
            {
              localObject1 = a(3);
              break label625;
            }
            if ((i == k - 1) && (j > 1))
            {
              localObject1 = a(0);
              break label625;
            }
            localObject1 = a(3);
            break label625;
            label836:
            a(localTextView, false);
          }
        }
      }
      if (this.jdField_c_of_type_JavaLangCharSequence != null)
      {
        localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130968599, null);
        localObject2 = (Button)((View)localObject1).findViewById(2131362809);
        ((Button)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        ((Button)localObject2).setText(this.jdField_c_of_type_JavaLangCharSequence);
        ((Button)localObject2).setContentDescription(this.jdField_c_of_type_JavaLangCharSequence);
        this.jdField_a_of_type_AndroidWidgetLinearLayout.addView((View)localObject1);
      }
      this.jdField_c_of_type_Boolean = true;
      return;
    }
  }
  
  public Drawable a(int paramInt)
  {
    switch (paramInt)
    {
    case 1: 
    case 2: 
    default: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837531);
    case 0: 
      return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837528);
    }
    return this.jdField_a_of_type_AndroidContentResResources.getDrawable(2130837531);
  }
  
  public RelativeLayout a()
  {
    return this.jdField_a_of_type_AndroidWidgetRelativeLayout;
  }
  
  public ActionMenuItem a(int paramInt)
  {
    return a(a(paramInt));
  }
  
  public ActionMenuItem a(CharSequence paramCharSequence)
  {
    if (this.jdField_a_of_type_JavaUtilHashMap == null) {
      return null;
    }
    return (ActionMenuItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramCharSequence);
  }
  
  public String a(int paramInt)
  {
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Pair localPair = (Pair)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
      if (localPair != null) {
        return ((CharSequence)localPair.first).toString();
      }
    }
    return null;
  }
  
  public void a()
  {
    this.jdField_c_of_type_Boolean = false;
    if (Build.VERSION.SDK_INT >= 11)
    {
      invalidateOptionsMenu();
      return;
    }
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.invalidate();
  }
  
  public void a(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2);
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt1), paramInt2, paramBoolean);
  }
  
  public void a(int paramInt, CharSequence paramCharSequence)
  {
    a(paramInt, paramCharSequence, 0);
  }
  
  public void a(int paramInt1, CharSequence paramCharSequence, int paramInt2)
  {
    if ((paramInt1 >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt1 < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      Object localObject = this.jdField_a_of_type_AndroidWidgetLinearLayout.findViewById(paramInt1);
      if (localObject != null)
      {
        localObject = ((View)localObject).findViewById(2131362811);
        if ((localObject != null) && (TextView.class.isInstance(localObject)))
        {
          localObject = (TextView)localObject;
          ((TextView)localObject).setText(paramCharSequence);
          ((TextView)localObject).setTextColor(a(paramInt2));
          paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt2));
          this.jdField_a_of_type_JavaUtilArrayList.set(paramInt1, paramCharSequence);
        }
      }
    }
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    a(paramInt, 0, paramBoolean);
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
  }
  
  public void a(View paramView)
  {
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  public void a(View paramView, LinearLayout.LayoutParams paramLayoutParams)
  {
    if (paramView != null)
    {
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      LinearLayout.LayoutParams localLayoutParams = paramLayoutParams;
      if (paramLayoutParams == null) {
        localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      }
      this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(paramView, localLayoutParams);
    }
  }
  
  public void a(ActionMenuItem paramActionMenuItem, int paramInt)
  {
    if (paramActionMenuItem == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilHashMap.put(paramActionMenuItem.a, paramActionMenuItem);
    a(paramActionMenuItem.a, paramInt);
  }
  
  public void a(ActionSheet.OnButtonClickListener paramOnButtonClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnButtonClickListener = paramOnButtonClickListener;
  }
  
  public void a(ActionSheet.OnDismissListener paramOnDismissListener)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$OnDismissListener = paramOnDismissListener;
  }
  
  public void a(ActionSheet.WatchDismissActions paramWatchDismissActions)
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet$WatchDismissActions = paramWatchDismissActions;
  }
  
  public void a(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_a_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt)
  {
    if (paramCharSequence != null)
    {
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (this.jdField_a_of_type_Boolean) {
        throw new UnsupportedOperationException("ActionSheet is in radio group mode,shouldn't call addButton!");
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean)
  {
    a(paramCharSequence, paramInt, paramBoolean, true);
  }
  
  public void a(CharSequence paramCharSequence, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramCharSequence != null)
    {
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0)) {
        throw new UnsupportedOperationException("ActionSheet is in normal button mode,shouldn't call addRadioButton!");
      }
      if (this.jdField_a_of_type_JavaUtilArrayList == null) {
        this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
      }
      paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
      if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
        this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
      }
      if (paramBoolean2) {
        break label139;
      }
      if (this.jdField_a_of_type_JavaUtilHashSet == null) {
        this.jdField_a_of_type_JavaUtilHashSet = new HashSet();
      }
      this.jdField_a_of_type_JavaUtilHashSet.add(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1));
    }
    for (;;)
    {
      this.jdField_a_of_type_Boolean = true;
      return;
      label139:
      if (paramBoolean1) {
        this.jdField_a_of_type_Int = (this.jdField_a_of_type_JavaUtilArrayList.size() - 1);
      }
    }
  }
  
  public void a(CharSequence paramCharSequence, Drawable paramDrawable, int paramInt)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    paramCharSequence = new Pair(paramCharSequence, Integer.valueOf(paramInt));
    if (!this.jdField_a_of_type_JavaUtilArrayList.contains(paramCharSequence)) {
      this.jdField_a_of_type_JavaUtilArrayList.add(paramCharSequence);
    }
    this.jdField_b_of_type_JavaUtilHashMap.put(Integer.valueOf(this.jdField_a_of_type_JavaUtilArrayList.size() - 1), paramDrawable);
  }
  
  public void a(CharSequence paramCharSequence, boolean paramBoolean)
  {
    a(paramCharSequence, 0, paramBoolean);
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    Object localObject = this.jdField_a_of_type_AndroidContentResResources.getDrawable(paramInt1);
    if (localObject == null) {}
    do
    {
      return;
      SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder(paramString + "icon");
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
      ((VerticalCenterImageSpan)localObject).a(AIOUtils.a(10.0F, this.jdField_a_of_type_AndroidContentResResources), 0);
      localSpannableStringBuilder.setSpan(localObject, paramString.length(), localSpannableStringBuilder.length(), 18);
      paramString = new Pair(localSpannableStringBuilder, Integer.valueOf(paramInt2));
    } while (this.jdField_a_of_type_JavaUtilArrayList.contains(paramString));
    this.jdField_a_of_type_JavaUtilArrayList.add(paramString);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.setOnClickListener(null);
  }
  
  public void b()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.removeAllViews();
    e();
  }
  
  public void b(int paramInt)
  {
    a(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt), 0);
  }
  
  public void b(View paramView)
  {
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidWidgetLinearLayout.addView(paramView);
  }
  
  public void b(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_b_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void b(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0) != null))
    {
      if (paramBoolean) {
        this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(this.jdField_c_of_type_AndroidViewView$OnClickListener);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_AndroidViewViewGroup.getChildAt(0).setOnClickListener(null);
  }
  
  public void c()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    this.jdField_a_of_type_JavaUtilHashMap.clear();
    this.jdField_b_of_type_JavaUtilHashMap.clear();
    this.jdField_c_of_type_JavaUtilHashMap.clear();
    this.jdField_d_of_type_JavaUtilHashMap.clear();
    this.jdField_e_of_type_JavaUtilHashMap.clear();
    this.jdField_a_of_type_AndroidWidgetRelativeLayout.removeAllViews();
  }
  
  public void c(int paramInt)
  {
    d(this.jdField_a_of_type_AndroidContentResResources.getText(paramInt));
  }
  
  public void c(CharSequence paramCharSequence)
  {
    a(paramCharSequence, 0);
  }
  
  public void c(boolean paramBoolean)
  {
    this.g = paramBoolean;
  }
  
  /* Error */
  public void d()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 586	android/app/Dialog:dismiss	()V
    //   4: aload_0
    //   5: invokestatic 591	com/tencent/mfsdk/LeakInspector/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   8: return
    //   9: astore_1
    //   10: aload_0
    //   11: invokestatic 591	com/tencent/mfsdk/LeakInspector/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   14: return
    //   15: astore_1
    //   16: aload_0
    //   17: invokestatic 591	com/tencent/mfsdk/LeakInspector/ActivityLeakSolution:a	(Landroid/app/Dialog;)V
    //   20: aload_1
    //   21: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	22	0	this	ActionSheet
    //   9	1	1	localException	Exception
    //   15	6	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   0	4	9	java/lang/Exception
    //   0	4	15	finally
  }
  
  public void d(int paramInt)
  {
    if ((paramInt >= 0) && (this.jdField_a_of_type_JavaUtilArrayList != null) && (paramInt < this.jdField_a_of_type_JavaUtilArrayList.size()))
    {
      this.jdField_a_of_type_Int = paramInt;
      if (this.jdField_a_of_type_AndroidUtilSparseArray != null)
      {
        View localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(this.jdField_a_of_type_Int);
        if (localView != null)
        {
          localView.findViewById(2131362812).setVisibility(0);
          a((TextView)localView.findViewById(2131362811), true);
        }
      }
    }
  }
  
  public void d(CharSequence paramCharSequence)
  {
    if (paramCharSequence != null) {
      this.jdField_c_of_type_JavaLangCharSequence = paramCharSequence;
    }
  }
  
  public void dismiss()
  {
    if (this.jdField_a_of_type_ComTencentWidgetActionSheet$WatchDismissActions != null) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet$WatchDismissActions.a();
    }
    if (this.f)
    {
      this.f = false;
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(new amai(this), 0L);
    }
  }
  
  public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent paramAccessibilityEvent)
  {
    if ((this.g) && (paramAccessibilityEvent.getEventType() == 32)) {
      return true;
    }
    super.dispatchPopulateAccessibilityEvent(paramAccessibilityEvent);
    paramAccessibilityEvent.setClassName(Dialog.class.getName());
    return false;
  }
  
  public void e(int paramInt)
  {
    if (paramInt > 0) {
      this.jdField_b_of_type_Int = paramInt;
    }
  }
  
  public boolean onPrepareOptionsMenu(Menu paramMenu)
  {
    if (this.jdField_b_of_type_Boolean) {}
    try
    {
      dismiss();
      label11:
      return super.onPrepareOptionsMenu(paramMenu);
    }
    catch (Exception localException)
    {
      break label11;
    }
  }
  
  public void setContentView(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setContentView(View paramView)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(int paramInt)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void setTitle(CharSequence paramCharSequence)
  {
    throw new UnsupportedOperationException("this method is not support");
  }
  
  public void show()
  {
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    super.show();
    e();
    this.jdField_a_of_type_AndroidOsHandler.postDelayed(new amah(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.widget.ActionSheet
 * JD-Core Version:    0.7.0.1
 */