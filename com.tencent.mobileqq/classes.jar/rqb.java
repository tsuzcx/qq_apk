import android.text.TextUtils;
import android.view.View.OnClickListener;

public class rqb
{
  public int a;
  public long a;
  public View.OnClickListener a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  
  public rqb()
  {
    this.jdField_b_of_type_Int = -1;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_c_of_type_Int = -1;
  }
  
  public boolean equals(Object paramObject)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if ((paramObject instanceof rqb))
    {
      paramObject = (rqb)paramObject;
      bool1 = bool2;
      if (this.jdField_a_of_type_Int == paramObject.jdField_a_of_type_Int)
      {
        bool1 = bool2;
        if (this.d == paramObject.d)
        {
          bool1 = bool2;
          if (this.jdField_b_of_type_Int == paramObject.jdField_b_of_type_Int)
          {
            bool1 = bool2;
            if (this.jdField_a_of_type_Long == paramObject.jdField_a_of_type_Long)
            {
              bool1 = bool2;
              if (this.jdField_c_of_type_Int == paramObject.jdField_c_of_type_Int)
              {
                bool1 = bool2;
                if (TextUtils.equals(this.jdField_b_of_type_JavaLangString, paramObject.jdField_b_of_type_JavaLangString))
                {
                  bool1 = bool2;
                  if (TextUtils.equals(this.jdField_c_of_type_JavaLangString, paramObject.jdField_c_of_type_JavaLangString))
                  {
                    bool1 = bool2;
                    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramObject.jdField_a_of_type_JavaLangString)) {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     rqb
 * JD-Core Version:    0.7.0.1
 */