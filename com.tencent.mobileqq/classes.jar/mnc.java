import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.view.ViewCompat;
import android.text.Editable;
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
import com.tencent.mobileqq.emoticonview.EmoticonCallback;
import com.tencent.mobileqq.emoticonview.EmoticonInfo;
import com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo;
import com.tencent.mobileqq.text.QQTextBuilder;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class mnc
  implements Handler.Callback, ViewTreeObserver.OnGlobalLayoutListener, EmoticonCallback
{
  private static final String jdField_a_of_type_JavaLangString = BaseApplication.getContext().getString(2131695217);
  private static final String jdField_b_of_type_JavaLangString = BaseApplication.getContext().getString(2131695220);
  private int jdField_a_of_type_Int = 0;
  private final Activity jdField_a_of_type_AndroidAppActivity;
  private final Point jdField_a_of_type_AndroidGraphicsPoint = new Point();
  private final Rect jdField_a_of_type_AndroidGraphicsRect = new Rect();
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private final InputMethodManager jdField_a_of_type_AndroidViewInputmethodInputMethodManager;
  private EditText jdField_a_of_type_AndroidWidgetEditText;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private final bkys jdField_a_of_type_Bkys = new bkys(Looper.getMainLooper(), this);
  private VideoChatRoomListView jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView;
  private mnj jdField_a_of_type_Mnj;
  public boolean a;
  private int jdField_b_of_type_Int = 0;
  private int c = 0;
  private int d = -1;
  private int e = -1;
  
  private mnc(Activity paramActivity)
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
  
  public static mnc a(Activity paramActivity)
  {
    return new mnc(paramActivity);
  }
  
  private void a(int paramInt, long paramLong)
  {
    if (this.c != paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ChatRoomUtil", 2, String.format("updateInputPanelState, [%s --> %s], seq[%s], soft[%s]", new Object[] { Integer.valueOf(this.c), Integer.valueOf(paramInt), Long.valueOf(paramLong), Integer.valueOf(this.jdField_a_of_type_Int) }));
      }
      this.c = paramInt;
      if (this.jdField_a_of_type_Mnj != null) {
        this.jdField_a_of_type_Mnj.a(this.c, paramLong);
      }
    }
  }
  
  private void a(long paramLong, int paramInt)
  {
    int i = this.jdField_b_of_type_Int;
    if (this.jdField_b_of_type_Int != paramInt) {
      this.jdField_b_of_type_Int = paramInt;
    }
    if ((this.jdField_a_of_type_Mnj != null) && (i != paramInt)) {
      this.jdField_a_of_type_Mnj.b(i, paramInt, this.c, paramLong);
    }
  }
  
  private void d()
  {
    QQTextBuilder localQQTextBuilder = null;
    Object localObject = this.jdField_a_of_type_AndroidWidgetEditText.getText();
    if ((localObject instanceof QQTextBuilder))
    {
      localQQTextBuilder = (QQTextBuilder)localObject;
      localObject = null;
    }
    for (;;)
    {
      if (localQQTextBuilder != null) {
        localObject = lkj.a(localQQTextBuilder);
      }
      this.jdField_a_of_type_AndroidWidgetEditText.setText("");
      if ((this.jdField_a_of_type_Mnj != null) && (!android.text.TextUtils.isEmpty((CharSequence)localObject))) {
        this.jdField_a_of_type_Mnj.a((String)localObject);
      }
      return;
      localObject = localObject.toString();
      if (com.tencent.mobileqq.text.TextUtils.hasSysEmotion((String)localObject)) {
        localQQTextBuilder = new QQTextBuilder((CharSequence)localObject, 3, 16);
      }
    }
  }
  
  private void e()
  {
    long l = AudioHelper.b();
    if (this.jdField_a_of_type_Bkys.hasMessages(2)) {
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
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842195);
    if (c())
    {
      a(5, l);
      c();
      Message localMessage = Message.obtain();
      localMessage.what = 2;
      localMessage.arg1 = 0;
      localMessage.arg2 = 0;
      this.jdField_a_of_type_Bkys.sendMessageDelayed(localMessage, 100L);
      return;
    }
    f();
  }
  
  private void f()
  {
    long l = AudioHelper.b();
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842195);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_b_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(0);
    a(4, l);
    a(l, 1);
  }
  
  private void g()
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
        if (this.d != -1) {
          break label494;
        }
        this.d = j;
        if (this.e != -1) {
          break label510;
        }
        this.e = j;
        if ((this.d == this.e) && (this.jdField_a_of_type_AndroidGraphicsRect.top > 0)) {
          this.d = this.jdField_a_of_type_AndroidGraphicsRect.top;
        }
      }
      if (i != this.jdField_a_of_type_Int)
      {
        l = AudioHelper.b();
        if (i == 1)
        {
          this.jdField_a_of_type_AndroidAppActivity.getWindowManager().getDefaultDisplay().getSize(this.jdField_a_of_type_AndroidGraphicsPoint);
          lkj.jdField_a_of_type_Int = Math.max(this.jdField_a_of_type_AndroidGraphicsPoint.y - this.jdField_a_of_type_AndroidGraphicsRect.bottom, this.e - this.d);
        }
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("updateSoftKeyboardState, seq[%s], [%s --> %s], inputPanelState[%s], height[%s], KeyBoardHeight[%s], ARMode2[%s], decorView[%s, %s, %s, %s], s[%s, %s], temp[%s, %s, %s, %s], diff[%s, %s]", new Object[] { Long.valueOf(l), Integer.valueOf(this.jdField_a_of_type_Int), Integer.valueOf(i), Integer.valueOf(this.c), Integer.valueOf(j), Integer.valueOf(lkj.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_Boolean), Integer.valueOf(localView1.getLeft()), Integer.valueOf(localView1.getTop()), Integer.valueOf(localView1.getRight()), Integer.valueOf(localView1.getBottom()), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsPoint.x), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsPoint.y), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.left), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.top), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.right), Integer.valueOf(this.jdField_a_of_type_AndroidGraphicsRect.bottom), Integer.valueOf(this.d), Integer.valueOf(this.e) }));
        }
        j = this.jdField_a_of_type_Int;
        this.jdField_a_of_type_Int = i;
        if (this.jdField_a_of_type_Int != 1) {
          break label526;
        }
        this.jdField_a_of_type_Bkys.removeMessages(2);
        a(2, l);
        if (b()) {
          b();
        }
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_Mnj != null) {
        this.jdField_a_of_type_Mnj.a(j, i, this.c, l);
      }
      return;
      i = 2;
      break;
      label494:
      if (this.d <= j) {
        break label73;
      }
      this.d = j;
      break label73;
      label510:
      if (this.e >= j) {
        break label86;
      }
      this.e = j;
      break label86;
      label526:
      if (this.c == 5)
      {
        this.jdField_a_of_type_Bkys.removeMessages(2);
        f();
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
  
  private void h()
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
    if (!android.text.TextUtils.isEmpty(this.jdField_a_of_type_AndroidWidgetEditText.getText())) {
      this.jdField_a_of_type_AndroidWidgetEditText.setSelection(this.jdField_a_of_type_AndroidWidgetEditText.getText().length());
    }
    if (b())
    {
      a(6, l);
      b();
      return;
    }
    a(1, l);
  }
  
  public int a()
  {
    return this.c;
  }
  
  public mnc a()
  {
    this.jdField_a_of_type_AndroidAppActivity.getWindow().setSoftInputMode(19);
    return this;
  }
  
  public mnc a(ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    return this;
  }
  
  public mnc a(EditText paramEditText)
  {
    this.jdField_a_of_type_AndroidWidgetEditText = paramEditText;
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusable(true);
    this.jdField_a_of_type_AndroidWidgetEditText.setFocusableInTouchMode(true);
    this.jdField_a_of_type_AndroidWidgetEditText.requestFocus();
    this.jdField_a_of_type_AndroidWidgetEditText.setEditableFactory(QQTextBuilder.getCustomSizeEditableFactory(16));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnClickListener(new mnd(this));
    this.jdField_a_of_type_AndroidWidgetEditText.addTextChangedListener(new mne(this));
    this.jdField_a_of_type_AndroidWidgetEditText.setOnKeyListener(new mnf(this));
    ViewCompat.setAccessibilityDelegate(this.jdField_a_of_type_AndroidWidgetEditText, new mng(this));
    return this;
  }
  
  public mnc a(ImageView paramImageView)
  {
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842193);
    this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new mnh(this));
    return this;
  }
  
  public mnc a(VideoChatRoomListView paramVideoChatRoomListView)
  {
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView = paramVideoChatRoomListView;
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomListView.setOnDispatchTouchEventResponseListener(new mni(this));
    return this;
  }
  
  public mnc a(mnj parammnj)
  {
    this.jdField_a_of_type_Mnj = parammnj;
    return this;
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
  }
  
  public boolean a()
  {
    boolean bool2 = b();
    boolean bool1 = bool2;
    if (!bool2) {
      bool1 = c();
    }
    return bool1;
  }
  
  public void b()
  {
    long l = AudioHelper.b();
    if (b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130842193);
      this.jdField_a_of_type_AndroidWidgetImageView.setContentDescription(jdField_a_of_type_JavaLangString);
      this.jdField_a_of_type_AndroidViewViewGroup.setVisibility(8);
      if ((this.c != 6) && (!c())) {
        a(7, l);
      }
      a(l, 2);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_AndroidViewViewGroup != null) && (this.jdField_a_of_type_AndroidViewViewGroup.getVisibility() == 0);
  }
  
  public void c()
  {
    long l = AudioHelper.b();
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "hideSoftKeyboard, soft[" + c() + "], seq[" + l + "]");
    }
    if (c())
    {
      this.jdField_a_of_type_AndroidWidgetEditText.clearFocus();
      this.jdField_a_of_type_AndroidViewInputmethodInputMethodManager.hideSoftInputFromWindow(this.jdField_a_of_type_AndroidWidgetEditText.getWindowToken(), 0);
      if (this.c != 5) {
        a(3, l);
      }
    }
  }
  
  public boolean c()
  {
    if (this.jdField_a_of_type_Int == 0) {
      g();
    }
    return this.jdField_a_of_type_Int == 1;
  }
  
  public void delete()
  {
    com.tencent.mobileqq.text.TextUtils.backspace(this.jdField_a_of_type_AndroidWidgetEditText);
  }
  
  public void emoticonMall() {}
  
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
      this.jdField_a_of_type_Bkys.sendMessageDelayed(localMessage, 100L);
    }
    for (;;)
    {
      return true;
      label55:
      f();
    }
  }
  
  public void onGlobalLayout()
  {
    g();
  }
  
  public void onHidePopup(EmoticonInfo paramEmoticonInfo) {}
  
  public boolean onLongClick(EmoticonInfo paramEmoticonInfo)
  {
    return false;
  }
  
  public void onShowPopup(EmoticonInfo paramEmoticonInfo1, EmoticonInfo paramEmoticonInfo2, Drawable paramDrawable) {}
  
  public void send()
  {
    d();
  }
  
  public void send(EmoticonInfo paramEmoticonInfo)
  {
    if ((paramEmoticonInfo instanceof SystemAndEmojiEmoticonInfo)) {
      ((SystemAndEmojiEmoticonInfo)paramEmoticonInfo).send(null, this.jdField_a_of_type_AndroidAppActivity, this.jdField_a_of_type_AndroidWidgetEditText, null);
    }
  }
  
  public void setting() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     mnc
 * JD-Core Version:    0.7.0.1
 */