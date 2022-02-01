import android.os.Handler;
import com.tencent.av.AVFunChat.AVFunChatMessage;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.support.SupportFace.1;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;

public class lic
  extends lia
{
  private boolean a;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private int f = -1;
  
  public lic(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
  }
  
  private boolean a()
  {
    return loz.c();
  }
  
  private boolean b()
  {
    return loz.d();
  }
  
  private boolean c()
  {
    return loz.f();
  }
  
  private boolean d()
  {
    return loz.d();
  }
  
  public int a(String paramString)
  {
    if ("normal".equalsIgnoreCase(paramString)) {
      return this.c;
    }
    if ("interact".equalsIgnoreCase(paramString)) {
      return this.d;
    }
    if ("SUPPORT_SWITCH_FACE".equalsIgnoreCase(paramString)) {
      return this.e;
    }
    if ("creative".equalsIgnoreCase(paramString)) {
      return this.f;
    }
    return -1;
  }
  
  public boolean a(int paramInt, String paramString)
  {
    if (!this.jdField_a_of_type_Boolean) {
      bjda.a().postDelayed(new SupportFace.1(this), 1100L);
    }
    lbc.c("SupportFace", "onReceiveSupportMessage type:" + paramInt + "|" + paramString);
    if (paramString != null)
    {
      if (!paramString.equals("SUPPORT_TRUE")) {
        break label122;
      }
      if (paramInt != 1) {
        break label83;
      }
      this.c = 1;
    }
    label83:
    label122:
    do
    {
      return false;
      if (paramInt == 3)
      {
        this.c = 1;
        this.d = 1;
        return false;
      }
      if (paramInt == 14)
      {
        this.f = 1;
        lbc.c("SupportFace", "onReceiveSupportMessage  support reason 1:");
        return false;
      }
      return true;
      if (paramString.equals("SUPPORT_FALSE"))
      {
        if (paramInt == 1)
        {
          this.c = 0;
          this.d = 0;
        }
        for (;;)
        {
          return true;
          if (paramInt == 3)
          {
            this.d = 0;
          }
          else if (paramInt == 14)
          {
            this.f = 0;
            lbc.c("SupportFace", "onReceiveSupportMessage not support reason 1:");
          }
        }
      }
      if (paramString.equals("SUPPORT_SWITCH_FACE"))
      {
        if (paramInt == 3) {
          this.e = 1;
        }
        return true;
      }
      if (paramString.equals("SUPPORT_CREATIVECOP_TRUE"))
      {
        if (paramInt == 14)
        {
          this.f = 1;
          lbc.c("SupportFace", "onReceiveSupportMessage  support reason 2:");
        }
        return true;
      }
    } while (!paramString.equals("SUPPORT_CREATIVECOP_FALSE"));
    if (paramInt == 14)
    {
      this.f = 0;
      lbc.c("SupportFace", "onReceiveSupportMessage  not support reason 2:");
    }
    return true;
  }
  
  public boolean a(String paramString)
  {
    boolean bool = false;
    lbc.d("SupportFace", String.format("isSelfSupport| device info:mode=%s,sdkVersion=%d,cpuFreq=%d,cpuCount=%d,memCapacity=%d", new Object[] { this.jdField_a_of_type_JavaLangString, Integer.valueOf(this.jdField_a_of_type_Int), Long.valueOf(this.jdField_a_of_type_Long), Integer.valueOf(this.jdField_b_of_type_Int), Long.valueOf(this.jdField_b_of_type_Long) }));
    if ("normal".equalsIgnoreCase(paramString)) {
      bool = a();
    }
    do
    {
      return bool;
      if ("interact".equalsIgnoreCase(paramString)) {
        return b();
      }
      if ("SUPPORT_SWITCH_FACE".equalsIgnoreCase(paramString)) {
        return d();
      }
    } while (!"creative".equalsIgnoreCase(paramString));
    return c();
  }
  
  public void b()
  {
    boolean bool2 = lid.b();
    if (bnpy.a(bnpt.c) == 1) {}
    boolean bool3;
    boolean bool4;
    boolean bool5;
    boolean bool6;
    for (boolean bool1 = true;; bool1 = false)
    {
      VideoController localVideoController = this.jdField_a_of_type_ComTencentAvAppVideoAppInterface.a();
      bool3 = a();
      if ((bool3) && (bool2)) {
        localVideoController.a(1, "SUPPORT_TRUE");
      }
      bool4 = d();
      if ((bool4) && (bool2)) {
        localVideoController.a(3, "SUPPORT_SWITCH_FACE");
      }
      bool5 = b();
      if ((bool5) && (bool2)) {
        localVideoController.a(3, "SUPPORT_TRUE");
      }
      bool6 = c();
      if ((bool6) && (bool1))
      {
        AVFunChat.AVFunChatMessage localAVFunChatMessage = new AVFunChat.AVFunChatMessage();
        localAVFunChatMessage.uint64_type.set(14L);
        localAVFunChatMessage.enum_operator.set(1);
        localAVFunChatMessage.str_msg.set("SUPPORT_CREATIVECOP_TRUE");
        localVideoController.a(14, localAVFunChatMessage);
      }
      if ((!bool3) || (!bool4) || (!bool5) || (!bool6)) {
        break;
      }
      return;
    }
    QLog.w("SupportFace", 1, "sendSupportMsg, normal[" + bool3 + "], switchfaceStandard[" + bool4 + "], interact[" + bool5 + "], creativePendant[" + bool6 + "], isSOExist[" + bool2 + "],isPagSoExist[" + bool1 + "]");
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.c = -1;
    this.d = -1;
    this.e = -1;
    this.f = -1;
    lbc.c("SupportFace", "SupportFace restore:");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     lic
 * JD-Core Version:    0.7.0.1
 */