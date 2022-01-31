import android.graphics.Bitmap;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.recent.cur.DragFrameLayout;
import com.tencent.mobileqq.armap.ConversationARMap;
import com.tencent.mobileqq.portal.ConversationHongBao;
import com.tencent.mobileqq.portal.PortalManager;
import com.tencent.mobileqq.portal.PortalManager.PortalShower;
import com.tencent.mobileqq.portal.PortalManager.ResultData;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class sns
  extends PortalManager.PortalShower
{
  private sns(Conversation paramConversation) {}
  
  public void a()
  {
    this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.c();
  }
  
  public void a(int paramInt, PortalManager.ResultData paramResultData)
  {
    PortalManager.a(this.a.a(), paramResultData);
  }
  
  public void a(long paramLong1, int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, Bitmap paramBitmap4, Bitmap paramBitmap5, Bitmap paramBitmap6, Bitmap paramBitmap7, List paramList, String paramString, long paramLong2, boolean paramBoolean, long paramLong3)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.a())) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.c();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.a(paramLong1, paramInt, paramBitmap1, paramBitmap2, paramBitmap3, paramBitmap4, paramBitmap5, paramBitmap6, paramBitmap7, paramList, paramString, paramLong2, paramBoolean, paramLong3);
  }
  
  public void a(long paramLong1, int paramInt1, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3, String paramString1, String paramString2, String paramString3, String paramString4, long paramLong2, boolean paramBoolean, int paramInt2, Bitmap paramBitmap4, Bitmap paramBitmap5, List paramList1, List paramList2, Bitmap paramBitmap6, long paramLong3, Bitmap paramBitmap7, Bitmap paramBitmap8)
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap != null) && (this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.a())) {
      this.a.jdField_a_of_type_ComTencentMobileqqArmapConversationARMap.c();
    }
    this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.a(paramLong1, paramInt1, paramBitmap1, paramBitmap2, paramBitmap3, paramString1, paramString2, paramString3, paramString4, paramLong2, paramBoolean, paramInt2, paramBitmap4, paramBitmap5, paramList1, paramList2, paramBitmap6, paramLong3, paramBitmap7, paramBitmap8);
  }
  
  public void a(boolean paramBoolean, String paramString, PortalManager.ResultData paramResultData)
  {
    this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.a(paramBoolean, paramString, paramResultData);
  }
  
  public boolean a()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.b();
  }
  
  public boolean a(Bitmap paramBitmap, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PortalManager", 2, "showGuide, " + this.a.i + ", " + this.a.g);
    }
    if ((!this.a.i) || (!this.a.g))
    {
      this.a.t = true;
      return false;
    }
    this.a.a(paramBitmap);
    return true;
  }
  
  public void b()
  {
    if ((Conversation.a(this.a) != null) && (Conversation.a(this.a) != null)) {
      Conversation.a(this.a).removeView(Conversation.a(this.a));
    }
  }
  
  public boolean b()
  {
    return this.a.jdField_a_of_type_ComTencentMobileqqPortalConversationHongBao.c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sns
 * JD-Core Version:    0.7.0.1
 */