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
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class ncu
  extends ReportDialog
{
  protected static final LruCache<String, URLDrawable> a;
  private View.OnClickListener a;
  
  static
  {
    jdField_a_of_type_AndroidUtilLruCache = new LruCache(20);
  }
  
  public ncu(Context paramContext, nak paramnak)
  {
    super(paramContext, 2131755826);
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new ncv(this);
    if (QLog.isColorLevel()) {
      QLog.i("GameListDescriptionDialog", 2, "GameListDescriptionDialog show");
    }
    a(paramnak);
  }
  
  public static Dialog a(Context paramContext, nak paramnak)
  {
    paramContext = new ncu(paramContext, paramnak);
    paramContext.show();
    return paramContext;
  }
  
  private void a(nak paramnak)
  {
    setContentView(2131558729);
    getWindow().setLayout(-1, -1);
    View localView = findViewById(2131364222);
    localView.setOnClickListener(new ncw(this));
    Object localObject1 = (TextView)findViewById(2131371615);
    TextView localTextView = (TextView)findViewById(2131365445);
    Object localObject2 = findViewById(2131369566);
    ((View)localObject2).setOnTouchListener(new ncx(this));
    ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    findViewById(2131376679).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    localObject2 = findViewById(2131364615);
    ((View)localObject2).setBackgroundDrawable(njh.a(getContext().getResources(), "avgame_guide_close_nor@2x.png", "avgame_guide_close_press@2x.png"));
    ((View)localObject2).setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    if (paramnak != null)
    {
      if (TextUtils.isEmpty(paramnak.l)) {
        break label284;
      }
      ((TextView)localObject1).setBackgroundDrawable(URLDrawable.getDrawable(paramnak.l, URLDrawableHelper.TRANSPARENT, URLDrawableHelper.TRANSPARENT));
      localObject1 = njh.a("avgame_list_card_bg@3x.png");
      if (localObject1 == null) {
        break label302;
      }
      localObject2 = new BitmapDrawable((Bitmap)localObject1);
      label180:
      if (TextUtils.isEmpty(paramnak.c)) {
        break label309;
      }
      localObject1 = null;
      if (jdField_a_of_type_AndroidUtilLruCache != null) {
        localObject1 = (URLDrawable)jdField_a_of_type_AndroidUtilLruCache.get(paramnak.c);
      }
      Object localObject3 = localObject1;
      if (localObject1 == null)
      {
        localObject1 = URLDrawable.getDrawable(paramnak.c, (Drawable)localObject2, (Drawable)localObject2);
        ((URLDrawable)localObject1).startDownload();
        localObject3 = localObject1;
        if (jdField_a_of_type_AndroidUtilLruCache != null)
        {
          jdField_a_of_type_AndroidUtilLruCache.put(paramnak.c, localObject1);
          localObject3 = localObject1;
        }
      }
      localView.setBackgroundDrawable(localObject3);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(paramnak.b)) {
        localTextView.setText(paramnak.b);
      }
      return;
      label284:
      if (paramnak.a == null) {
        break;
      }
      ((TextView)localObject1).setText(paramnak.a);
      break;
      label302:
      localObject2 = URLDrawableHelper.TRANSPARENT;
      break label180;
      label309:
      localView.setBackgroundDrawable((Drawable)localObject2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ncu
 * JD-Core Version:    0.7.0.1
 */