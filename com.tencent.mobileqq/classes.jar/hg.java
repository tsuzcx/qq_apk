import android.graphics.Rect;
import android.util.SparseArray;
import com.etrump.mixlayout.ETTextView;
import com.tencent.qphone.base.util.QLog;

public class hg
{
  private SparseArray<Rect> jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  private ETTextView jdField_a_of_type_ComEtrumpMixlayoutETTextView;
  private ha jdField_a_of_type_Ha;
  private int[] jdField_a_of_type_ArrayOfInt = new int[2];
  
  public hg(ETTextView paramETTextView, ha paramha)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView = paramETTextView;
    this.jdField_a_of_type_Ha = paramha;
  }
  
  public int a(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(this.jdField_a_of_type_ArrayOfInt);
    return this.jdField_a_of_type_Ha.a(paramInt1 - this.jdField_a_of_type_ArrayOfInt[0] - this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), paramInt2 - this.jdField_a_of_type_ArrayOfInt[1] - this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
  }
  
  public SparseArray<Rect> a()
  {
    return this.jdField_a_of_type_AndroidUtilSparseArray;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt2 < 0)) {}
    hf localhf1;
    hf localhf2;
    do
    {
      return;
      localhf1 = this.jdField_a_of_type_Ha.a(paramInt1);
      localhf2 = this.jdField_a_of_type_Ha.a(paramInt2);
    } while ((localhf1 == null) || (localhf2 == null));
    this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    Rect localRect1;
    if (localhf1.jdField_a_of_type_Int == localhf2.jdField_a_of_type_Int)
    {
      localRect1 = new Rect();
      if (localhf2.jdField_a_of_type_AndroidGraphicsRect.left >= localhf1.jdField_a_of_type_AndroidGraphicsRect.left) {
        localRect1.set(localhf1.jdField_a_of_type_AndroidGraphicsRect.left, localhf1.jdField_a_of_type_AndroidGraphicsRect.top, localhf2.jdField_a_of_type_AndroidGraphicsRect.right, localhf2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      for (;;)
      {
        localRect1.offset(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
        this.jdField_a_of_type_AndroidUtilSparseArray.append(localhf2.jdField_a_of_type_Int, localRect1);
        this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.invalidate();
        return;
        localRect1.set(localhf2.jdField_a_of_type_AndroidGraphicsRect.left, localhf2.jdField_a_of_type_AndroidGraphicsRect.top, localhf1.jdField_a_of_type_AndroidGraphicsRect.left, localhf1.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
    }
    int i = localhf1.jdField_a_of_type_Int;
    int j = localhf2.jdField_a_of_type_Int;
    paramInt2 = j;
    paramInt1 = i;
    if (i > j)
    {
      paramInt1 = localhf2.jdField_a_of_type_Int;
      paramInt2 = localhf1.jdField_a_of_type_Int;
    }
    i = paramInt1;
    label243:
    Rect localRect2;
    if (i <= paramInt2)
    {
      localRect1 = new Rect();
      localRect2 = this.jdField_a_of_type_Ha.a(i);
      if (localRect2 == null)
      {
        QLog.e("ETTextSelection", 1, "no lineBound: " + i + " " + this.jdField_a_of_type_Ha.a() + " " + paramInt1 + " " + paramInt2);
        return;
      }
      if (localhf2.jdField_a_of_type_Int <= localhf1.jdField_a_of_type_Int) {
        break label483;
      }
      if (i != paramInt1) {
        break label416;
      }
      localRect1.set(localhf1.jdField_a_of_type_AndroidGraphicsRect.left, localhf1.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
    }
    for (;;)
    {
      localRect1.offset(this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft(), this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop());
      this.jdField_a_of_type_AndroidUtilSparseArray.append(i, localRect1);
      i += 1;
      break label243;
      break;
      label416:
      if (i == paramInt2)
      {
        localRect1.set(localRect2.left, localRect2.top, localhf2.jdField_a_of_type_AndroidGraphicsRect.right, localhf2.jdField_a_of_type_AndroidGraphicsRect.bottom);
      }
      else
      {
        localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        continue;
        label483:
        if (i == paramInt1) {
          localRect1.set(localhf2.jdField_a_of_type_AndroidGraphicsRect.left, localhf2.jdField_a_of_type_AndroidGraphicsRect.top, localRect2.right, localRect2.bottom);
        } else if (i == paramInt2) {
          localRect1.set(localRect2.left, localRect2.top, localhf1.jdField_a_of_type_AndroidGraphicsRect.left, localhf1.jdField_a_of_type_AndroidGraphicsRect.bottom);
        } else {
          localRect1.set(localRect2.left, localRect2.top, localRect2.right, localRect2.bottom);
        }
      }
    }
  }
  
  public void a(int paramInt, int[] paramArrayOfInt, boolean paramBoolean)
  {
    int i = paramInt;
    if (!paramBoolean) {
      i = paramInt - 1;
    }
    hf localhf = this.jdField_a_of_type_Ha.a(i);
    if (localhf == null) {}
    while ((paramArrayOfInt == null) || (paramArrayOfInt.length < 2)) {
      return;
    }
    this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getLocationInWindow(paramArrayOfInt);
    if (paramBoolean)
    {
      paramArrayOfInt[0] += this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft() + localhf.jdField_a_of_type_AndroidGraphicsRect.left;
      paramInt = paramArrayOfInt[1];
      i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
      paramArrayOfInt[1] = (localhf.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
      return;
    }
    paramArrayOfInt[0] += this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingLeft() + localhf.jdField_a_of_type_AndroidGraphicsRect.right;
    paramInt = paramArrayOfInt[1];
    i = this.jdField_a_of_type_ComEtrumpMixlayoutETTextView.getPaddingTop();
    paramArrayOfInt[1] = (localhf.jdField_a_of_type_AndroidGraphicsRect.bottom + i + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     hg
 * JD-Core Version:    0.7.0.1
 */