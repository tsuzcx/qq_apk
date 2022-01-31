package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import bftt;
import bful;
import java.util.ArrayList;

public class FootNavigationLayout
  extends LinearLayout
{
  private static final int[] jdField_a_of_type_ArrayOfInt = { 4, 5, 6 };
  private View jdField_a_of_type_AndroidViewView;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private View[] jdField_a_of_type_ArrayOfAndroidViewView;
  private TextView[] jdField_a_of_type_ArrayOfAndroidWidgetTextView;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private TextView c;
  
  public FootNavigationLayout(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    LayoutInflater.from(getContext()).inflate(2131496389, this);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131300683));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131309991));
    this.c = ((TextView)findViewById(2131311421));
    this.jdField_a_of_type_AndroidViewView = findViewById(2131299703);
    this.jdField_b_of_type_AndroidViewView = findViewById(2131299704);
    this.jdField_a_of_type_ArrayOfAndroidWidgetTextView = new TextView[] { this.jdField_a_of_type_AndroidWidgetTextView, this.jdField_b_of_type_AndroidWidgetTextView, this.c };
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[] { null, this.jdField_a_of_type_AndroidViewView, this.jdField_b_of_type_AndroidViewView };
  }
  
  public void a(ArrayList<bful> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      setVisibility(8);
      return;
    }
    int i = 0;
    label20:
    TextView localTextView;
    View localView;
    if (i < 3)
    {
      localTextView = this.jdField_a_of_type_ArrayOfAndroidWidgetTextView[i];
      localView = this.jdField_a_of_type_ArrayOfAndroidViewView[i];
      if (i < paramArrayList.size()) {
        break label77;
      }
      if (localTextView != null) {
        localTextView.setVisibility(8);
      }
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label77:
      bful localbful = (bful)paramArrayList.get(i);
      if ((localbful == null) || (TextUtils.isEmpty(localbful.a)) || (TextUtils.isEmpty(localbful.a.trim())))
      {
        if (localTextView != null) {
          localTextView.setVisibility(8);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      else
      {
        if (localTextView != null)
        {
          localTextView.setVisibility(0);
          localTextView.setText(localbful.a);
          localTextView.setOnClickListener(new bftt(this, localbful, i));
        }
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.contentbox.FootNavigationLayout
 * JD-Core Version:    0.7.0.1
 */