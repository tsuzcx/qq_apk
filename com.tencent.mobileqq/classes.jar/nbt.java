import android.app.Dialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.LruCache;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class nbt
  extends ReportDialog
{
  protected static final LruCache<String, URLDrawable> a;
  private View.OnClickListener a;
  
  static
  {
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(20);
  }
  
  public nbt(Context paramContext, mzj parammzj)
  {
    super(paramContext, 2131755824);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new nbu(this);
    if (QLog.isColorLevel()) {
      QLog.i("GameListDescriptionDialog", 2, "GameListDescriptionDialog show");
    }
    a(parammzj);
  }
  
  public static Dialog a(Context paramContext, mzj parammzj)
  {
    paramContext = new nbt(paramContext, parammzj);
    paramContext.show();
    return paramContext;
  }
  
  private void a(mzj parammzj)
  {
    setContentView(2131558723);
    getWindow().setLayout(-1, -1);
    View localView = findViewById(2131364203);
    localView.setOnClickListener(new nbv(this));
    Object localObject1 = (TextView)findViewById(2131371647);
    TextView localTextView = (TextView)findViewById(2131365413);
    Object localObject2 = findViewById(2131369575);
    ((View)localObject2).setOnTouchListener(new nbw(this));
    ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    findViewById(2131376925).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = findViewById(2131364584);
    ((View)localObject2).setBackgroundDrawable(nhs.a(getContext().getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (parammzj != null)
    {
      if (TextUtils.isEmpty(parammzj.l)) {
        break label284;
      }
      ((TextView)localObject1).setBackgroundDrawable(URLDrawable.getDrawable(parammzj.l, beyq.a, beyq.a));
      localObject1 = nhs.a("avgame_list_card_bg@3x.png");
      if (localObject1 == null) {
        break label302;
      }
      localObject2 = new BitmapDrawable((Bitmap)localObject1);
      label180:
      if (TextUtils.isEmpty(parammzj.c)) {
        break label309;
      }
      localObject1 = null;
      if (jdField_a_of_type_AndroidUtilLruCache != null) {
        localObject1 = (URLDrawable)jdField_a_of_type_AndroidUtilLruCache.get(parammzj.c);
      }
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = URLDrawable.getDrawable(parammzj.c, (Drawable)localObject2, (Drawable)localObject2);
        ((URLDrawable)localObject1).startDownload();
        localObject3 = localObject1;
        if (jdField_a_of_type_AndroidUtilLruCache != null)
        {
          jdField_a_of_type_AndroidUtilLruCache.put(parammzj.c, localObject1);
          localObject3 = localObject1;
        }
      }
      localView.setBackgroundDrawable(localObject3);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(parammzj.b)) {
        localTextView.setText(parammzj.b);
      }
      return;
      label284:
      if (parammzj.a == null) {
        break;
      }
      ((TextView)localObject1).setText(parammzj.a);
      break;
      label302:
      localObject2 = beyq.a;
      break label180;
      label309:
      localView.setBackgroundDrawable((Drawable)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     nbt
 * JD-Core Version:    0.7.0.1
 */