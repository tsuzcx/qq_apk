import com.tencent.av.opengl.GraphicRenderMgr;
import com.tencent.avgame.app.AVGameAppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

public class nnu
  extends lpf
{
  private final int jdField_a_of_type_Int;
  private final lov jdField_a_of_type_Lov = new lov();
  private final WeakReference<lbj> jdField_a_of_type_MqqUtilWeakReference;
  private boolean jdField_a_of_type_Boolean;
  private boolean b = true;
  
  public nnu(lbj paramlbj)
  {
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramlbj);
    this.jdField_a_of_type_AndroidContentContext = BaseApplicationImpl.getContext();
    this.jdField_a_of_type_Lov.a("BEAUTY_SKIN", 60);
    this.jdField_a_of_type_Lpl = new lpl(this.jdField_a_of_type_AndroidContentContext, null, this.jdField_a_of_type_Lov);
    int i = nqm.a();
    if (i == 3) {}
    for (this.jdField_a_of_type_Int = 0;; this.jdField_a_of_type_Int = 1)
    {
      this.jdField_a_of_type_Boolean = GraphicRenderMgr.soloadedPTV;
      if (QLog.isColorLevel()) {
        QLog.i("AVGameEffectCtrl", 2, "AVGameEffectCtrl, line[" + i + "], mode[" + this.jdField_a_of_type_Int + "], PtvSoReady[" + this.jdField_a_of_type_Boolean + "]");
      }
      return;
    }
  }
  
  public int a()
  {
    return 0;
  }
  
  public void a(int paramInt) {}
  
  protected void a(lox paramlox, lqc paramlqc)
  {
    paramlqc.a();
    if (!paramlqc.c) {
      paramlqc.c = this.jdField_a_of_type_Boolean;
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AVGameEffectCtrl", 2, "destroy, exit[" + paramBoolean + "]");
    }
    d();
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public boolean a(AVGameAppInterface paramAVGameAppInterface)
  {
    if (paramAVGameAppInterface == null) {
      return this.jdField_a_of_type_Boolean;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      paramAVGameAppInterface = paramAVGameAppInterface.a();
      if (paramAVGameAppInterface != null) {
        this.jdField_a_of_type_Boolean = paramAVGameAppInterface.a();
      }
      while (!this.jdField_a_of_type_Boolean)
      {
        QLog.w("AVGameEffectCtrl", 1, "isLoadedSO, load ptv so fail, proxy[" + paramAVGameAppInterface + "]");
        return this.jdField_a_of_type_Boolean;
        g();
      }
    }
    return g();
  }
  
  protected byte[] a(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3, short paramShort1, short paramShort2, short paramShort3, short paramShort4)
  {
    return null;
  }
  
  protected float[] a()
  {
    lbj locallbj = (lbj)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (locallbj != null) {
      return locallbj.a();
    }
    return null;
  }
  
  protected int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public void b(int paramInt) {}
  
  public boolean f()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean g()
  {
    boolean bool2;
    if (!GraphicRenderMgr.soloadedPTV)
    {
      GraphicRenderMgr.loadPtuSO();
      QLog.w("AVGameEffectCtrl", 1, "isLoadedSO, loadPtvSoRet[" + GraphicRenderMgr.soloadedPTV + "]");
      bool2 = GraphicRenderMgr.soloadedPTV;
      bool1 = bool2;
      if (bool2)
      {
        this.jdField_a_of_type_Boolean = true;
        b();
      }
    }
    for (boolean bool1 = bool2;; bool1 = true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("AVGameEffectCtrl", 2, "loadPtvSo, ret[" + bool1 + "]");
      }
      return bool1;
      this.jdField_a_of_type_Boolean = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     nnu
 * JD-Core Version:    0.7.0.1
 */