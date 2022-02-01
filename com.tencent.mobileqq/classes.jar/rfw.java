import com.tencent.qphone.base.util.QLog;

public class rfw
  implements Cloneable
{
  public int a;
  public long a;
  public String a;
  public rfx a;
  public rfy a;
  public rfz a;
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
      localrfw = (rfw)super.clone();
      QLog.e("NewPolymericInfo", 2, "PackArticleInfo item clone failed. exception = " + localCloneNotSupportedException1);
    }
    catch (CloneNotSupportedException localCloneNotSupportedException1)
    {
      try
      {
        if (this.jdField_a_of_type_Rfz != null) {
          localrfw.jdField_a_of_type_Rfz = ((rfz)this.jdField_a_of_type_Rfz.clone());
        }
        if (this.jdField_a_of_type_Rfy != null) {
          localrfw.jdField_a_of_type_Rfy = ((rfy)this.jdField_a_of_type_Rfy.clone());
        }
        if (this.jdField_a_of_type_Rfx != null) {
          localrfw.jdField_a_of_type_Rfx = ((rfx)this.jdField_a_of_type_Rfx.clone());
        }
        return localrfw;
      }
      catch (CloneNotSupportedException localCloneNotSupportedException2)
      {
        rfw localrfw;
        break label76;
      }
      localCloneNotSupportedException1 = localCloneNotSupportedException1;
      localrfw = null;
    }
    label76:
    return localrfw;
  }
  
  public String toString()
  {
    return "PackArticleInfo = {\ncellStyleID = " + this.i + "\narticleID = " + this.jdField_a_of_type_Long + "\narticleTitle = " + this.jdField_a_of_type_JavaLangString + "\narticleSummary = " + this.jdField_b_of_type_JavaLangString + "\nfirstPagePicUrl = " + this.jdField_c_of_type_JavaLangString + "\narticleContentUrl = " + this.jdField_d_of_type_JavaLangString + "\nsubscribeID = " + this.jdField_e_of_type_JavaLangString + "\nsubscribeName = " + this.jdField_f_of_type_JavaLangString + "\nstrategyID = " + this.jdField_a_of_type_Int + "\nalgorithmID = " + this.jdField_b_of_type_Long + "\nfeedsID = " + this.jdField_c_of_type_Long + "\nfeedsType = " + this.jdField_b_of_type_Int + "\ninnerUniqID = " + this.jdField_g_of_type_JavaLangString + "\nisGallery = " + this.jdField_c_of_type_Int + "\ngalleryPicNum = " + this.jdField_d_of_type_Int + "\nvideoInfo = " + this.jdField_a_of_type_Rfz + "\nbuttonWording = " + this.h + "\nisUgc = " + this.jdField_a_of_type_Boolean + "\nplayCount=" + this.jdField_f_of_type_Int + "commentCount=" + this.jdField_g_of_type_Int + "isGifCoverUrl = " + this.jdField_e_of_type_Int + "\n";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rfw
 * JD-Core Version:    0.7.0.1
 */