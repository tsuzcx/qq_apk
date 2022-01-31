import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.text.TextUtils.TruncateAt;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.data.MessageRecord;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class nuh
{
  private int jdField_a_of_type_Int;
  private PopupWindow jdField_a_of_type_AndroidWidgetPopupWindow;
  private int b;
  
  public boolean a(Context paramContext, MessageRecord paramMessageRecord, TextView paramTextView, String paramString)
  {
    if (paramTextView != null) {}
    for (;;)
    {
      int i;
      try
      {
        boolean bool = bdje.a(paramString);
        if (bool) {
          return false;
        }
        try
        {
          paramString = new JSONObject(paramString);
          if (paramString.has("menus"))
          {
            paramTextView.setBackgroundResource(2130846575);
            paramTextView.setVisibility(0);
            paramTextView.setText(alpo.a(2131703994));
            localObject1 = paramContext.getResources().getDrawable(2130846578);
            ((Drawable)localObject1).setBounds(0, 0, 24, 16);
            paramTextView.setCompoundDrawables(null, null, (Drawable)localObject1, null);
            i = xod.a(paramContext, 6.0F);
            paramTextView.setPadding(i, 0, i, 0);
            paramTextView.setCompoundDrawablePadding(xod.a(paramContext, 2.0F));
            paramTextView.setSingleLine(true);
            paramTextView.setGravity(17);
            paramTextView.setEllipsize(TextUtils.TruncateAt.END);
            paramTextView.setTextColor(Color.rgb(187, 187, 187));
            paramTextView.setTextSize(2, 12.0F);
            localObject1 = LayoutInflater.from(paramContext).inflate(2131559447, null);
            LinearLayout localLinearLayout = (LinearLayout)((View)localObject1).findViewById(2131369614);
            paramString = paramString.optJSONArray("menus");
            if ((paramString == null) || (paramString.length() <= 0)) {
              break;
            }
            i = 0;
            if (i < paramString.length())
            {
              Object localObject2 = paramString.optJSONObject(i);
              if (localObject2 == null) {
                break label669;
              }
              int j = ((JSONObject)localObject2).optInt("action_type");
              Object localObject3 = new LinearLayout(paramContext);
              ((LinearLayout)localObject3).setOnClickListener(new nui(this, j, (JSONObject)localObject2, paramContext, paramMessageRecord));
              localLinearLayout.addView((View)localObject3);
              Object localObject4 = (LinearLayout.LayoutParams)((LinearLayout)localObject3).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject4).width = -1;
              ((LinearLayout.LayoutParams)localObject4).height = xod.a(paramContext, 50.0F);
              ((LinearLayout)localObject3).setOrientation(0);
              ((LinearLayout)localObject3).setGravity(16);
              localObject4 = new ImageView(paramContext);
              ((LinearLayout)localObject3).addView((View)localObject4);
              Object localObject5 = (LinearLayout.LayoutParams)((ImageView)localObject4).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject5).width = xod.a(paramContext, 20.0F);
              ((LinearLayout.LayoutParams)localObject5).height = xod.a(paramContext, 18.0F);
              ((LinearLayout.LayoutParams)localObject5).leftMargin = xod.a(paramContext, 15.0F);
              localObject5 = ((JSONObject)localObject2).optString("icon_url", "");
              if (!bdje.a((String)localObject5))
              {
                URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
                localURLDrawableOptions.mRequestHeight = xod.a(paramContext, 20.0F);
                localURLDrawableOptions.mRequestWidth = xod.a(paramContext, 18.0F);
                localObject5 = URLDrawable.getDrawable((String)localObject5, localURLDrawableOptions);
                if (localObject5 != null) {
                  ((ImageView)localObject4).setImageDrawable((Drawable)localObject5);
                }
              }
              localObject4 = new TextView(paramContext);
              ((LinearLayout)localObject3).addView((View)localObject4);
              localObject3 = (LinearLayout.LayoutParams)((TextView)localObject4).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject3).width = -1;
              ((LinearLayout.LayoutParams)localObject3).height = -2;
              ((LinearLayout.LayoutParams)localObject3).leftMargin = xod.a(paramContext, 10.0F);
              ((TextView)localObject4).setText(((JSONObject)localObject2).optString("title"));
              ((TextView)localObject4).setTextColor(Color.parseColor("#000000"));
              ((TextView)localObject4).setTextSize(16.0F);
              if (i >= paramString.length() - 1) {
                break label669;
              }
              localObject2 = new View(paramContext);
              localLinearLayout.addView((View)localObject2);
              localObject3 = (LinearLayout.LayoutParams)((View)localObject2).getLayoutParams();
              ((LinearLayout.LayoutParams)localObject3).width = -2;
              ((LinearLayout.LayoutParams)localObject3).height = xod.a(paramContext, 1.0F);
              ((View)localObject2).setBackgroundColor(Color.parseColor("#E0E0E0"));
            }
          }
        }
        catch (JSONException paramString)
        {
          Object localObject1;
          paramString = new JSONObject();
          continue;
          ((View)localObject1).measure(0, 0);
          this.jdField_a_of_type_AndroidWidgetPopupWindow = new PopupWindow((View)localObject1, -1, -2, true);
          this.jdField_a_of_type_AndroidWidgetPopupWindow.setTouchable(true);
          this.jdField_a_of_type_AndroidWidgetPopupWindow.setOutsideTouchable(true);
          paramTextView.setOnClickListener(new nuj(this, paramContext, paramTextView, paramMessageRecord));
          return true;
        }
        return false;
      }
      catch (Throwable paramContext)
      {
        return false;
      }
      label669:
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     nuh
 * JD-Core Version:    0.7.0.1
 */