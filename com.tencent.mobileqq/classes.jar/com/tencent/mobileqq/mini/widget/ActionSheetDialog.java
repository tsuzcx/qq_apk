package com.tencent.mobileqq.mini.widget;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import cooperation.qzone.util.QZLog;
import java.util.ArrayList;

public class ActionSheetDialog
  extends Dialog
  implements DialogInterface.OnCancelListener
{
  public static final int BUTTON_ADD_IMAGE = 2;
  public static final int BUTTON_DELETE = 1;
  public static final int BUTTON_NORMAL = 0;
  public static final int BUTTON_TITLE = 3;
  private TranslateAnimation animation;
  private RelativeLayout backgroundLayout;
  private int buttonCount = 0;
  private ArrayList<Button> buttonsList = new ArrayList();
  private View.OnClickListener cancelListener = null;
  private LinearLayout customButtonContainer;
  private Handler handler;
  private boolean mCancelButtonHasAdd = false;
  private LinearLayout mContainer;
  private Context mContext;
  private View.OnClickListener mDefaultDismissListener = new ActionSheetDialog.2(this);
  private boolean mDismissFinish = true;
  private LayoutInflater mInflater;
  private boolean mNeedInitContentView = true;
  private SystemBarCompact mSystemBarComp;
  
  public ActionSheetDialog(Context paramContext)
  {
    this(paramContext, 2131952168);
  }
  
  public ActionSheetDialog(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
    this.mContext = paramContext;
    setTransparentStatusBar();
    this.mInflater = LayoutInflater.from(paramContext);
    setContentView(2131628508);
    init();
    bindEvents();
  }
  
  private void bindEvents()
  {
    this.handler = new Handler(Looper.getMainLooper());
  }
  
  private void init()
  {
    this.customButtonContainer = ((LinearLayout)findViewById(2131431538));
    this.mContainer = ((LinearLayout)findViewById(2131437821));
    this.backgroundLayout = ((RelativeLayout)findViewById(2131429234));
  }
  
  private void prepareContentViews()
  {
    if (!this.mNeedInitContentView) {
      return;
    }
    int m = this.buttonsList.size();
    int k = 0;
    Object localObject1;
    Object localObject2;
    while (k < m)
    {
      localObject1 = (Button)this.buttonsList.get(k);
      int j = ((Integer)((Button)localObject1).getTag()).intValue();
      int i;
      if ((k == 0) && (m == 1)) {
        i = 2130837698;
      } else if ((k == 0) && (m > 1)) {
        i = 2130837701;
      } else if ((k == m - 1) && (m > 1)) {
        i = 2130837681;
      } else {
        i = 2130837691;
      }
      if (j != 1)
      {
        if (j != 2)
        {
          if (j != 3)
          {
            j = this.mContext.getResources().getColor(2131165406);
          }
          else
          {
            j = this.mContext.getResources().getColor(2131165794);
            ((Button)localObject1).setTextSize(0, this.mContext.getResources().getDimension(2131299863));
            ((Button)localObject1).setClickable(false);
            ((Button)localObject1).setVisibility(8);
            addTitle(((Button)localObject1).getText().toString());
          }
        }
        else
        {
          ViewUtils.dip2px(8.0F);
          j = this.mContext.getResources().getColor(2131165406);
          localObject2 = new SpannableString(((Button)localObject1).getText());
          Object localObject3 = this.mContext.getResources().getDrawable(2130851282);
          ((Drawable)localObject3).setBounds(0, 0, ((Drawable)localObject3).getIntrinsicWidth(), ((Drawable)localObject3).getIntrinsicHeight());
          localObject3 = new ImageSpan((Drawable)localObject3, 1);
          if ((((SpannableString)localObject2).length() >= 1) && (((SpannableString)localObject2).charAt(((SpannableString)localObject2).length() - 1) == '@')) {
            ((SpannableString)localObject2).setSpan(localObject3, ((SpannableString)localObject2).length() - 1, ((SpannableString)localObject2).length(), 33);
          }
          ((Button)localObject1).setText((CharSequence)localObject2);
        }
      }
      else {
        j = this.mContext.getResources().getColor(2131165410);
      }
      ((Button)localObject1).setBackgroundResource(i);
      ((Button)localObject1).setTextColor(j);
      k += 1;
    }
    if (!this.mCancelButtonHasAdd)
    {
      localObject1 = this.mInflater.inflate(2131624005, null);
      localObject2 = (Button)((View)localObject1).findViewById(2131427548);
      ((Button)localObject2).setOnClickListener(this.mDefaultDismissListener);
      ((Button)localObject2).setText(2131887648);
      this.customButtonContainer.addView((View)localObject1);
      this.mCancelButtonHasAdd = true;
    }
    this.mNeedInitContentView = false;
  }
  
  private void setTransparentStatusBar()
  {
    if (ImmersiveUtils.isSupporImmersive() == 1) {
      getWindow().addFlags(67108864);
    }
  }
  
  public Button addButton(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View.OnClickListener paramOnClickListener)
  {
    paramOnClickListener = addButton(getContext().getResources().getString(paramInt2), paramInt3, paramInt4, paramOnClickListener);
    if (paramOnClickListener != null) {
      paramOnClickListener.setId(paramInt1);
    }
    return paramOnClickListener;
  }
  
  public Button addButton(int paramInt1, int paramInt2, int paramInt3, View.OnClickListener paramOnClickListener)
  {
    paramOnClickListener = addButton(paramInt2, paramInt3, paramOnClickListener);
    if (paramOnClickListener != null) {
      paramOnClickListener.setId(paramInt1);
    }
    return paramOnClickListener;
  }
  
  public Button addButton(int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    return addButton(getContext().getResources().getString(paramInt1), paramInt2, paramOnClickListener);
  }
  
  public Button addButton(String paramString, int paramInt1, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (paramInt2 >= 0)
    {
      if (paramInt2 > this.buttonCount) {
        return null;
      }
      try
      {
        Button localButton = new Button(this.mContext);
        this.customButtonContainer.addView(localButton, paramInt2);
        LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
        localLayoutParams.width = -1;
        localLayoutParams.height = ((int)this.mContext.getResources().getDimension(2131297055));
        localButton.setLayoutParams(localLayoutParams);
        localButton.setTextSize(0, this.mContext.getResources().getDimension(2131299862));
        localButton.setText(paramString);
        localButton.setOnClickListener(paramOnClickListener);
        this.buttonCount += 1;
        localButton.setTag(Integer.valueOf(paramInt1));
        if ((paramInt2 >= 0) && (paramInt2 <= this.buttonsList.size())) {
          this.buttonsList.add(paramInt2, localButton);
        }
        this.mNeedInitContentView = true;
        return localButton;
      }
      catch (Exception paramString)
      {
        paramOnClickListener = new StringBuilder();
        paramOnClickListener.append("e:");
        paramOnClickListener.append(paramString.toString());
        QZLog.e("ActionSheetDialog", paramOnClickListener.toString());
      }
    }
    return null;
  }
  
  public Button addButton(String paramString, int paramInt, View.OnClickListener paramOnClickListener)
  {
    try
    {
      Button localButton = new Button(this.mContext);
      this.customButtonContainer.addView(localButton);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)localButton.getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = ((int)this.mContext.getResources().getDimension(2131297055));
      localLayoutParams.gravity = 17;
      localButton.setLayoutParams(localLayoutParams);
      localButton.setTextSize(0, this.mContext.getResources().getDimension(2131299862));
      localButton.setText(paramString);
      localButton.setOnClickListener(paramOnClickListener);
      this.buttonCount += 1;
      localButton.setTag(Integer.valueOf(paramInt));
      this.buttonsList.add(localButton);
      this.mNeedInitContentView = true;
      return localButton;
    }
    catch (Exception paramString)
    {
      paramOnClickListener = new StringBuilder();
      paramOnClickListener.append("e:");
      paramOnClickListener.append(paramString.toString());
      QZLog.e("ActionSheetDialog", paramOnClickListener.toString());
    }
    return null;
  }
  
  public TextView addTitle(String paramString)
  {
    try
    {
      localObject = new Button(this.mContext);
      this.customButtonContainer.addView((View)localObject, 0);
      LinearLayout.LayoutParams localLayoutParams = (LinearLayout.LayoutParams)((TextView)localObject).getLayoutParams();
      localLayoutParams.width = -1;
      localLayoutParams.height = ((int)this.mContext.getResources().getDimension(2131297055));
      localLayoutParams.gravity = 17;
      ((TextView)localObject).setLayoutParams(localLayoutParams);
      ((TextView)localObject).setTextSize(0, this.mContext.getResources().getDimension(2131299863));
      ((TextView)localObject).setText(paramString);
      ((TextView)localObject).setTextColor(this.mContext.getResources().getColor(2131165794));
      ((TextView)localObject).setBackgroundResource(2130837701);
      ((TextView)localObject).setClickable(false);
      return localObject;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("e:");
      ((StringBuilder)localObject).append(paramString.toString());
      QZLog.e("ActionSheetDialog", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public void clear()
  {
    LinearLayout localLinearLayout = this.customButtonContainer;
    if (localLinearLayout != null)
    {
      localLinearLayout.removeAllViews();
      this.mCancelButtonHasAdd = false;
    }
  }
  
  public void dismiss()
  {
    if (this.mDismissFinish)
    {
      this.mDismissFinish = false;
      this.handler.postDelayed(new ActionSheetDialog.3(this), 0L);
    }
  }
  
  public Button getButtonById(int paramInt)
  {
    View localView = this.customButtonContainer.findViewById(paramInt);
    if ((localView != null) && ((localView instanceof Button))) {
      return (Button)localView;
    }
    return null;
  }
  
  public Button getButtonByIndex(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.buttonsList.size())) {
      return (Button)this.buttonsList.get(paramInt);
    }
    return null;
  }
  
  public Button getButtonByTag(int paramInt)
  {
    int i = 0;
    while (i < this.buttonsList.size())
    {
      if (((Integer)((Button)this.buttonsList.get(i)).getTag()).intValue() == paramInt) {
        return (Button)this.buttonsList.get(i);
      }
      i += 1;
    }
    return null;
  }
  
  public int getButtonCount()
  {
    return this.buttonCount;
  }
  
  public int getButtonIndexById(int paramInt)
  {
    int i = 0;
    while (i < this.buttonsList.size())
    {
      if (paramInt == ((Button)this.buttonsList.get(i)).getId()) {
        return i;
      }
      i += 1;
    }
    return this.buttonsList.size();
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = this.cancelListener;
    if (paramDialogInterface != null) {}
    try
    {
      paramDialogInterface.onClick(null);
      return;
    }
    catch (Exception paramDialogInterface) {}
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 82) {
      dismiss();
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void setAddImageButtonText(Button paramButton)
  {
    if (paramButton != null)
    {
      int i = ViewUtils.dip2px(8.0F);
      int j = this.mContext.getResources().getColor(2131165406);
      SpannableString localSpannableString = new SpannableString(paramButton.getText());
      Drawable localDrawable = this.mContext.getResources().getDrawable(2130851282);
      localDrawable.setBounds(i, 0, localDrawable.getIntrinsicWidth() + i, localDrawable.getIntrinsicHeight());
      localSpannableString.setSpan(new ImageSpan(localDrawable, 1), localSpannableString.length() - 1, localSpannableString.length(), 33);
      paramButton.setText(localSpannableString);
      paramButton.setTextColor(j);
    }
  }
  
  public void setDefaultDismissListener(View.OnClickListener paramOnClickListener)
  {
    this.mDefaultDismissListener = paramOnClickListener;
  }
  
  public void setNeedInitContentView(boolean paramBoolean)
  {
    this.mNeedInitContentView = paramBoolean;
  }
  
  public void show()
  {
    super.show();
    prepareContentViews();
    this.mContainer.setVisibility(4);
    this.backgroundLayout.setVisibility(4);
    this.mDismissFinish = true;
    this.handler.postDelayed(new ActionSheetDialog.1(this), 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.ActionSheetDialog
 * JD-Core Version:    0.7.0.1
 */