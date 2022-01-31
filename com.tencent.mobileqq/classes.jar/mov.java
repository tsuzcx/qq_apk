import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.av.ui.chatroom.VideoChatRoomListView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;

public class mov
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, apuc
{
  private final int jdField_a_of_type_Int = 2130841818;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final bhtd jdField_a_of_type_Bhtd = new bhtd(Looper.getMainLooper(), this);
  private VideoChatRoomListView jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView;
  private mpb jdField_a_of_type_Mpb;
  public boolean a;
  private final int b = 2130841820;
  private int c = 0;
  private int d = 0;
  private int e = -1;
  private int f = -1;
  
  private mov(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager = ((InputMethodManager)paramActivity.getSystemService("input_method"));
    this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView().getViewTreeObserver().addOnGlobalLayoutListener(this);
    if (Build.VERSION.SDK_INT <= 18) {
      this.jdField_a_of_type_Boolean = true;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "EmotionInputDetector, ARMode2[" + this.jdField_a_of_type_Boolean + "], sdk[" + Build.VERSION.SDK_INT + "]");
    }
  }
  
  public static mov a(Activity paramActivity)
  {
    return new mov(paramActivity);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.d != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, String.format("updateInputPanelState, [%s --> %s], seq[%s], soft[%s]", new Object[] { Integer.valueOf(this.d), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(this.c) }));
      }
      this.d = paramInt;
      if (this.jdField_a_of_type_Mpb != null) {
        this.jdField_a_of_type_Mpb.a(this.d, paramLong);
      }
    }
  }
  
  private void g()
  {
    bamz localbamz = null;
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if ((localObject instanceof bamz))
    {
      localbamz = (bamz)localObject;
      localObject = null;
    }
    for (;;)
    {
      if (localbamz != null) {
        localObject = lmv.a(localbamz);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      if ((this.jdField_a_of_type_Mpb != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_a_of_type_Mpb.a((String)localObject);
      }
      return;
      localObject = localObject.toString();
      if (banh.a((String)localObject)) {
        localbamz = new bamz((CharSequence)localObject, 3, 16);
      }
    }
  }
  
  private void h()
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Bhtd.hasMessages(2)) {
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, "showEmotionLayout, is to show. seq[" + l + "]");
      }
    }
    do
    {
      return;
      if (!b()) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.i("ChatRoomUtil", 2, "showEmotionLayout, is showing. seq[" + l + "]");
    return;
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "showEmotionLayout, isSoftKeyboardShown[" + c() + "], seq[" + l + "]");
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841820);
    if (c())
    {
      a(5, l);
      f();
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = 0;
      localMessage.arg2 = 0;
      this.jdField_a_of_type_Bhtd.sendMessageDelayed(localMessage, 100L);
      return;
    }
    i();
  }
  
  private void i()
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841820);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    a(4, l);
  }
  
  private void j()
  {
    View localView1 = this.jdField_a_of_type_AndroidAppActivity.getWindow().getDecorView();
    View localView2 = localView1.getRootView();
    localView2.getWindowVisibleDisplayFrame(this.jdField_a_of_type_AndroidGraphicsRect);
    int i = localView2.getRootView().getHeight();
    int j = i - this.jdField_a_of_type_AndroidGraphicsRect.height();
    label73:
    label86:
    long l;
    if (j > i / 4)
    {
      i = 1;
      if (j > 0)
      {
        if (this.e != -1) {
          break label494;
        }
        this.e = j;
        if (this.f != -1) {
          break label510;
        }
        this.f = j;
        if ((this.e == this.f) && (this.jdField_a_of_type_AndroidGraphicsRect.top > 0)) {
          this.e = this.jdField_a_of_type_AndroidGraphicsRect.top;
        }
      }
      if (i != this.c)
      {
        l = AudioHelper.b();
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getSize(this.jdField_a_of_type_AndroidGraphicsPoint);
          lmv.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_AndroidGraphicsPoint.y - this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.f - this.e);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("updateSoftKeyboardState, seq[%s], [%s --> %s], inputPanelState[%s], height[%s], KeyBoardHeight[%s], ARMode2[%s], decorView[%s, %s, %s, %s], s[%s, %s], temp[%s, %s, %s, %s], diff[%s, %s]", new Object[] { Long.valueOf(l), Integer.valueOf(this.c), Integer.valueOf(i), Integer.valueOf(this.d), Integer.valueOf(j), Integer.valueOf(lmv.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(localView1.getLeft()), Integer.valueOf(localView1.getTop()), Integer.valueOf(localView1.getRight()), Integer.valueOf(localView1.getBottom()), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsPoint.x), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsPoint.y), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.left), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.top), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.right), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.bottom), Integer.valueOf(this.e), Integer.valueOf(this.f) }));
        }
        j = this.c;
        this.c = i;
        if (this.c != 1) {
          break label526;
        }
        this.jdField_a_of_type_Bhtd.removeMessages(2);
        a(2, l);
        if (b()) {
          e();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mpb != null) {
        this.jdField_a_of_type_Mpb.a(j, i, this.d, l);
      }
      return;
      i = 2;
      break;
      label494:
      if (this.e <= j) {
        break label73;
      }
      this.e = j;
      break label73;
      label510:
      if (this.f >= j) {
        break label86;
      }
      this.f = j;
      break label86;
      label526:
      if (this.d == 5)
      {
        this.jdField_a_of_type_Bhtd.removeMessages(2);
        i();
      }
      else if (b())
      {
        a(4, l);
      }
      else
      {
        a(7, l);
      }
    }
  }
  
  private void k()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, String.format("showSoftKeyboard, seq[%s], emotion[%s], soft[%s]", new Object[] { Long.valueOf(l), Boolean.valueOf(b()), Boolean.valueOf(c()) }));
    }
    if (c()) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    if (this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager != null) {
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.showSoftInput(this.jdField_a_of_type_AndroidWidgetEditText, 1);
    }
    if (!TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    if (b())
    {
      a(6, l);
      e();
      return;
    }
    a(1, l);
  }
  
  public int a()
  {
    return this.d;
  }
  
  public mov a()
  {
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setSoftInputMode(19);
    return this;
  }
  
  public mov a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    return this;
  }
  
  public mov a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(bamz.a(16));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new mow(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new mox(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new moy(this));
    return this;
  }
  
  public mov a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841818);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new moz(this));
    return this;
  }
  
  public mov a(VideoChatRoomListView paramVideoChatRoomListView)
  {
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView = paramVideoChatRoomListView;
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView.setOnDispatchTouchEventResponseListener(new mpa(this));
    return this;
  }
  
  public mov a(mpb parammpb)
  {
    this.jdField_a_of_type_Mpb = parammpb;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
  }
  
  public void a(apuf paramapuf)
  {
    if ((paramapuf instanceof apza)) {
      ((apza)paramapuf).a(null, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void a(apuf paramapuf1, apuf paramapuf2, Drawable paramDrawable) {}
  
  public boolean a()
  {
    boolean bool2 = b();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = c();
    }
    return bool1;
  }
  
  public boolean a(apuf paramapuf)
  {
    return false;
  }
  
  public void b()
  {
    banh.a(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void b(apuf paramapuf) {}
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
  
  public void c()
  {
    g();
  }
  
  public boolean c()
  {
    if (this.c == 0) {
      j();
    }
    return this.c == 1;
  }
  
  public void d() {}
  
  public void e()
  {
    long l = AudioHelper.b();
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130841818);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((this.d != 6) && (!c())) {
        a(7, l);
      }
    }
  }
  
  public void f()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "hideSoftKeyboard, soft[" + c() + "], seq[" + l + "]");
    }
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      if (this.d != 5) {
        a(3, l);
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 2)
    {
      if ((!c()) || (paramMessage.arg1 != 0)) {
        break label55;
      }
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      paramMessage.arg1 += 1;
      this.jdField_a_of_type_Bhtd.sendMessageDelayed(localMessage, 100L);
    }
    for (;;)
    {
      return true;
      label55:
      i();
    }
  }
  
  public void onGlobalLayout()
  {
    j();
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     mov
 * JD-Core Version:    0.7.0.1
 */