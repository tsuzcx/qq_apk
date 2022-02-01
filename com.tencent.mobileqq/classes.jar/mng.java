import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextUtils;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.EditText;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.chatroom.ChatRoomInfo;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoControlUI;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.av.ui.chatroom.VideoChatRoomContainer;
import com.tencent.av.ui.chatroom.VideoChatRoomUIContoller.3;
import com.tencent.av.ui.guide.GuideHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class mng
{
  private final VideoAppInterface jdField_a_of_type_ComTencentAvAppVideoAppInterface;
  private final AVActivity jdField_a_of_type_ComTencentAvUiAVActivity;
  private VideoChatRoomContainer jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  private StringBuilder jdField_a_of_type_JavaLangStringBuilder;
  private ArrayList<lkb> jdField_a_of_type_JavaUtilArrayList = new ArrayList(10);
  private List<mne> jdField_a_of_type_JavaUtilList;
  private final mnj jdField_a_of_type_Mnj;
  private final mnk jdField_a_of_type_Mnk;
  private ArrayList<mne> b = new ArrayList(10);
  private ArrayList<mne> c = new ArrayList(10);
  
  public mng(AVActivity paramAVActivity, VideoAppInterface paramVideoAppInterface)
  {
    this.jdField_a_of_type_ComTencentAvUiAVActivity = paramAVActivity;
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface = paramVideoAppInterface;
    this.jdField_a_of_type_Mnk = new mnk(this);
    this.jdField_a_of_type_Mnj = new mnj(this);
    this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a(this.jdField_a_of_type_Mnk);
    paramAVActivity = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (paramAVActivity != null) {
      paramAVActivity.a(this.jdField_a_of_type_Mnj);
    }
  }
  
  private VideoChatRoomContainer a()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null)
    {
      ((ViewStub)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131373620)).inflate();
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = ((VideoChatRoomContainer)this.jdField_a_of_type_ComTencentAvUiAVActivity.findViewById(2131373346));
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvAppVideoAppInterface);
    }
    return this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer;
  }
  
  private void a(ChatRoomInfo paramChatRoomInfo)
  {
    if (paramChatRoomInfo == null) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.clear();
    ljz localljz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
    if (localljz != null) {
      localljz.a(paramChatRoomInfo, this.jdField_a_of_type_JavaUtilArrayList);
    }
    paramChatRoomInfo = null;
    if (this.jdField_a_of_type_JavaUtilList != this.b) {
      paramChatRoomInfo = this.b;
    }
    for (;;)
    {
      a(this.jdField_a_of_type_JavaUtilArrayList, paramChatRoomInfo);
      this.jdField_a_of_type_JavaUtilList = paramChatRoomInfo;
      this.jdField_a_of_type_ComTencentAvUiAVActivity.runOnUiThread(new VideoChatRoomUIContoller.3(this));
      return;
      if (this.jdField_a_of_type_JavaUtilList != this.c) {
        paramChatRoomInfo = this.c;
      }
    }
  }
  
  private void a(List<lkb> paramList, List<mne> paramList1)
  {
    if ((paramList == null) || (paramList1 == null)) {
      return;
    }
    String str1 = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.getCurrentAccountUin();
    paramList1.clear();
    paramList = paramList.iterator();
    label31:
    lkb locallkb;
    mne localmne;
    while (paramList.hasNext())
    {
      locallkb = (lkb)paramList.next();
      if (locallkb != null)
      {
        String str2 = String.valueOf(locallkb.jdField_a_of_type_Long);
        localmne = mne.a();
        localmne.b(str2);
        localmne.a(locallkb.jdField_a_of_type_JavaLangString);
        if (!TextUtils.equals(str2, str1)) {
          break label154;
        }
      }
    }
    label154:
    for (int i = 1;; i = 2)
    {
      localmne.a(i);
      localmne.c(String.format("%s|%s", new Object[] { Long.valueOf(locallkb.d), Long.valueOf(locallkb.b) }));
      paramList1.add(localmne);
      break label31;
      break;
    }
  }
  
  private int b()
  {
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null)
    {
      int j = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getWidth();
      int i = j;
      if (j == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.measure(0, 0);
        i = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getMeasuredWidth();
      }
      return i;
    }
    return 0;
  }
  
  private void b()
  {
    if (!this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a(1)) {
      this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiGuideGuideHelper.a();
    }
  }
  
  private void d(int paramInt)
  {
    lff locallff = lcb.a().a();
    if ((locallff.B) || (locallff.J)) {
      if (QLog.isDevelopLevel()) {
        QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel can not show when recording.");
      }
    }
    Object localObject;
    do
    {
      do
      {
        return;
        localObject = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoControlUI;
      } while (localObject == null);
      if ((this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) || (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() != 0)) {
        break;
      }
    } while (!QLog.isDevelopLevel());
    QLog.i("VideoChatRoomUIContoller", 4, "ChatRoomPanel has already show");
    return;
    if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer = a();
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(0);
    b();
    if (paramInt == 2)
    {
      ObjectAnimator localObjectAnimator1 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { b(), 0.0F });
      ObjectAnimator localObjectAnimator2 = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 0.0F, 1.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObjectAnimator1, localObjectAnimator2 });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.start();
    }
    for (;;)
    {
      b(((VideoControlUI)localObject).b());
      a();
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null)
      {
        localObject = ((ljz)localObject).a(locallff, true);
        if (QLog.isColorLevel()) {
          QLog.i("ChatRoomUtil", 2, String.format("showChatRoomPanelWithAnimation, session[%s], chat_room[%s]", new Object[] { locallff, localObject }));
        }
        a((ChatRoomInfo)localObject);
      }
      lkd.a("0X800A8D3");
      return;
      if (paramInt == 0)
      {
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setTranslationX(0.0F);
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setAlpha(1.0F);
      }
    }
  }
  
  public int a()
  {
    int i = 0;
    if (a()) {
      i = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a();
    }
    return i;
  }
  
  public void a()
  {
    if (a()) {
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI, this.jdField_a_of_type_ComTencentAvUiAVActivity.c());
    }
  }
  
  public void a(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("VideoChatRoomUIContoller", 4, "showChatRoomPanel, which[" + paramInt + "]");
    }
    d(paramInt);
  }
  
  public void a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {}
    ljz localljz;
    ChatRoomInfo localChatRoomInfo;
    do
    {
      do
      {
        return;
        localljz = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      } while (localljz == null);
      localChatRoomInfo = localljz.a(lcb.a().a(), true);
    } while (localChatRoomInfo == null);
    localljz.a(localChatRoomInfo, paramString, System.currentTimeMillis());
  }
  
  public void a(boolean paramBoolean)
  {
    int i = 0;
    Object localObject;
    if (!paramBoolean)
    {
      lcb.a().a().aC = a();
      localObject = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localObject != null) {
        ((ljz)localObject).b(this.jdField_a_of_type_Mnj);
      }
      this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.b(this.jdField_a_of_type_Mnk);
      if (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer == null) {
        break label114;
      }
      localObject = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a;
      label65:
      if (localObject == null) {
        break label129;
      }
      localObject = ((EditText)localObject).getText();
      if (localObject != null) {
        break label119;
      }
      localObject = null;
    }
    for (;;)
    {
      if ((localObject == null) || (i >= localObject.length)) {
        break label129;
      }
      localObject[i] = null;
      i += 1;
      continue;
      lcb.a().a().aC = false;
      break;
      label114:
      localObject = null;
      break label65;
      label119:
      localObject = ((Editable)localObject).getFilters();
    }
    label129:
    if (QLog.isColorLevel()) {
      QLog.i("ChatRoomUtil", 2, "VideoChatRoomUIContoller-destroy, isQuit[" + paramBoolean + "], mCheckFirstShowChatRoomPanel[" + lcb.a().a().aC + "]");
    }
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null) && (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.getVisibility() == 0);
  }
  
  public void b(int paramInt)
  {
    if (a())
    {
      if (this.jdField_a_of_type_ComTencentAvUiAVActivity.c() != 4) {
        break label144;
      }
      lff locallff = null;
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      if (localVideoController != null) {
        locallff = localVideoController.a();
      }
      if ((locallff == null) || (!locallff.m()) || (!locallff.t())) {
        break label144;
      }
    }
    label144:
    for (int i = this.jdField_a_of_type_ComTencentAvUiAVActivity.jdField_a_of_type_ComTencentAvUiVideoLayerUI.k + paramInt + this.jdField_a_of_type_ComTencentAvUiAVActivity.getResources().getDimensionPixelSize(2131297594);; i = paramInt)
    {
      if (QLog.isDevelopLevel()) {
        QLog.i("ChatRoomUtil", 4, String.format("updateChatRoomPanel, [%s --> %s], layoutMode[%s]", new Object[] { Integer.valueOf(paramInt), Integer.valueOf(i), Integer.valueOf(this.jdField_a_of_type_ComTencentAvUiAVActivity.c()) }));
      }
      this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a(i);
      return;
    }
  }
  
  public boolean b()
  {
    return (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer != null) && (this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.c());
  }
  
  public void c(int paramInt)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("ChatRoomUtil", 4, "hideChatRoomPanel, from[" + paramInt + "]");
    }
    Object localObject;
    if (a())
    {
      if (paramInt == 2)
      {
        localObject = new AlphaAnimation(1.0F, 0.0F);
        ((AlphaAnimation)localObject).setDuration(300L);
        ((AlphaAnimation)localObject).setAnimationListener(new mnh(this));
        this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.startAnimation((Animation)localObject);
      }
    }
    else {
      return;
    }
    if (paramInt == 1)
    {
      localObject = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "TranslationX", new float[] { 0.0F, b() });
      ObjectAnimator localObjectAnimator = ObjectAnimator.ofFloat(this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer, "alpha", new float[] { 1.0F, 0.0F });
      AnimatorSet localAnimatorSet = new AnimatorSet();
      localAnimatorSet.playTogether(new Animator[] { localObject, localObjectAnimator });
      localAnimatorSet.setDuration(300L);
      localAnimatorSet.addListener(new mni(this));
      localAnimatorSet.start();
      return;
    }
    this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.setVisibility(8);
  }
  
  public boolean c()
  {
    boolean bool = false;
    if (a()) {
      bool = this.jdField_a_of_type_ComTencentAvUiChatroomVideoChatRoomContainer.a();
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     mng
 * JD-Core Version:    0.7.0.1
 */