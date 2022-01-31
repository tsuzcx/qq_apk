import android.content.Context;
import android.content.res.ColorStateList;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dataline.activities.PrinterActivity;
import com.dataline.util.widget.AsyncImageView;
import com.tencent.mobileqq.data.PrinterItemMsgRecord;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;
import java.util.ArrayList;

public class ge
  extends gm
{
  public static String a;
  ajum jdField_a_of_type_Ajum = null;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater = null;
  private View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gf(this);
  public View.OnLongClickListener a;
  public PrinterActivity a;
  BubblePopupWindow jdField_a_of_type_ComTencentWidgetBubblePopupWindow = null;
  
  static
  {
    jdField_a_of_type_JavaLangString = "dataline.PrinterSessionAdapter";
  }
  
  public ge(PrinterActivity paramPrinterActivity, ajum paramajum)
  {
    this.jdField_a_of_type_AndroidViewView$OnLongClickListener = new gh(this);
    this.jdField_a_of_type_Ajum = paramajum;
    this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity = paramPrinterActivity;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramPrinterActivity);
    this.jdField_a_of_type_Ajum.a.b();
    b();
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Ajum.a.a.size();
  }
  
  public long a(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Ajum.a.a.get(paramInt)).time;
  }
  
  protected boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow != null) && (this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.b())) {
      return true;
    }
    bbmf localbbmf = new bbmf();
    paramView = (fw)paramView.getTag();
    Object localObject1 = (PrinterItemMsgRecord)paramView.a();
    if (localObject1 != null)
    {
      localObject2 = paramView.a().jdField_a_of_type_AndroidWidgetRelativeLayout;
      if (localObject2 == null) {
        return false;
      }
    }
    else
    {
      return false;
    }
    Object localObject2 = ((RelativeLayout)localObject2).getContext();
    localbbmf.a(2131364990, ((Context)localObject2).getString(2131693895));
    localObject1 = new gi(this, (PrinterItemMsgRecord)localObject1, (Context)localObject2);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow = bbcq.a(paramView.jdField_a_of_type_AndroidWidgetRelativeLayout, localbbmf, (View.OnClickListener)localObject1);
    this.jdField_a_of_type_ComTencentWidgetBubblePopupWindow.a(new gg(this));
    return true;
  }
  
  public long b(int paramInt)
  {
    return ((PrinterItemMsgRecord)this.jdField_a_of_type_Ajum.a.a.get(paramInt)).uniseq;
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_Ajum.a.a.size();
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_Ajum.a.a.size() > paramInt) {
      this.jdField_a_of_type_Ajum.a.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (this.jdField_a_of_type_Ajum.a.a.size() > paramInt) {}
    for (paramViewGroup = (PrinterItemMsgRecord)this.jdField_a_of_type_Ajum.a.a.get(paramInt);; paramViewGroup = null)
    {
      if (paramViewGroup == null) {
        return null;
      }
      fw localfw;
      Object localObject;
      int i;
      if (paramView == null)
      {
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131558946, null);
        localfw = new fw();
        localfw.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)paramView.findViewById(2131370477));
        localfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setTag(localfw);
        localfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setClickable(true);
        localfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setLongClickable(true);
        localfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setOnLongClickListener(this.jdField_a_of_type_AndroidViewView$OnLongClickListener);
        localfw.jdField_a_of_type_AndroidWidgetRelativeLayout.setAddStatesFromChildren(true);
        localfw.b((TextView)paramView.findViewById(2131376454));
        localObject = (RelativeLayout)paramView.findViewById(2131366236);
        localfw.a().jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)localObject);
        localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView = ((AsyncImageView)paramView.findViewById(2131366212));
        localfw.a().jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131366249));
        localfw.a().jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramView.findViewById(2131366224));
        localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(2130849630);
        localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localfw.a((TextView)paramView.findViewById(2131364919));
        paramView.setTag(localfw);
        localfw.a(paramViewGroup);
        localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setIsDrawRound(false);
        localObject = apvd.a(paramViewGroup.filename);
        if (localObject != null) {
          break label641;
        }
        localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(2130843550);
        localObject = paramViewGroup.filename;
        i = paramViewGroup.filename.lastIndexOf("/");
        if (i >= 0) {
          localObject = apug.d(paramViewGroup.filename.substring(i + 1));
        }
        localfw.a().jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
        switch (paramViewGroup.status)
        {
        }
      }
      for (;;)
      {
        if (ThemeUtil.isInNightMode(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.app))
        {
          localObject = (anoy)this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity.a.getTag(2131361805);
          if (localObject != null)
          {
            i = acur.a(((anoy)localObject).getBitmap());
            localfw.a().setTextColor(ColorStateList.valueOf(i));
          }
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("dataline.time", 4, "time[" + paramViewGroup.time + "], uniseq[" + paramViewGroup.uniseq + "], lastShowTime[" + this.jdField_a_of_type_Long + "], filename[" + paramViewGroup.filename + "], position[" + paramInt + "], mapShowTime[" + a(paramViewGroup.uniseq));
        }
        if (!a(paramViewGroup.uniseq)) {
          break label893;
        }
        paramViewGroup = bbkp.a(this.jdField_a_of_type_ComDatalineActivitiesPrinterActivity, 3, paramViewGroup.time * 1000L);
        localfw.a().setVisibility(0);
        localfw.a().setText(paramViewGroup);
        return paramView;
        localfw = (fw)paramView.getTag();
        break;
        label641:
        localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setDefaultImage(apug.b((String)localObject));
        switch (apug.a((String)localObject))
        {
        default: 
          i = apug.b((String)localObject);
          if (i == 0) {
            break;
          }
          localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setImageResource(i);
          break;
        case 0: 
          localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncClipSize(128, 128);
          localfw.a().jdField_a_of_type_ComDatalineUtilWidgetAsyncImageView.setAsyncImage(paramViewGroup.filename);
          break;
          localfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localfw.b().setText(2131691370);
          continue;
          localfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
          localfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setProgress((int)(paramViewGroup.progress * 100.0D));
          localfw.b().setText(2131691371);
          continue;
          localfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localfw.b().setText(2131691373);
          continue;
          localfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localfw.b().setText(2131691372);
          continue;
          localfw.a().jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(4);
          localfw.b().setText(2131691374);
        }
      }
      label893:
      localfw.a().setVisibility(8);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     ge
 * JD-Core Version:    0.7.0.1
 */