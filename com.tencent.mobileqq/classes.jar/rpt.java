import com.tencent.qphone.base.util.QLog;

public class rpt
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public rpu a;
  public rpv a;
  public rpw a;
  public boolean a;
  public int b;
  public long b;
  public String b;
  public int c;
  public long c;
  public String c;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  public String f;
  public int g;
  public String g;
  public String h;
  public String i;
  public String j;
  public String k;
  
  public Object clone()
  {
    try
    {
      localrpt = (rpt)super.clone();
      QLog.e("NewPolymericInfo", 2, "PackArticleInfo item clone failed. exception = " + localCloneNotSupportedException1);
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        if (this.jdField_a_of_type_Rpw != null) {
          localrpt.jdField_a_of_type_Rpw = ((rpw)this.jdField_a_of_type_Rpw.clone());
        }
        if (this.jdField_a_of_type_Rpv != null) {
          localrpt.jdField_a_of_type_Rpv = ((rpv)this.jdField_a_of_type_Rpv.clone());
        }
        if (this.jdField_a_of_type_Rpu != null) {
          localrpt.jdField_a_of_type_Rpu = ((rpu)this.jdField_a_of_type_Rpu.clone());
        }
        return localrpt;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2)
      {
        rpt localrpt;
        break label76;
      }
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      localrpt = null;
    }
    label76:
    return localrpt;
  }
  
  public String toString()
  {
    return "PackArticleInfo = {\ncellStyleID = " + this.i + "\narticleID = " + this.jdField_a_of_type_Long + "\narticleTitle = " + this.jdField_a_of_type_JavaLangString + "\narticleSummary = " + this.jdField_b_of_type_JavaLangString + "\nfirstPagePicUrl = " + this.jdField_c_of_type_JavaLangString + "\narticleContentUrl = " + this.jdField_d_of_type_JavaLangString + "\nsubscribeID = " + this.jdField_e_of_type_JavaLangString + "\nsubscribeName = " + this.jdField_f_of_type_JavaLangString + "\nstrategyID = " + this.jdField_a_of_type_Int + "\nalgorithmID = " + this.jdField_b_of_type_Long + "\nfeedsID = " + this.jdField_c_of_type_Long + "\nfeedsType = " + this.jdField_b_of_type_Int + "\ninnerUniqID = " + this.jdField_g_of_type_JavaLangString + "\nisGallery = " + this.jdField_c_of_type_Int + "\ngalleryPicNum = " + this.jdField_d_of_type_Int + "\nvideoInfo = " + this.jdField_a_of_type_Rpw + "\nbuttonWording = " + this.h + "\nisUgc = " + this.jdField_a_of_type_Boolean + "\nplayCount=" + this.jdField_f_of_type_Int + "commentCount=" + this.jdField_g_of_type_Int + "isGifCoverUrl = " + this.jdField_e_of_type_Int + "\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rpt
 * JD-Core Version:    0.7.0.1
 */