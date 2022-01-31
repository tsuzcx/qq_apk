import com.tencent.qphone.base.util.QLog;

public class qbr
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public qbs a;
  public qbt a;
  public qbu a;
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
      localqbr = (qbr)super.clone();
      QLog.e("NewPolymericInfo", 2, "PackArticleInfo item clone failed. exception = " + localCloneNotSupportedException1);
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        if (this.jdField_a_of_type_Qbu != null) {
          localqbr.jdField_a_of_type_Qbu = ((qbu)this.jdField_a_of_type_Qbu.clone());
        }
        if (this.jdField_a_of_type_Qbt != null) {
          localqbr.jdField_a_of_type_Qbt = ((qbt)this.jdField_a_of_type_Qbt.clone());
        }
        if (this.jdField_a_of_type_Qbs != null) {
          localqbr.jdField_a_of_type_Qbs = ((qbs)this.jdField_a_of_type_Qbs.clone());
        }
        return localqbr;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2)
      {
        qbr localqbr;
        break label76;
      }
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      localqbr = null;
    }
    label76:
    return localqbr;
  }
  
  public String toString()
  {
    return "PackArticleInfo = {\ncellStyleID = " + this.i + "\narticleID = " + this.jdField_a_of_type_Long + "\narticleTitle = " + this.jdField_a_of_type_JavaLangString + "\narticleSummary = " + this.jdField_b_of_type_JavaLangString + "\nfirstPagePicUrl = " + this.jdField_c_of_type_JavaLangString + "\narticleContentUrl = " + this.jdField_d_of_type_JavaLangString + "\nsubscribeID = " + this.jdField_e_of_type_JavaLangString + "\nsubscribeName = " + this.jdField_f_of_type_JavaLangString + "\nstrategyID = " + this.jdField_a_of_type_Int + "\nalgorithmID = " + this.jdField_b_of_type_Long + "\nfeedsID = " + this.jdField_c_of_type_Long + "\nfeedsType = " + this.jdField_b_of_type_Int + "\ninnerUniqID = " + this.jdField_g_of_type_JavaLangString + "\nisGallery = " + this.jdField_c_of_type_Int + "\ngalleryPicNum = " + this.jdField_d_of_type_Int + "\nvideoInfo = " + this.jdField_a_of_type_Qbu + "\nbuttonWording = " + this.h + "\nisUgc = " + this.jdField_a_of_type_Boolean + "\nplayCount=" + this.jdField_f_of_type_Int + "commentCount=" + this.jdField_g_of_type_Int + "isGifCoverUrl = " + this.jdField_e_of_type_Int + "\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     qbr
 * JD-Core Version:    0.7.0.1
 */