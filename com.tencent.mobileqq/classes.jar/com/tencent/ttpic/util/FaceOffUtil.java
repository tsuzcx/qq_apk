package com.tencent.ttpic.util;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.bitmap.BitmapUtils;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import com.tencent.ttpic.baseutils.io.FileUtils;
import com.tencent.ttpic.baseutils.log.LogUtils;
import com.tencent.ttpic.openapi.model.FaceItem;
import com.tencent.ttpic.openapi.util.FaceDetectUtil;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class FaceOffUtil
{
  private static final String COORDS_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
  private static final String COORDS_FILE_FACE_COS3D_MASK = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_FACE_HEAD_CROP = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
  private static final String COORDS_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
  private static final String COORDS_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_MASK = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  private static final String COORDS_FILE_NO_EYE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
  public static final Float[] COSMETIC_MODEL_IMAGE_FACEPOINTS;
  public static final int COSMETIC_MODEL_IMAGE_HEIGHT = 1067;
  public static final int COSMETIC_MODEL_IMAGE_WIDTH = 800;
  private static String DEFAULT_BRUSH_POINT;
  private static PointF EMPTY_POINT;
  public static final int[] FaceMeshTriangles;
  public static final int[] FaceMeshTrianglesFaceAverage;
  public static final int[] FaceMeshTrianglesFaceAverageForTypeOne;
  public static final int[] FaceMeshTriangles_v2;
  public static String GRAY_CRAZY_SKIN_MERGE_MASK_NAME;
  private static String GRAY_FILE_CRAZY_FACE;
  private static String GRAY_FILE_CROP_HEAD_FACE;
  private static String GRAY_FILE_FACE_COS3D_MASK;
  private static String GRAY_FILE_FACE_SKIN;
  private static String GRAY_FILE_HAS_EYE;
  private static String GRAY_FILE_MASK;
  private static String GRAY_FILE_NOSE_MASK;
  private static String GRAY_FILE_NO_EYE;
  public static final int IRIS_TRIANGLE_COUNT = 8;
  public static final int[] IrisMeshTriangles = { 0, 1, 2, 0, 2, 3, 0, 3, 4, 0, 4, 1, 5, 6, 7, 5, 7, 8, 5, 8, 9, 5, 9, 6 };
  public static final int NO_HOLE_TRIANGLE_COUNT = 230;
  public static final int NO_HOLE_TRIANGLE_COUNT_FACE_AVERAGE = 184;
  public static final int NO_HOLE_TRIANGLE_COUNT_V2;
  public static final int NO_HOLE_VERTEX_COUNT_V2 = 135;
  public static int[] Select3DIndices = { 3059, 3088, 3089, 2331, 383, 5940, 389, 293, 5858, 5129, 5128, 1069, 1165, 5154, 1536, 5517, 4612, 4603, 5507, 604, 2762, 2765, 2764, 598, 667, 670, 671, 5382, 1377, 1376, 4352, 1374, 1443, 4494, 4497, 2824, 2821, 6192, 2838, 6131, 5989, 2813, 2808, -43, -44, 4408, 5411, 5409, 5407, 5340, 5260, 4397, 4393, -53, -54, 2692, 1941, 256, 5786, 4917, 3576, 3665, 3528, 4281, 3519, 5624, 4793, 323, 5903, 5021, 5061, 3797, 4782, 4781, 1671, 5654, 1704, 4796, 3281, 863, 3335, 1778, 1740 };
  private static final String TAG = FaceOffUtil.class.getSimpleName();
  private static Bitmap crazySkinMergeBitmap;
  public static final int[] faceMeshNoseLastTriangles;
  
  static
  {
    GRAY_FILE_NO_EYE = "assets://camera/camera_video/faceOff/grayImages/nomouthgray.png";
    GRAY_FILE_HAS_EYE = "assets://camera/camera_video/faceOff/grayImages/noeyegray.png";
    GRAY_FILE_CRAZY_FACE = "assets://camera/camera_video/faceOff/grayImages/crazyfacegray.png";
    GRAY_FILE_CROP_HEAD_FACE = "assets://camera/camera_video/faceOff/grayImages/faceheadcropgray.png";
    GRAY_FILE_FACE_SKIN = "assets://camera/camera_video/faceOff/grayImages/faceMask_skin.png";
    GRAY_FILE_MASK = "assets://camera/camera_video/faceOff/grayImages/faceoffmask.png";
    GRAY_FILE_FACE_COS3D_MASK = "assets://camera/camera_video/faceOff/grayImages/faceMaskCos3D.png";
    GRAY_FILE_NOSE_MASK = "assets://camera/camera_video/faceOff/grayImages/faceoffnose.png";
    DEFAULT_BRUSH_POINT = "assets://camera/camera_video/defaultmask/default_brush_point.png";
    GRAY_CRAZY_SKIN_MERGE_MASK_NAME = "defaultMaskImage.jpg";
    EMPTY_POINT = new PointF();
    COSMETIC_MODEL_IMAGE_FACEPOINTS = new Float[] { Float.valueOf(156.88185F), Float.valueOf(528.13641F), Float.valueOf(169.54933F), Float.valueOf(595.37152F), Float.valueOf(181.24239F), Float.valueOf(649.93909F), Float.valueOf(191.96103F), Float.valueOf(695.73688F), Float.valueOf(214.37271F), Float.valueOf(738.61145F), Float.valueOf(238.73325F), Float.valueOf(776.61389F), Float.valueOf(277.71011F), Float.valueOf(811.69305F), Float.valueOf(311.81485F), Float.valueOf(843.84894F), Float.valueOf(351.76614F), Float.valueOf(868.20947F), Float.valueOf(398.53836F), Float.valueOf(876.97931F), Float.valueOf(445.31061F), Float.valueOf(866.26068F), Float.valueOf(491.1084F), Float.valueOf(841.90015F), Float.valueOf(528.13641F), Float.valueOf(807.79535F), Float.valueOf(558.34351F), Float.valueOf(769.79291F), Float.valueOf(585.62726F), Float.valueOf(734.71375F), Float.valueOf(605.11572F), Float.valueOf(690.86481F), Float.valueOf(618.75763F), Float.valueOf(645.06702F), Float.valueOf(630.45068F), Float.valueOf(592.44824F), Float.valueOf(633.37396F), Float.valueOf(524.23871F), Float.valueOf(199.75639F), Float.valueOf(446.285F), Float.valueOf(239.70767F), Float.valueOf(444.33618F), Float.valueOf(280.63336F), Float.valueOf(448.23386F), Float.valueOf(321.55908F), Float.valueOf(456.02924F), Float.valueOf(362.48477F), Float.valueOf(458.95248F), Float.valueOf(327.40561F), Float.valueOf(433.61755F), Float.valueOf(283.55664F), Float.valueOf(425.82217F), Float.valueOf(239.70767F), Float.valueOf(425.82217F), Float.valueOf(595.37152F), Float.valueOf(445.31061F), Float.valueOf(555.42023F), Float.valueOf(444.33618F), Float.valueOf(515.46893F), Float.valueOf(452.13156F), Float.valueOf(484.28745F), Float.valueOf(457.00366F), Float.valueOf(438.48965F), Float.valueOf(460.90134F), Float.valueOf(464.79901F), Float.valueOf(435.56638F), Float.valueOf(508.64798F), Float.valueOf(422.8989F), Float.valueOf(559.31793F), Float.valueOf(422.8989F), Float.valueOf(241.65651F), Float.valueOf(506.69916F), Float.valueOf(260.17053F), Float.valueOf(518.39221F), Float.valueOf(285.50549F), Float.valueOf(522.28992F), Float.valueOf(309.86603F), Float.valueOf(520.34106F), Float.valueOf(336.17538F), Float.valueOf(511.57126F), Float.valueOf(317.66138F), Float.valueOf(493.05725F), Float.valueOf(287.45432F), Float.valueOf(483.31302F), Float.valueOf(263.09378F), Float.valueOf(489.15958F), Float.valueOf(291.35202F), Float.valueOf(504.75031F), Float.valueOf(291.35202F), Float.valueOf(502.80145F), Float.valueOf(558.34351F), Float.valueOf(501.82703F), Float.valueOf(537.88062F), Float.valueOf(516.44336F), Float.valueOf(511.57126F), Float.valueOf(523.26428F), Float.valueOf(487.21072F), Float.valueOf(521.31549F), Float.valueOf(460.90134F), Float.valueOf(512.54565F), Float.valueOf(481.3642F), Float.valueOf(492.08282F), Float.valueOf(508.64798F), Float.valueOf(484.28745F), Float.valueOf(534.9574F), Float.valueOf(488.18515F), Float.valueOf(508.64798F), Float.valueOf(502.80145F), Float.valueOf(508.64798F), Float.valueOf(500.85263F), Float.valueOf(370.28015F), Float.valueOf(512.54565F), Float.valueOf(366.38245F), Float.valueOf(600.24359F), Float.valueOf(340.07309F), Float.valueOf(649.93909F), Float.valueOf(370.28015F), Float.valueOf(668.45313F), Float.valueOf(400.48721F), Float.valueOf(672.35077F), Float.valueOf(428.74542F), Float.valueOf(666.50427F), Float.valueOf(458.95248F), Float.valueOf(647.01581F), Float.valueOf(432.64313F), Float.valueOf(601.21802F), Float.valueOf(430.69427F), Float.valueOf(513.52008F), Float.valueOf(400.48721F), Float.valueOf(636.29718F), Float.valueOf(312.78928F), Float.valueOf(719.12305F), Float.valueOf(489.15958F), Float.valueOf(717.17419F), Float.valueOf(335.20099F), Float.valueOf(743.48358F), Float.valueOf(364.43362F), Float.valueOf(759.07428F), Float.valueOf(399.51279F), Float.valueOf(766.86969F), Float.valueOf(434.59195F), Float.valueOf(758.09985F), Float.valueOf(464.79901F), Float.valueOf(741.53473F), Float.valueOf(442.38733F), Float.valueOf(736.6626F), Float.valueOf(401.46164F), Float.valueOf(741.53473F), Float.valueOf(352.74057F), Float.valueOf(736.6626F), Float.valueOf(346.89404F), Float.valueOf(713.27649F), Float.valueOf(379.04993F), Float.valueOf(710.35321F), Float.valueOf(401.46164F), Float.valueOf(714.25092F), Float.valueOf(421.92447F), Float.valueOf(713.27649F), Float.valueOf(454.08038F), Float.valueOf(713.27649F), Float.valueOf(442.38733F), Float.valueOf(729.84167F), Float.valueOf(400.48721F), Float.valueOf(731.79053F), Float.valueOf(354.68939F), Float.valueOf(727.89282F), Float.valueOf(400.48721F), Float.valueOf(512.54565F), Float.valueOf(404.38489F), Float.valueOf(460.90134F), Float.valueOf(400.48721F), Float.valueOf(692.81366F), Float.valueOf(205.60292F), Float.valueOf(205.60292F), Float.valueOf(398.53836F), Float.valueOf(275.76126F), Float.valueOf(598.29474F), Float.valueOf(197.80756F), Float.valueOf(400.48721F), Float.valueOf(356.63824F) };
    FaceMeshTrianglesFaceAverage = new int[] { 0, 1, 35, 1, 35, 36, 35, 36, 42, 20, 35, 42, 19, 20, 35, 19, 20, 26, 19, 26, 96, 19, 90, 96, 26, 95, 96, 25, 26, 95, 21, 25, 26, 20, 21, 26, 20, 21, 42, 21, 41, 42, 41, 42, 43, 36, 42, 43, 36, 37, 43, 36, 37, 57, 2, 36, 57, 2, 3, 57, 3, 4, 65, 4, 5, 65, 5, 65, 67, 5, 6, 67, 6, 7, 67, 7, 67, 68, 7, 8, 68, 8, 68, 69, 68, 69, 73, 68, 73, 74, 67, 68, 74, 65, 67, 74, 65, 75, 82, 57, 58, 75, 58, 75, 76, 75, 76, 82, 65, 74, 82, 74, 81, 82, 73, 74, 81, 70, 72, 73, 69, 70, 73, 10, 69, 70, 9, 10, 69, 8, 9, 69, 10, 11, 70, 12, 13, 71, 13, 66, 71, 13, 14, 66, 14, 15, 66, 60, 61, 79, 59, 60, 64, 59, 60, 78, 59, 77, 78, 76, 77, 81, 59, 76, 77, 58, 59, 76, 58, 59, 64, 56, 58, 64, 56, 57, 58, 37, 38, 43, 38, 40, 43, 38, 39, 40, 38, 39, 56, 39, 55, 56, 23, 39, 55, 56, 62, 64, 47, 61, 62, 46, 47, 61, 15, 16, 61, 17, 45, 46, 17, 18, 45, 27, 28, 45, 28, 45, 52, 28, 29, 52, 29, 51, 52, 29, 50, 51, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 48, 62, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 32, 94, 32, 92, 94, 32, 33, 92, 29, 30, 50, 27, 28, 34, 27, 34, 93, 27, 91, 93, 34, 92, 93, 33, 34, 92, 23, 31, 94, 23, 24, 94, 22, 23, 24, 21, 22, 24, 40, 41, 43, 22, 39, 40, 22, 23, 39, 21, 24, 25, 24, 25, 95, 24, 94, 95, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 79, 80, 66, 71, 72, 70, 71, 72, 60, 78, 79, 1, 2, 36, 95, 96, 99, 92, 93, 105, 91, 104, 105, 14, 103, 104, 11, 102, 103, 7, 101, 102, 4, 100, 101, 90, 99, 100, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 105, 106, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 96, 99, 0, 90, 100, 21, 40, 41, 21, 22, 40, 23, 31, 83, 23, 55, 83, 31, 63, 83, 55, 56, 83, 56, 62, 83, 62, 63, 83, 49, 62, 63, 48, 49, 62, 30, 31, 49, 30, 49, 50, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 52, 53, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 62, 64, 60, 61, 62, 16, 46, 61, 16, 17, 46, 77, 78, 81, 78, 80, 81, 72, 80, 81, 72, 73, 81, 11, 70, 71, 11, 12, 71, 0, 19, 90, 0, 19, 35, 18, 27, 91, 18, 27, 45, 3, 57, 65, 57, 65, 75, 61, 66, 79, 15, 61, 66 };
    FaceMeshTrianglesFaceAverageForTypeOne = new int[] { 0, 35, 1, 1, 35, 36, 35, 42, 36, 20, 42, 35, 19, 20, 35, 19, 26, 20, 19, 96, 26, 19, 90, 96, 26, 96, 95, 25, 26, 95, 21, 26, 25, 20, 26, 21, 20, 21, 42, 21, 41, 42, 41, 43, 42, 36, 42, 43, 36, 43, 37, 36, 37, 57, 2, 36, 57, 2, 57, 3, 3, 65, 4, 4, 65, 5, 5, 65, 67, 5, 67, 6, 6, 67, 7, 7, 67, 68, 7, 68, 8, 8, 68, 69, 68, 73, 69, 68, 74, 73, 67, 74, 68, 65, 74, 67, 65, 75, 82, 57, 58, 75, 58, 76, 75, 75, 76, 82, 65, 82, 74, 74, 82, 81, 73, 74, 81, 70, 73, 72, 69, 73, 70, 10, 69, 70, 9, 69, 10, 8, 69, 9, 10, 70, 11, 12, 71, 13, 13, 71, 66, 13, 66, 14, 14, 66, 15, 60, 61, 79, 59, 64, 60, 59, 60, 78, 59, 78, 77, 76, 77, 81, 59, 77, 76, 58, 59, 76, 58, 64, 59, 56, 64, 58, 56, 58, 57, 37, 43, 38, 38, 43, 40, 38, 40, 39, 38, 39, 56, 39, 55, 56, 23, 55, 39, 56, 62, 64, 47, 61, 62, 46, 61, 47, 15, 61, 16, 17, 46, 45, 17, 45, 18, 27, 45, 28, 28, 45, 52, 28, 52, 29, 29, 52, 51, 30, 51, 50, 50, 51, 53, 48, 50, 53, 48, 49, 50, 31, 49, 63, 47, 62, 48, 47, 48, 53, 45, 46, 52, 51, 52, 53, 30, 31, 32, 31, 94, 32, 32, 94, 92, 32, 92, 33, 29, 51, 30, 27, 28, 34, 27, 34, 93, 27, 93, 91, 34, 92, 93, 33, 92, 34, 23, 94, 31, 23, 24, 94, 22, 24, 23, 21, 24, 22, 40, 43, 41, 22, 40, 41, 22, 23, 40, 21, 25, 24, 24, 25, 95, 24, 95, 94, 76, 81, 82, 78, 79, 80, 66, 72, 80, 66, 80, 79, 66, 71, 72, 70, 72, 71, 60, 79, 78, 1, 36, 2, 95, 96, 99, 92, 105, 93, 91, 105, 104, 14, 104, 103, 11, 103, 102, 7, 102, 101, 4, 101, 100, 90, 100, 99, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 92, 106, 105, 92, 94, 106, 94, 95, 106, 95, 99, 106, 90, 99, 96, 0, 100, 90, 23, 39, 40, 21, 22, 41, 23, 31, 83, 23, 83, 55, 31, 63, 83, 55, 83, 56, 56, 83, 62, 62, 83, 63, 49, 62, 63, 48, 62, 49, 30, 50, 31, 31, 50, 49, 29, 30, 32, 29, 32, 33, 29, 33, 34, 28, 29, 34, 46, 53, 52, 46, 47, 53, 37, 38, 56, 37, 56, 57, 60, 64, 62, 60, 62, 61, 16, 61, 46, 16, 46, 17, 77, 78, 81, 78, 80, 81, 72, 81, 80, 72, 73, 81, 11, 70, 71, 11, 71, 12, 0, 90, 19, 0, 19, 35, 18, 27, 91, 18, 45, 27, 3, 57, 65, 57, 75, 65, 61, 66, 79, 15, 66, 61 };
    FaceMeshTriangles = new int[] { 19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 58, 64, 59, 64, 58, 57, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 61, 64, 62, 64, 61, 60, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 84, 63, 83, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 64, 60, 59, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 83, 56, 55, 56, 83, 62, 64, 57, 56, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 56, 62, 64, 124, 125, 49, 63, 62, 83, 83, 55, 84, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100 };
    faceMeshNoseLastTriangles = new int[] { 19, 118, 111, 118, 19, 20, 7, 67, 68, 67, 7, 6, 1, 0, 111, 56, 109, 114, 109, 56, 57, 2, 1, 109, 69, 8, 68, 8, 69, 9, 3, 2, 107, 58, 76, 75, 76, 58, 59, 4, 3, 107, 65, 75, 82, 65, 67, 74, 65, 82, 74, 5, 4, 107, 67, 6, 5, 109, 107, 2, 107, 109, 57, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 113, 114, 109, 10, 9, 69, 11, 10, 70, 12, 11, 71, 36, 113, 112, 113, 36, 37, 13, 12, 66, 41, 119, 40, 119, 41, 117, 14, 13, 108, 37, 41, 38, 41, 37, 42, 15, 14, 108, 42, 118, 120, 118, 42, 35, 16, 15, 108, 1, 111, 112, 17, 16, 110, 109, 112, 113, 112, 109, 1, 18, 17, 121, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 107, 57, 65, 19, 111, 90, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 121, 17, 122, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 110, 122, 17, 122, 110, 123, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 61, 108, 66, 108, 61, 110, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 71, 11, 70, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 5, 107, 65, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 108, 13, 66, 16, 108, 110, 59, 60, 78, 124, 123, 110, 110, 62, 124, 62, 110, 61, 124, 63, 125, 63, 124, 62, 124, 125, 49, 5, 65, 67, 66, 12, 71, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64 };
    FaceMeshTriangles_v2 = new int[] { 108, 14, 13, 108, 13, 12, 108, 12, 11, 134, 11, 66, 134, 11, 108, 71, 11, 66, 71, 11, 70, 107, 4, 5, 107, 5, 6, 107, 6, 7, 133, 7, 65, 133, 7, 107, 67, 7, 65, 67, 7, 68, 19, 118, 111, 118, 19, 20, 69, 8, 68, 8, 69, 9, 58, 76, 75, 76, 58, 59, 65, 75, 82, 65, 67, 74, 65, 82, 74, 114, 55, 56, 55, 114, 115, 8, 7, 68, 114, 113, 38, 10, 9, 69, 11, 10, 70, 36, 113, 112, 113, 36, 37, 41, 119, 40, 119, 41, 117, 37, 41, 38, 41, 37, 42, 42, 118, 120, 118, 42, 35, 25, 20, 26, 20, 25, 21, 96, 26, 19, 26, 96, 95, 19, 111, 90, 20, 19, 26, 21, 25, 22, 20, 21, 120, 33, 29, 30, 29, 33, 28, 51, 129, 127, 129, 51, 50, 21, 22, 117, 22, 24, 23, 24, 22, 25, 22, 23, 116, 52, 128, 45, 128, 52, 130, 121, 128, 27, 128, 121, 45, 23, 24, 84, 92, 33, 32, 33, 92, 34, 24, 25, 95, 24, 95, 94, 25, 26, 95, 121, 91, 18, 91, 121, 27, 84, 94, 32, 94, 84, 24, 27, 93, 91, 93, 27, 34, 27, 28, 34, 28, 27, 128, 32, 30, 31, 30, 32, 33, 28, 33, 34, 29, 28, 130, 32, 31, 84, 30, 29, 127, 47, 52, 46, 52, 47, 51, 31, 30, 129, 84, 31, 126, 92, 32, 94, 93, 34, 92, 42, 36, 35, 36, 42, 37, 35, 112, 111, 112, 35, 36, 120, 117, 41, 117, 120, 21, 38, 41, 40, 114, 38, 39, 22, 116, 119, 37, 38, 113, 116, 39, 40, 39, 116, 115, 39, 38, 40, 63, 84, 126, 119, 117, 22, 120, 41, 42, 120, 118, 20, 45, 122, 46, 122, 45, 121, 46, 52, 45, 127, 130, 51, 130, 127, 29, 123, 46, 122, 46, 123, 47, 48, 51, 47, 51, 48, 50, 124, 48, 123, 48, 124, 49, 48, 47, 123, 31, 129, 126, 48, 49, 50, 84, 116, 23, 116, 84, 55, 49, 126, 50, 126, 49, 125, 127, 129, 30, 51, 130, 52, 128, 130, 28, 115, 114, 39, 65, 57, 75, 10, 69, 70, 57, 58, 75, 60, 79, 78, 79, 60, 61, 61, 66, 79, 59, 60, 78, 124, 63, 125, 63, 124, 62, 124, 125, 49, 74, 68, 67, 68, 74, 73, 68, 73, 69, 73, 70, 69, 70, 73, 72, 66, 71, 72, 66, 79, 80, 66, 80, 72, 71, 70, 72, 59, 78, 77, 72, 73, 80, 81, 80, 73, 80, 81, 78, 73, 74, 81, 82, 81, 74, 81, 82, 76, 75, 76, 82, 76, 59, 77, 77, 81, 76, 81, 77, 78, 78, 79, 80, 19, 90, 96, 0, 90, 111, 35, 111, 118, 55, 115, 116, 116, 40, 119, 125, 63, 126, 50, 126, 129, 99, 106, 96, 106, 105, 93, 105, 104, 91, 104, 103, 14, 103, 102, 11, 102, 101, 7, 101, 100, 4, 100, 99, 90, 0, 1, 100, 1, 2, 100, 2, 3, 100, 3, 4, 100, 4, 5, 101, 5, 6, 101, 6, 7, 101, 7, 8, 102, 8, 9, 102, 9, 10, 102, 10, 11, 102, 11, 12, 103, 12, 13, 103, 13, 14, 103, 14, 15, 104, 15, 16, 104, 16, 17, 104, 17, 18, 104, 18, 91, 104, 91, 93, 105, 93, 92, 106, 92, 94, 106, 94, 95, 106, 95, 96, 106, 96, 90, 99, 90, 0, 100, 0, 109, 111, 109, 112, 111, 131, 109, 112, 131, 112, 113, 131, 113, 114, 131, 114, 56, 0, 1, 109, 1, 2, 109, 2, 109, 107, 2, 107, 3, 3, 107, 4, 131, 56, 57, 133, 57, 65, 131, 57, 107, 131, 107, 109, 57, 107, 133, 18, 110, 121, 110, 122, 121, 132, 110, 122, 132, 122, 123, 132, 123, 124, 132, 124, 62, 18, 17, 110, 17, 16, 110, 16, 110, 108, 16, 108, 15, 15, 108, 14, 132, 62, 61, 134, 61, 66, 132, 61, 108, 132, 108, 110, 61, 108, 134, 84, 63, 83, 83, 56, 55, 56, 83, 62, 63, 62, 83, 83, 55, 84, 58, 64, 59, 64, 58, 57, 61, 64, 62, 64, 61, 60, 64, 60, 59, 64, 57, 56, 56, 62, 64 };
    NO_HOLE_TRIANGLE_COUNT_V2 = FaceMeshTriangles_v2.length / 3;
  }
  
  private static float[] calcFullProbability_v2(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    PointF localPointF1 = (PointF)paramList.get(64);
    localPointF1 = (PointF)paramList.get(65);
    localPointF1 = (PointF)paramList.get(66);
    localPointF1 = (PointF)paramList.get(54);
    PointF localPointF2 = (PointF)paramList.get(44);
    localPointF1 = new PointF(localPointF1.x - localPointF2.x, localPointF1.y - localPointF2.y);
    localPointF2 = new PointF(-localPointF1.y, localPointF1.x);
    if (localPointF2.y < 0.0F)
    {
      localPointF2.x = (-localPointF2.x);
      localPointF2.y = (-localPointF2.y);
    }
    float f1 = AlgoUtils.getDistance(localPointF1, new PointF(0.0F, 0.0F));
    float f2 = AlgoUtils.getDistance(localPointF2, new PointF(0.0F, 0.0F));
    localPointF1.x /= f1;
    localPointF1.y /= f1;
    localPointF2.x /= f2;
    localPointF2.y /= f2;
    localPointF2 = (PointF)paramList.get(56);
    PointF localPointF3 = (PointF)paramList.get(62);
    PointF localPointF4 = (PointF)paramList.get(17);
    PointF localPointF5 = (PointF)paramList.get(1);
    PointF localPointF6 = (PointF)paramList.get(9);
    paramList = (PointF)paramList.get(87);
    f1 = localPointF1.x;
    f2 = localPointF4.x;
    float f3 = localPointF2.x;
    float f4 = localPointF1.y;
    Math.abs((localPointF4.y - localPointF2.y) * f4 + f1 * (f2 - f3));
    f1 = localPointF1.x;
    f2 = localPointF5.x;
    f3 = localPointF3.x;
    f4 = localPointF1.y;
    f1 = -Math.abs(f1 * (f2 - f3) + (localPointF5.y - localPointF3.y) * f4);
    paramList = new float[''];
    int i = 0;
    while (i < 90)
    {
      paramList[i] = paramArrayOfFloat[i];
      i += 1;
    }
    paramList[90] = paramList[1];
    paramList[91] = paramList[17];
    paramList[92] = 1.0F;
    paramList[93] = 1.0F;
    paramList[94] = 1.0F;
    paramList[95] = 1.0F;
    paramList[96] = 1.0F;
    paramList[97] = 0.0F;
    paramList[98] = 0.0F;
    paramList[99] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[100] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[101] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[102] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[103] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[104] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[105] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[106] = Math.min(Math.min(paramList[44], paramList[54]), paramList[64]);
    paramList[107] = paramList[35];
    paramList[108] = paramList[45];
    paramList[109] = paramList[35];
    paramList[110] = paramList[45];
    paramList[111] = paramList[35];
    paramList[112] = paramList[36];
    paramList[113] = paramList[37];
    paramList[114] = paramList[38];
    paramList[115] = paramList[39];
    paramList[116] = paramList[40];
    paramList[117] = paramList[41];
    paramList[118] = paramList[42];
    paramList[119] = ((paramList[116] + paramList[117]) / 2.0F);
    paramList[120] = ((paramList[117] + paramList[118]) / 2.0F);
    paramList[121] = paramList[45];
    paramList[122] = paramList[46];
    paramList[123] = paramList[47];
    paramList[124] = paramList[48];
    paramList[125] = paramList[49];
    paramList[126] = paramList[50];
    paramList[127] = paramList[51];
    paramList[''] = paramList[52];
    paramList[''] = ((paramList[126] + paramList[127]) / 2.0F);
    paramList[''] = ((paramList[127] + paramList['']) / 2.0F);
    if (paramFloat < 0.0F)
    {
      f2 = 0.7F - (float)(0.2D * Math.cos(paramFloat));
      f1 = -1.5F + (float)(2.0D * Math.cos(paramFloat));
      Math.max(Math.min(f2, 1.0F), 0.0F);
      Math.max(Math.min(f1, 1.0F), 0.0F);
      paramList[''] = paramList[36];
      paramList[''] = paramList[46];
      if (paramFloat >= 0.0F) {
        break label1081;
      }
      f1 = 0.7F - (float)(0.2D * Math.cos(paramFloat));
    }
    for (paramFloat = -1.5F + (float)(2.0D * Math.cos(paramFloat));; paramFloat = 0.7F - (float)(0.2D * Math.cos(paramFloat)))
    {
      Math.max(Math.min(f1, 1.0F), 0.0F);
      Math.max(Math.min(paramFloat, 1.0F), 0.0F);
      paramList[''] = paramList[36];
      paramList[''] = paramList[46];
      return paramList;
      f2 = (float)(2.0D * Math.cos(paramFloat)) - 1.5F;
      f1 = 0.7F - (float)(0.2D * Math.cos(paramFloat));
      break;
      label1081:
      f1 = (float)(2.0D * Math.cos(paramFloat)) - 1.5F;
    }
  }
  
  public static List<PointF> genPoints(List<Float> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      localArrayList.add(new PointF(((Float)paramList.get(i * 2)).floatValue(), ((Float)paramList.get(i * 2 + 1)).floatValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  public static List<PointF> genPointsDouble(List<Double> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (CollectionUtils.isEmpty(paramList)) {
      return localArrayList;
    }
    int i = 0;
    while (i < paramList.size() / 2)
    {
      localArrayList.add(new PointF(((Double)paramList.get(i * 2)).floatValue(), ((Double)paramList.get(i * 2 + 1)).floatValue()));
      i += 1;
    }
    return localArrayList;
  }
  
  public static Bitmap getCrazySkinMergeMask(String paramString)
  {
    if (!BitmapUtils.isLegal(crazySkinMergeBitmap))
    {
      paramString = paramString + File.separator + GRAY_CRAZY_SKIN_MERGE_MASK_NAME;
      crazySkinMergeBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), paramString, 1);
    }
    return crazySkinMergeBitmap;
  }
  
  public static void getCropNormalFaceFeature(List<PointF> paramList)
  {
    float f1 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(105));
    float f2 = AlgoUtils.getDistance((PointF)paramList.get(99), (PointF)paramList.get(101));
    int i = (int)(f1 * 1.0F);
    i = (int)(f2 * 1.0F);
    float f3 = 1.0F / f1;
    float f4 = 1.0F / f2;
    i = 0;
    while (i < paramList.size())
    {
      float f5 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(101), f2, (PointF)paramList.get(i));
      float f6 = AlgoUtils.distanceOfPoint2Line((PointF)paramList.get(99), (PointF)paramList.get(105), f1, (PointF)paramList.get(i));
      ((PointF)paramList.get(i)).set(f3 * f5, f4 * f6);
      i += 1;
    }
  }
  
  public static Bitmap getFaceBitmap(String paramString)
  {
    return getFaceBitmap(paramString, 2147483647, 2147483647);
  }
  
  public static Bitmap getFaceBitmap(String paramString, int paramInt1, int paramInt2)
  {
    Object localObject;
    if (paramString == null)
    {
      localObject = null;
      return localObject;
    }
    if (paramString.startsWith("/")) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromFileCheckExif(paramString, paramInt1, paramInt2);; paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString), paramInt1, paramInt2))
    {
      localObject = paramString;
      if (BitmapUtils.isLegal(paramString)) {
        break;
      }
      return null;
    }
  }
  
  public static Bitmap getFaceBitmap(String paramString, FaceItem paramFaceItem)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("assets://"))) {}
    for (paramString = BitmapUtils.decodeSampledBitmapFromAssets(AEModule.getContext(), FileUtils.getRealPath(paramString) + File.separator + paramFaceItem.faceExchangeImage, 2147483647, 2147483647);; paramString = BitmapUtils.decodeSampledBitmapFromFile(paramString + File.separator + paramFaceItem.faceExchangeImage, 2147483647, 2147483647))
    {
      paramFaceItem = paramString;
      if (!BitmapUtils.isLegal(paramString)) {
        paramFaceItem = null;
      }
      return paramFaceItem;
    }
  }
  
  public static FaceOffUtil.FEATURE_TYPE getFeatureType(int paramInt)
  {
    FaceOffUtil.FEATURE_TYPE[] arrayOfFEATURE_TYPE = FaceOffUtil.FEATURE_TYPE.values();
    int j = arrayOfFEATURE_TYPE.length;
    int i = 0;
    while (i < j)
    {
      FaceOffUtil.FEATURE_TYPE localFEATURE_TYPE = arrayOfFEATURE_TYPE[i];
      if (localFEATURE_TYPE.value == paramInt) {
        return localFEATURE_TYPE;
      }
      i += 1;
    }
    return FaceOffUtil.FEATURE_TYPE.NO_EYE;
  }
  
  public static List<PointF> getFullCoords(List<PointF> paramList)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramList.size() < 90)) {
      return new ArrayList();
    }
    PointF localPointF3 = (PointF)paramList.get(83);
    float f1 = ((PointF)paramList.get(9)).x;
    float f2 = ((PointF)paramList.get(83)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    double d1 = Math.atan((f1 - f2) / (((PointF)paramList.get(83)).y + f3));
    f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
    PointF localPointF1 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(d1)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(d1)));
    paramList.add(localPointF1);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
    PointF localPointF2 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(d1)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(d1)));
    paramList.add(localPointF2);
    f1 = (float)(AlgoUtils.getDistance((PointF)paramList.get(59), localPointF3) * 1.2D);
    localPointF3 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(d1)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(d1)));
    int i = 2;
    double d2;
    double d3;
    while (i >= 1)
    {
      d1 = Math.toRadians(i * 30.0F);
      PointF localPointF4 = new PointF();
      localPointF4.x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(d1)));
      d2 = localPointF2.y;
      d3 = localPointF2.y - localPointF3.y;
      localPointF4.y = ((float)(d2 - Math.sin(d1) * d3));
      paramList.add(localPointF4);
      i -= 1;
    }
    i = 3;
    while (i >= 1)
    {
      d1 = Math.toRadians(i * 30.0F);
      localPointF2 = new PointF();
      localPointF2.x = ((float)(localPointF3.x - (localPointF3.x - localPointF1.x) * Math.cos(d1)));
      d2 = localPointF1.y;
      d3 = localPointF1.y - localPointF3.y;
      localPointF2.y = ((float)(d2 - Math.sin(d1) * d3));
      paramList.add(localPointF2);
      i -= 1;
    }
    paramList.add(EMPTY_POINT);
    paramList.add(EMPTY_POINT);
    localPointF1 = (PointF)paramList.get(64);
    localPointF2 = (PointF)paramList.get(54);
    localPointF3 = (PointF)paramList.get(44);
    localPointF2 = new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y);
    f1 = localPointF2.x;
    f2 = localPointF2.x;
    f3 = localPointF2.y;
    localPointF2 = new PointF(f1 + f2, localPointF2.y + f3);
    localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
    paramList.add(new PointF(localPointF1.x - localPointF2.x - localPointF3.x, localPointF1.y - localPointF2.y - localPointF3.y));
    paramList.add(new PointF(localPointF1.x - localPointF2.x, localPointF1.y - localPointF2.y));
    paramList.add(new PointF(localPointF1.x - localPointF2.x + localPointF3.x, localPointF1.y - localPointF2.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF3.x, localPointF1.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF2.x + localPointF3.x, localPointF1.y + localPointF2.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF2.x, localPointF1.y + localPointF2.y));
    f1 = localPointF1.x;
    f2 = localPointF2.x;
    f3 = localPointF3.x;
    float f4 = localPointF1.y;
    paramList.add(new PointF(f1 + f2 - f3, localPointF2.y + f4 - localPointF3.y));
    paramList.add(new PointF(localPointF1.x - localPointF3.x, localPointF1.y - localPointF3.y));
    localPointF1 = (PointF)paramList.get(3);
    localPointF1 = (PointF)paramList.get(15);
    localPointF1 = (PointF)paramList.get(65);
    localPointF1 = (PointF)paramList.get(66);
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = (PointF)paramList.get(2);
    localPointF1 = (PointF)paramList.get(16);
    localPointF1 = (PointF)paramList.get(39);
    localPointF1 = (PointF)paramList.get(49);
    localPointF1 = (PointF)paramList.get(57);
    localPointF1 = (PointF)paramList.get(61);
    localPointF1 = (PointF)paramList.get(35);
    localPointF1 = (PointF)paramList.get(45);
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = (PointF)paramList.get(37);
    localPointF1 = (PointF)paramList.get(44);
    i = 35;
    float f5;
    while (i < 39)
    {
      localPointF2 = (PointF)paramList.get(i);
      if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
      {
        paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 0.7D)));
        i += 1;
      }
      else
      {
        f3 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
        f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 0.7D);
        f4 = localPointF1.x;
        f5 = localPointF1.y;
        if ((i != 35) || (f2 >= ((PointF)paramList.get(0)).x)) {
          break label2703;
        }
      }
    }
    label2696:
    label2703:
    for (f1 = ((PointF)paramList.get(0)).x;; f1 = f2)
    {
      paramList.add(new PointF(f1, f5 + (f2 - f4) * f3));
      break;
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      int j = paramList.size();
      i = 40;
      if (i < 43)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D) {
          paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 1.2D)));
        }
        for (;;)
        {
          i += 1;
          break;
          f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 1.2D);
          paramList.add(new PointF(f2, f1 * (f2 - localPointF1.x) + localPointF1.y));
        }
      }
      localPointF3 = (PointF)paramList.get(j);
      localPointF1 = (PointF)paramList.get(j + 1);
      localPointF2 = (PointF)paramList.get(j + 2);
      localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
      localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = (PointF)paramList.get(54);
      i = 45;
      while (i < 49)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
        {
          paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 0.7D)));
          i += 1;
        }
        else
        {
          f3 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 0.7D);
          f4 = localPointF1.x;
          f5 = localPointF1.y;
          if ((i != 45) || (f2 <= ((PointF)paramList.get(18)).x)) {
            break label2696;
          }
        }
      }
      for (f1 = ((PointF)paramList.get(18)).x;; f1 = f2)
      {
        paramList.add(new PointF(f1, f5 + (f2 - f4) * f3));
        break;
        localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        j = paramList.size();
        i = 50;
        if (i < 53)
        {
          localPointF2 = (PointF)paramList.get(i);
          if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D) {
            paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 1.2D)));
          }
          for (;;)
          {
            i += 1;
            break;
            f1 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
            f2 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 1.2D);
            paramList.add(new PointF(f2, f1 * (f2 - localPointF1.x) + localPointF1.y));
          }
        }
        localPointF3 = (PointF)paramList.get(j);
        localPointF1 = (PointF)paramList.get(j + 1);
        localPointF2 = (PointF)paramList.get(j + 2);
        localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
        localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
        paramList.add(new PointF(localPointF3.x, localPointF3.y));
        paramList.add(new PointF(localPointF1.x, localPointF1.y));
        return paramList;
      }
    }
  }
  
  public static List<PointF> getFullCoords(List<PointF> paramList, float paramFloat)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramList.size() < 90)) {
      localObject = new ArrayList();
    }
    do
    {
      return localObject;
      if (paramList.size() > 97) {
        paramList.subList(97, paramList.size()).clear();
      }
      if (paramList.size() == 90) {
        break;
      }
      localObject = paramList;
    } while (paramList.size() != 97);
    float f1 = ((PointF)paramList.get(41)).x;
    f1 = (((PointF)paramList.get(51)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(41)).y;
    Object localObject = new PointF(f1, (((PointF)paramList.get(51)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    double d1 = Math.atan2(f1 - f2, f4 + f3) + 3.141592653589793D;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    localMatrix.postRotate((float)Math.toDegrees(-d1));
    localMatrix.postTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    if (paramList.size() == 90)
    {
      f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
      localPointF1 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(0.0D)));
      paramList.add(localPointF1);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
      localPointF3 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(0.0D)));
      paramList.add(localPointF3);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(59), (PointF)localObject);
      localPointF2 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(0.0D)));
      i = 2;
      double d2;
      double d3;
      double d4;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        PointF localPointF4 = new PointF();
        localPointF4.x = ((float)(localPointF2.x - (localPointF2.x - localPointF3.x) * Math.cos(d2)));
        d3 = localPointF3.y;
        d4 = localPointF3.y - localPointF2.y;
        localPointF4.y = ((float)(d3 - Math.sin(d2) * d4));
        paramList.add(localPointF4);
        i -= 1;
      }
      i = 3;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF3 = new PointF();
        localPointF3.x = ((float)(localPointF2.x - (localPointF2.x - localPointF1.x) * Math.cos(d2)));
        d3 = localPointF1.y;
        d4 = localPointF1.y - localPointF2.y;
        localPointF3.y = ((float)(d3 - Math.sin(d2) * d4));
        paramList.add(localPointF3);
        i -= 1;
      }
    }
    paramList.add(EMPTY_POINT);
    paramList.add(EMPTY_POINT);
    PointF localPointF1 = (PointF)paramList.get(64);
    PointF localPointF2 = (PointF)paramList.get(54);
    PointF localPointF3 = (PointF)paramList.get(44);
    localPointF2 = new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y);
    localPointF2 = new PointF(localPointF2.x * paramFloat, localPointF2.y * paramFloat);
    localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
    paramList.add(new PointF(localPointF1.x - localPointF2.x - localPointF3.x, localPointF1.y - localPointF2.y - localPointF3.y));
    paramList.add(new PointF(localPointF1.x - localPointF2.x, localPointF1.y - localPointF2.y));
    paramList.add(new PointF(localPointF1.x - localPointF2.x + localPointF3.x, localPointF1.y - localPointF2.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF3.x, localPointF1.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF2.x + localPointF3.x, localPointF1.y + localPointF2.y + localPointF3.y));
    paramList.add(new PointF(localPointF1.x + localPointF2.x, localPointF1.y + localPointF2.y));
    paramFloat = localPointF1.x;
    f1 = localPointF2.x;
    f2 = localPointF3.x;
    f3 = localPointF1.y;
    paramList.add(new PointF(paramFloat + f1 - f2, localPointF2.y + f3 - localPointF3.y));
    paramList.add(new PointF(localPointF1.x - localPointF3.x, localPointF1.y - localPointF3.y));
    localPointF1 = (PointF)paramList.get(3);
    localPointF1 = (PointF)paramList.get(15);
    localPointF1 = (PointF)paramList.get(65);
    localPointF1 = (PointF)paramList.get(66);
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = (PointF)paramList.get(2);
    localPointF1 = (PointF)paramList.get(16);
    localPointF1 = (PointF)paramList.get(39);
    localPointF1 = (PointF)paramList.get(49);
    localPointF1 = (PointF)paramList.get(57);
    localPointF1 = (PointF)paramList.get(61);
    localPointF1 = (PointF)paramList.get(35);
    localPointF1 = (PointF)paramList.get(45);
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = (PointF)paramList.get(37);
    localPointF1 = (PointF)paramList.get(44);
    int i = 35;
    while (i < 39)
    {
      localPointF2 = (PointF)paramList.get(i);
      if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
      {
        paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 0.7D)));
        i += 1;
      }
      else
      {
        f2 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
        f1 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 0.7D);
        f3 = localPointF1.x;
        f4 = localPointF1.y;
        if ((i != 35) || (f1 >= ((PointF)paramList.get(0)).x)) {
          break label2946;
        }
      }
    }
    label2946:
    for (paramFloat = ((PointF)paramList.get(0)).x;; paramFloat = f1)
    {
      paramList.add(new PointF(paramFloat, f4 + (f1 - f3) * f2));
      break;
      localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF2.x, localPointF2.y));
      int j = paramList.size();
      i = 40;
      if (i < 43)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D) {
          paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 1.2D)));
        }
        for (;;)
        {
          i += 1;
          break;
          paramFloat = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          f1 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 1.2D);
          paramList.add(new PointF(f1, paramFloat * (f1 - localPointF1.x) + localPointF1.y));
        }
      }
      localPointF3 = (PointF)paramList.get(j);
      localPointF1 = (PointF)paramList.get(j + 1);
      localPointF2 = (PointF)paramList.get(j + 2);
      localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
      localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      paramList.add(new PointF(localPointF1.x, localPointF1.y));
      localPointF1 = (PointF)paramList.get(54);
      i = 45;
      while (i < 49)
      {
        localPointF2 = (PointF)paramList.get(i);
        if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D)
        {
          paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 0.7D)));
          i += 1;
        }
        else
        {
          f2 = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
          f1 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 0.7D);
          f3 = localPointF1.x;
          f4 = localPointF1.y;
          if ((i != 45) || (f1 <= ((PointF)paramList.get(18)).x)) {
            break label2940;
          }
        }
      }
      label2940:
      for (paramFloat = ((PointF)paramList.get(18)).x;; paramFloat = f1)
      {
        paramList.add(new PointF(paramFloat, f4 + (f1 - f3) * f2));
        break;
        localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        j = paramList.size();
        i = 50;
        if (i < 53)
        {
          localPointF2 = (PointF)paramList.get(i);
          if (Math.abs(localPointF2.x - localPointF1.x) < 1.0D) {
            paramList.add(new PointF(localPointF2.x, (float)(localPointF2.y + (localPointF2.y - localPointF1.y) * 1.2D)));
          }
          for (;;)
          {
            i += 1;
            break;
            paramFloat = (localPointF2.y - localPointF1.y) / (localPointF2.x - localPointF1.x);
            f1 = (float)(localPointF2.x + (localPointF2.x - localPointF1.x) * 1.2D);
            paramList.add(new PointF(f1, paramFloat * (f1 - localPointF1.x) + localPointF1.y));
          }
        }
        localPointF3 = (PointF)paramList.get(j);
        localPointF1 = (PointF)paramList.get(j + 1);
        localPointF2 = (PointF)paramList.get(j + 2);
        localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
        localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
        paramList.add(new PointF(localPointF3.x, localPointF3.y));
        paramList.add(new PointF(localPointF1.x, localPointF1.y));
        localMatrix.reset();
        localMatrix.postTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
        localMatrix.postRotate((float)Math.toDegrees(d1));
        localMatrix.postTranslate(((PointF)localObject).x, ((PointF)localObject).y);
        return AlgoUtils.mapPoints(paramList, localMatrix);
      }
    }
  }
  
  public static void getFullCoords(Object paramObject1, int paramInt, float paramFloat, Object paramObject2)
  {
    nativeGetFullCoords(paramObject1, paramInt, paramFloat, paramObject2);
  }
  
  public static List<PointF> getFullCoords4BeautyFaceList(List<PointF> paramList, float paramFloat)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramList.size() < 90)) {
      return new ArrayList();
    }
    Object localObject1 = paramList;
    if (paramList.size() > 90) {
      localObject1 = paramList.subList(0, 90);
    }
    PointF localPointF2 = (PointF)((List)localObject1).get(0);
    PointF localPointF8 = (PointF)((List)localObject1).get(1);
    PointF localPointF5 = (PointF)((List)localObject1).get(9);
    PointF localPointF6 = (PointF)((List)localObject1).get(17);
    paramList = (PointF)((List)localObject1).get(18);
    PointF localPointF3 = (PointF)((List)localObject1).get(35);
    PointF localPointF1 = (PointF)((List)localObject1).get(45);
    Object localObject2 = (PointF)((List)localObject1).get(59);
    PointF localPointF4 = (PointF)((List)localObject1).get(83);
    PointF localPointF7 = new PointF(localPointF4.x, localPointF4.y);
    float f3 = localPointF4.x - localPointF5.x;
    float f4 = localPointF4.y - localPointF5.y;
    float f2 = (float)Math.sqrt(f3 * f3 + f4 * f4);
    float f1 = -f4 / f2;
    f2 = f3 / f2;
    f3 = (float)(Math.atan2(f3, f4) + 3.141592653589793D);
    localPointF5 = new PointF();
    f4 = AlgoUtils.getDistance(localPointF2, localPointF8);
    localPointF8.x += 2.0F * f4 * f2;
    localPointF8.y -= f4 * 2.0F * f1;
    ((List)localObject1).add(localPointF5);
    localPointF8 = new PointF();
    f4 = AlgoUtils.getDistance(localPointF6, paramList);
    localPointF6.x += 2.0F * f4 * f2;
    localPointF6.y -= f4 * 2.0F * f1;
    ((List)localObject1).add(localPointF8);
    localPointF6 = new PointF();
    f4 = AlgoUtils.getDistance((PointF)localObject2, localPointF7) * 1.2F;
    localPointF6.x = (f2 * (2.0F * f4) + ((PointF)localObject2).x);
    localPointF6.y = (((PointF)localObject2).y - f4 * 2.0F * f1);
    localObject2 = new Matrix();
    ((Matrix)localObject2).reset();
    ((Matrix)localObject2).postTranslate(-localPointF7.x, -localPointF7.y);
    ((Matrix)localObject2).postRotate((float)Math.toDegrees(-f3));
    ((Matrix)localObject2).postTranslate(localPointF7.x, localPointF7.y);
    int i = 2;
    while (i >= 1)
    {
      f1 = (float)Math.toRadians(i * 30.0F);
      localPointF7 = new PointF();
      f2 = AlgoUtils.getDistance(localPointF6, localPointF4);
      f4 = AlgoUtils.getDistance(localPointF8, localPointF4);
      localPointF7.x = ((float)(localPointF4.x + f4 * Math.cos(f1)));
      localPointF7.y = ((float)(localPointF4.y - f2 * Math.sin(f1)));
      localPointF7 = AlgoUtils.mapPoint(localPointF7, (Matrix)localObject2);
      ((List)localObject1).add(new PointF(localPointF7.x, localPointF7.y));
      i -= 1;
    }
    ((List)localObject1).add(localPointF6);
    i = 2;
    while (i >= 1)
    {
      f1 = (float)Math.toRadians(i * 30.0F);
      localPointF7 = new PointF();
      f2 = AlgoUtils.getDistance(localPointF6, localPointF4);
      f4 = AlgoUtils.getDistance(localPointF5, localPointF4);
      localPointF7.x = ((float)(localPointF4.x - f4 * Math.cos(f1)));
      localPointF7.y = ((float)(localPointF4.y - f2 * Math.sin(f1)));
      localPointF7 = AlgoUtils.mapPoint(localPointF7, (Matrix)localObject2);
      ((List)localObject1).add(new PointF(localPointF7.x, localPointF7.y));
      i -= 1;
    }
    ((List)localObject1).add(new PointF(0.0F, 0.0F));
    ((List)localObject1).add(new PointF(0.0F, 0.0F));
    localPointF4 = (PointF)((List)localObject1).get(64);
    localPointF5 = (PointF)((List)localObject1).get(54);
    localPointF6 = (PointF)((List)localObject1).get(44);
    localPointF5 = new PointF(localPointF5.x - localPointF6.x, localPointF5.y - localPointF6.y);
    localPointF5 = new PointF(localPointF5.x * paramFloat, localPointF5.y * paramFloat);
    localPointF6 = new PointF(-localPointF5.y, localPointF5.x);
    ((List)localObject1).add(new PointF(localPointF4.x - localPointF5.x - localPointF6.x, localPointF4.y - localPointF5.y - localPointF6.y));
    ((List)localObject1).add(new PointF(localPointF4.x - localPointF5.x, localPointF4.y - localPointF5.y));
    ((List)localObject1).add(new PointF(localPointF4.x - localPointF5.x + localPointF6.x, localPointF4.y - localPointF5.y + localPointF6.y));
    ((List)localObject1).add(new PointF(localPointF4.x + localPointF6.x, localPointF4.y + localPointF6.y));
    ((List)localObject1).add(new PointF(localPointF4.x + localPointF5.x + localPointF6.x, localPointF4.y + localPointF5.y + localPointF6.y));
    ((List)localObject1).add(new PointF(localPointF4.x + localPointF5.x, localPointF4.y + localPointF5.y));
    paramFloat = localPointF4.x;
    f1 = localPointF5.x;
    f2 = localPointF6.x;
    f4 = localPointF4.y;
    ((List)localObject1).add(new PointF(paramFloat + f1 - f2, localPointF5.y + f4 - localPointF6.y));
    ((List)localObject1).add(new PointF(localPointF4.x - localPointF6.x, localPointF4.y - localPointF6.y));
    localPointF6 = (PointF)((List)localObject1).get(3);
    localPointF4 = (PointF)((List)localObject1).get(15);
    localPointF7 = (PointF)((List)localObject1).get(65);
    localPointF5 = (PointF)((List)localObject1).get(66);
    localPointF6 = AlgoUtils.middlePoint(localPointF6, localPointF7);
    ((List)localObject1).add(new PointF(localPointF6.x, localPointF6.y));
    localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF5);
    ((List)localObject1).add(new PointF(localPointF4.x, localPointF4.y));
    localPointF5 = (PointF)((List)localObject1).get(39);
    localPointF4 = (PointF)((List)localObject1).get(49);
    localPointF7 = (PointF)((List)localObject1).get(57);
    localPointF6 = (PointF)((List)localObject1).get(61);
    localPointF7 = AlgoUtils.middlePoint(localPointF3, localPointF7);
    ((List)localObject1).add(new PointF(localPointF7.x, localPointF7.y));
    localPointF6 = AlgoUtils.middlePoint(localPointF1, localPointF6);
    ((List)localObject1).add(new PointF(localPointF6.x, localPointF6.y));
    localPointF6 = (PointF)((List)localObject1).get(43);
    localPointF7 = (PointF)((List)localObject1).get(55);
    localPointF8 = (PointF)((List)localObject1).get(41);
    localObject2 = (PointF)((List)localObject1).get(37);
    paramFloat = AlgoUtils.getDistance(localPointF3, localPointF5);
    AlgoUtils.getDistance(localPointF8, (PointF)localObject2);
    f4 = paramFloat / 50.0F;
    i = 35;
    float f5;
    float f6;
    double d1;
    double d2;
    if (i < 39)
    {
      localPointF3 = (PointF)((List)localObject1).get(i);
      f1 = (float)(Math.sin((2.0F - Math.abs(i - 37)) * 3.141592653589793D / 4.0D) * 0.3D);
      if (i == 35)
      {
        f2 = (localPointF3.y - localPointF6.y) / (localPointF3.x - localPointF6.x);
        f1 = (float)(localPointF3.x + (localPointF3.x - localPointF6.x) * 0.9D);
        f5 = localPointF6.x;
        f6 = localPointF6.y;
        paramFloat = f1;
      }
      for (f1 = (f1 - f5) * f2 + f6;; f1 = (float)(Math.cos(f3 + f2) * d2 + d1))
      {
        f2 = paramFloat;
        if (i == 35)
        {
          f2 = paramFloat;
          if (paramFloat < localPointF2.x) {
            f2 = localPointF2.x;
          }
        }
        ((List)localObject1).add(new PointF(f2, f1));
        i += 1;
        break;
        f2 = (float)Math.toRadians(60.0F * (i - 37));
        paramFloat = (float)(localPointF3.x + 10.0F * f4 * (1.0F + f1) * Math.sin(f3 + f2));
        d1 = localPointF3.y;
        d2 = 10.0F * f4 * (f1 + 1.0F);
      }
    }
    localPointF2 = AlgoUtils.middlePoint(localPointF5, localPointF7);
    ((List)localObject1).add(new PointF(localPointF2.x, localPointF2.y));
    int j = ((List)localObject1).size();
    i = 40;
    while (i < 43)
    {
      localPointF2 = (PointF)((List)localObject1).get(i);
      paramFloat = (float)Math.toRadians(60.0F * (i - 41));
      f1 = (float)(Math.sin((3.0F - Math.abs(i - 41)) * 3.141592653589793D / 2.0D) * 0.3D);
      ((List)localObject1).add(new PointF((float)(localPointF2.x - 16.0F * f4 * (1.0F + f1) * Math.sin(f3 + paramFloat)), (float)(localPointF2.y - 16.0F * f4 * (f1 + 1.0F) * Math.cos(f3 + paramFloat))));
      i += 1;
    }
    localPointF2 = (PointF)((List)localObject1).get(j);
    localPointF3 = (PointF)((List)localObject1).get(j + 1);
    localPointF5 = (PointF)((List)localObject1).get(j + 2);
    ((List)localObject1).add(AlgoUtils.middlePoint(localPointF2, localPointF3));
    ((List)localObject1).add(AlgoUtils.middlePoint(localPointF5, localPointF3));
    localPointF2 = (PointF)((List)localObject1).get(51);
    localPointF2 = (PointF)((List)localObject1).get(47);
    localPointF2 = (PointF)((List)localObject1).get(53);
    localPointF3 = (PointF)((List)localObject1).get(63);
    f4 = AlgoUtils.getDistance(localPointF1, localPointF4) / 50.0F;
    i = 45;
    if (i < 49)
    {
      localPointF1 = (PointF)((List)localObject1).get(i);
      f1 = (float)(Math.sin((2.0F - Math.abs(i - 47)) * 3.141592653589793D / 4.0D) * 0.3D);
      if (i == 45)
      {
        f2 = (localPointF1.y - localPointF2.y) / (localPointF1.x - localPointF2.x);
        f1 = (float)(localPointF1.x + (localPointF1.x - localPointF2.x) * 0.9D);
        f5 = localPointF2.x;
        f6 = localPointF2.y;
        paramFloat = f1;
      }
      for (f1 = (f1 - f5) * f2 + f6;; f1 = (float)(Math.cos(f3 - f2) * d2 + d1))
      {
        f2 = paramFloat;
        if (i == 45)
        {
          f2 = paramFloat;
          if (paramFloat > paramList.x) {
            f2 = paramList.x;
          }
        }
        ((List)localObject1).add(new PointF(f2, f1));
        i += 1;
        break;
        f2 = (float)Math.toRadians(60.0F * (i - 47));
        paramFloat = (float)(localPointF1.x + 10.0F * f4 * (1.0F + f1) * Math.sin(f3 - f2));
        d1 = localPointF1.y;
        d2 = 10.0F * f4 * (f1 + 1.0F);
      }
    }
    paramList = AlgoUtils.middlePoint(localPointF4, localPointF3);
    ((List)localObject1).add(new PointF(paramList.x, paramList.y));
    j = ((List)localObject1).size();
    i = 50;
    while (i < 53)
    {
      paramList = (PointF)((List)localObject1).get(i);
      paramFloat = (float)Math.toRadians(60.0F * (i - 51));
      f1 = (float)(Math.sin((3.0F - Math.abs(i - 51)) * 3.141592653589793D / 2.0D) * 0.3D);
      ((List)localObject1).add(new PointF((float)(paramList.x - 16.0F * f4 * (1.0F + f1) * Math.sin(f3 - paramFloat)), (float)(paramList.y - 16.0F * f4 * (f1 + 1.0F) * Math.cos(f3 - paramFloat))));
      i += 1;
    }
    paramList = (PointF)((List)localObject1).get(j);
    localPointF1 = (PointF)((List)localObject1).get(j + 1);
    localPointF2 = (PointF)((List)localObject1).get(j + 2);
    ((List)localObject1).add(AlgoUtils.middlePoint(paramList, localPointF1));
    ((List)localObject1).add(AlgoUtils.middlePoint(localPointF2, localPointF1));
    return localObject1;
  }
  
  public static List<PointF> getFullCoordsForFaceOffFilter(List<PointF> paramList, float paramFloat)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramList.size() < 90)) {
      return new ArrayList();
    }
    float f1 = ((PointF)paramList.get(41)).x;
    f1 = (((PointF)paramList.get(51)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(41)).y;
    PointF localPointF1 = new PointF(f1, (((PointF)paramList.get(51)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    double d1 = Math.atan2(f1 - f2, f4 + f3) + 3.141592653589793D;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d1));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
    PointF localPointF2 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(0.0D)));
    paramList.add(localPointF2);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
    PointF localPointF4 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(0.0D)));
    paramList.add(localPointF4);
    f1 = AlgoUtils.getDistance((PointF)paramList.get(59), localPointF1);
    PointF localPointF3 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(0.0D)));
    int i = 2;
    double d2;
    double d3;
    double d4;
    while (i >= 1)
    {
      d2 = Math.toRadians(i * 30.0F);
      localPointF5 = new PointF();
      localPointF5.x = ((float)(localPointF3.x - (localPointF3.x - localPointF4.x) * Math.cos(d2)));
      d3 = localPointF4.y;
      d4 = localPointF4.y - localPointF3.y;
      localPointF5.y = ((float)(d3 - Math.sin(d2) * d4));
      paramList.add(localPointF5);
      i -= 1;
    }
    i = 3;
    while (i >= 1)
    {
      d2 = Math.toRadians(i * 30.0F);
      localPointF4 = new PointF();
      localPointF4.x = ((float)(localPointF3.x - (localPointF3.x - localPointF2.x) * Math.cos(d2)));
      d3 = localPointF2.y;
      d4 = localPointF2.y - localPointF3.y;
      localPointF4.y = ((float)(d3 - Math.sin(d2) * d4));
      paramList.add(localPointF4);
      i -= 1;
    }
    paramList.add(EMPTY_POINT);
    paramList.add(EMPTY_POINT);
    localPointF2 = (PointF)paramList.get(64);
    localPointF3 = (PointF)paramList.get(54);
    localPointF4 = (PointF)paramList.get(44);
    localPointF3 = new PointF(localPointF3.x - localPointF4.x, localPointF3.y - localPointF4.y);
    localPointF3 = new PointF(localPointF3.x * paramFloat, localPointF3.y * paramFloat);
    localPointF4 = new PointF(-localPointF3.y, localPointF3.x);
    paramList.add(new PointF(localPointF2.x - localPointF3.x - localPointF4.x, localPointF2.y - localPointF3.y - localPointF4.y));
    paramList.add(new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y));
    paramList.add(new PointF(localPointF2.x - localPointF3.x + localPointF4.x, localPointF2.y - localPointF3.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF4.x, localPointF2.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF3.x + localPointF4.x, localPointF2.y + localPointF3.y + localPointF4.y));
    paramList.add(new PointF(localPointF2.x + localPointF3.x, localPointF2.y + localPointF3.y));
    paramFloat = localPointF2.x;
    f1 = localPointF3.x;
    f2 = localPointF4.x;
    f3 = localPointF2.y;
    paramList.add(new PointF(paramFloat + f1 - f2, localPointF3.y + f3 - localPointF4.y));
    paramList.add(new PointF(localPointF2.x - localPointF4.x, localPointF2.y - localPointF4.y));
    localPointF2 = (PointF)paramList.get(3);
    localPointF2 = (PointF)paramList.get(15);
    localPointF2 = (PointF)paramList.get(65);
    localPointF2 = (PointF)paramList.get(66);
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
    paramList.add(new PointF(localPointF2.x, localPointF2.y));
    localPointF2 = (PointF)paramList.get(2);
    localPointF2 = (PointF)paramList.get(16);
    localPointF4 = (PointF)paramList.get(39);
    localPointF2 = (PointF)paramList.get(49);
    localPointF3 = (PointF)paramList.get(57);
    localPointF3 = (PointF)paramList.get(61);
    PointF localPointF5 = (PointF)paramList.get(35);
    localPointF3 = (PointF)paramList.get(45);
    PointF localPointF6 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
    paramList.add(new PointF(localPointF6.x, localPointF6.y));
    localPointF6 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
    paramList.add(new PointF(localPointF6.x, localPointF6.y));
    localPointF6 = (PointF)paramList.get(43);
    PointF localPointF7 = (PointF)paramList.get(55);
    localPointF7 = (PointF)paramList.get(41);
    PointF localPointF8 = (PointF)paramList.get(37);
    paramFloat = AlgoUtils.getDistance(localPointF5, localPointF4);
    AlgoUtils.getDistance(localPointF7, localPointF8);
    f2 = paramFloat / 50.0F;
    i = 35;
    if (i < 39)
    {
      localPointF4 = (PointF)paramList.get(i);
      f1 = (float)(Math.sin((2.0F - Math.abs(i - 37)) * 3.141592653589793D / 4.0D) * 0.3D);
      if (i == 35)
      {
        f1 = (localPointF4.y - localPointF6.y) / (localPointF4.x - localPointF6.x);
        paramFloat = localPointF4.x + (localPointF4.x - localPointF6.x) * 0.9F;
        f1 = (paramFloat - localPointF6.x) * f1 + localPointF6.y;
        label1815:
        if ((i != 35) || (paramFloat >= ((PointF)paramList.get(0)).x)) {
          break label3008;
        }
        paramFloat = ((PointF)paramList.get(0)).x;
      }
    }
    label2481:
    label3005:
    label3008:
    for (;;)
    {
      paramList.add(new PointF(paramFloat, f1));
      i += 1;
      break;
      f3 = (float)Math.toRadians(60.0F * (i - 37));
      paramFloat = (float)(localPointF4.x + 10.0F * f2 * (1.0F + f1) * Math.sin(f3 + 0.0D));
      f1 = (float)(localPointF4.y + 10.0F * f2 * (f1 + 1.0F) * Math.cos(f3 + 0.0D));
      break label1815;
      localPointF4 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      int j = paramList.size();
      i = 40;
      while (i < 43)
      {
        localPointF4 = (PointF)paramList.get(i);
        paramFloat = (float)Math.toRadians(60.0F * (i - 41));
        f1 = (float)(Math.sin((3.0F - Math.abs(i - 41)) * 3.141592653589793D / 2.0D) * 0.3D);
        paramList.add(new PointF((float)(localPointF4.x - 16.0F * f2 * (1.0F + f1) * Math.sin(paramFloat + 0.0D)), (float)(localPointF4.y - 16.0F * f2 * (f1 + 1.0F) * Math.cos(paramFloat + 0.0D))));
        i += 1;
      }
      localPointF6 = (PointF)paramList.get(j);
      localPointF4 = (PointF)paramList.get(j + 1);
      localPointF5 = (PointF)paramList.get(j + 2);
      localPointF6 = AlgoUtils.middlePoint(localPointF6, localPointF4);
      localPointF4 = AlgoUtils.middlePoint(localPointF5, localPointF4);
      paramList.add(new PointF(localPointF6.x, localPointF6.y));
      paramList.add(new PointF(localPointF4.x, localPointF4.y));
      localPointF5 = (PointF)paramList.get(51);
      localPointF6 = (PointF)paramList.get(47);
      localPointF4 = (PointF)paramList.get(54);
      localPointF7 = (PointF)paramList.get(63);
      paramFloat = AlgoUtils.getDistance(localPointF3, localPointF2);
      AlgoUtils.getDistance(localPointF5, localPointF6);
      f2 = paramFloat / 50.0F;
      i = 45;
      if (i < 49)
      {
        localPointF2 = (PointF)paramList.get(i);
        f1 = (float)(Math.sin((2.0F - Math.abs(i - 47)) * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 45)
        {
          f1 = (localPointF2.y - localPointF4.y) / (localPointF2.x - localPointF4.x);
          paramFloat = localPointF2.x + (localPointF2.x - localPointF4.x) * 0.9F;
          f1 = (paramFloat - localPointF4.x) * f1 + localPointF4.y;
          if ((i != 45) || (paramFloat <= ((PointF)paramList.get(18)).x)) {
            break label3005;
          }
          paramFloat = ((PointF)paramList.get(18)).x;
        }
      }
      for (;;)
      {
        paramList.add(new PointF(paramFloat, f1));
        i += 1;
        break;
        f3 = (float)Math.toRadians(60.0F * (i - 47));
        paramFloat = (float)(localPointF2.x + 10.0F * f2 * (1.0F + f1) * Math.sin(0.0D - f3));
        f1 = (float)(localPointF2.y + 10.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D - f3));
        break label2481;
        localPointF2 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        j = paramList.size();
        i = 50;
        while (i < 53)
        {
          localPointF2 = (PointF)paramList.get(i);
          paramFloat = (float)Math.toRadians(60.0F * (i - 51));
          f1 = (float)(Math.sin((3.0F - Math.abs(i - 51)) * 3.141592653589793D / 2.0D) * 0.3D);
          paramList.add(new PointF((float)(localPointF2.x - 16.0F * f2 * (1.0F + f1) * Math.sin(0.0D - paramFloat)), (float)(localPointF2.y - 16.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D - paramFloat))));
          i += 1;
        }
        localPointF4 = (PointF)paramList.get(j);
        localPointF2 = (PointF)paramList.get(j + 1);
        localPointF3 = (PointF)paramList.get(j + 2);
        localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
        localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
        paramList.add(new PointF(localPointF4.x, localPointF4.y));
        paramList.add(new PointF(localPointF2.x, localPointF2.y));
        localMatrix.reset();
        localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
        localMatrix.postRotate((float)Math.toDegrees(d1));
        localMatrix.postTranslate(localPointF1.x, localPointF1.y);
        return AlgoUtils.mapPoints(paramList, localMatrix);
      }
    }
  }
  
  public static List<PointF> getFullCoordsForNoseAndOutline(List<PointF> paramList)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramList.size() < 90)) {
      localObject = new ArrayList();
    }
    do
    {
      return localObject;
      if (paramList.size() > 97) {
        paramList.subList(97, paramList.size()).clear();
      }
      if (paramList.size() == 90) {
        break;
      }
      localObject = paramList;
    } while (paramList.size() != 97);
    float f1 = ((PointF)paramList.get(41)).x;
    f1 = (((PointF)paramList.get(51)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(41)).y;
    Object localObject = new PointF(f1, (((PointF)paramList.get(51)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    double d1 = Math.atan2(f1 - f2, f4 + f3) + 3.141592653589793D;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
    localMatrix.postRotate((float)Math.toDegrees(-d1));
    localMatrix.postTranslate(((PointF)localObject).x, ((PointF)localObject).y);
    paramList = AlgoUtils.mapPoints(paramList, localMatrix);
    if (paramList.size() == 90)
    {
      f1 = AlgoUtils.getDistance((PointF)paramList.get(0), (PointF)paramList.get(1));
      localPointF1 = new PointF((float)(((PointF)paramList.get(1)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(1)).y - 2.0F * f1 * Math.cos(0.0D)));
      paramList.add(localPointF1);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(17), (PointF)paramList.get(18));
      localPointF3 = new PointF((float)(((PointF)paramList.get(17)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(17)).y - 2.0F * f1 * Math.cos(0.0D)));
      paramList.add(localPointF3);
      f1 = AlgoUtils.getDistance((PointF)paramList.get(59), (PointF)localObject);
      localPointF2 = new PointF((float)(((PointF)paramList.get(59)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)paramList.get(59)).y - 2.0F * f1 * Math.cos(0.0D)));
      i = 2;
      double d2;
      double d3;
      double d4;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF4 = new PointF();
        localPointF4.x = ((float)(localPointF2.x - (localPointF2.x - localPointF3.x) * Math.cos(d2)));
        d3 = localPointF3.y;
        d4 = localPointF3.y - localPointF2.y;
        localPointF4.y = ((float)(d3 - Math.sin(d2) * d4));
        paramList.add(localPointF4);
        i -= 1;
      }
      i = 3;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF3 = new PointF();
        localPointF3.x = ((float)(localPointF2.x - (localPointF2.x - localPointF1.x) * Math.cos(d2)));
        d3 = localPointF1.y;
        d4 = localPointF1.y - localPointF2.y;
        localPointF3.y = ((float)(d3 - Math.sin(d2) * d4));
        paramList.add(localPointF3);
        i -= 1;
      }
    }
    paramList.add(EMPTY_POINT);
    paramList.add(EMPTY_POINT);
    PointF localPointF1 = (PointF)paramList.get(64);
    PointF localPointF2 = (PointF)paramList.get(54);
    PointF localPointF3 = (PointF)paramList.get(44);
    localPointF2 = new PointF(localPointF2.x - localPointF3.x, localPointF2.y - localPointF3.y);
    localPointF2 = new PointF(localPointF2.x, localPointF2.y);
    localPointF3 = new PointF(-localPointF2.y, localPointF2.x);
    f1 = AlgoUtils.getDistance(localPointF2, new PointF(0.0F, 0.0F));
    f2 = AlgoUtils.getDistance(localPointF3, new PointF(0.0F, 0.0F));
    localPointF2.x /= f1;
    localPointF2.y /= f1;
    localPointF3.x /= f2;
    localPointF3.y /= f2;
    f1 = localPointF2.x;
    f2 = ((PointF)paramList.get(17)).x;
    f3 = ((PointF)paramList.get(56)).x;
    f4 = localPointF2.y;
    f1 = 2.0F * Math.abs((((PointF)paramList.get(17)).y - ((PointF)paramList.get(56)).y) * f4 + f1 * (f2 - f3));
    f2 = localPointF2.x;
    f3 = ((PointF)paramList.get(1)).x;
    f4 = ((PointF)paramList.get(62)).x;
    float f5 = localPointF2.y;
    f4 = 2.0F * Math.abs((((PointF)paramList.get(1)).y - ((PointF)paramList.get(62)).y) * f5 + f2 * (f3 - f4));
    f2 = localPointF3.x;
    f3 = ((PointF)paramList.get(9)).x;
    f5 = localPointF1.x;
    float f6 = localPointF3.y;
    f2 = 2.0F * Math.abs((((PointF)paramList.get(9)).y - localPointF1.y) * f6 + f2 * (f3 - f5));
    f3 = localPointF3.x;
    f5 = ((PointF)paramList.get(87)).x;
    f6 = localPointF1.x;
    float f7 = localPointF3.y;
    f3 = Math.abs((((PointF)paramList.get(87)).y - localPointF1.y) * f7 + f3 * (f5 - f6)) * 2.0F;
    paramList.add(new PointF(localPointF1.x - localPointF2.x * f4 - localPointF3.x * f3, localPointF1.y - localPointF2.y * f4 - localPointF3.y * f3));
    paramList.add(new PointF(localPointF1.x - localPointF2.x * f4, localPointF1.y - localPointF2.y * f4));
    paramList.add(new PointF(localPointF1.x - localPointF2.x * f4 + localPointF3.x * f2, localPointF1.y - f4 * localPointF2.y + localPointF3.y * f2));
    paramList.add(new PointF(localPointF1.x + localPointF3.x * f2, localPointF1.y + localPointF3.y * f2));
    f4 = localPointF1.x;
    f5 = localPointF2.x;
    f6 = localPointF3.x;
    f7 = localPointF1.y;
    float f8 = localPointF2.y;
    paramList.add(new PointF(f4 + f5 * f1 + f6 * f2, f2 * localPointF3.y + (f7 + f8 * f1)));
    paramList.add(new PointF(localPointF1.x + localPointF2.x * f1, localPointF1.y + localPointF2.y * f1));
    f2 = localPointF1.x;
    f4 = localPointF2.x;
    f5 = localPointF3.x;
    f6 = localPointF1.y;
    paramList.add(new PointF(f2 + f4 * f1 - f5 * f3, localPointF2.y * f1 + f6 - localPointF3.y * f3));
    paramList.add(new PointF(localPointF1.x - localPointF3.x * f3, localPointF1.y - f3 * localPointF3.y));
    localPointF1 = (PointF)paramList.get(3);
    localPointF1 = (PointF)paramList.get(15);
    localPointF1 = (PointF)paramList.get(65);
    localPointF1 = (PointF)paramList.get(66);
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(3), (PointF)paramList.get(65));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(15), (PointF)paramList.get(66));
    paramList.add(new PointF(localPointF1.x, localPointF1.y));
    localPointF1 = (PointF)paramList.get(2);
    localPointF1 = (PointF)paramList.get(16);
    localPointF3 = (PointF)paramList.get(39);
    localPointF1 = (PointF)paramList.get(49);
    localPointF2 = (PointF)paramList.get(57);
    localPointF2 = (PointF)paramList.get(61);
    PointF localPointF4 = (PointF)paramList.get(35);
    localPointF2 = (PointF)paramList.get(45);
    PointF localPointF5 = AlgoUtils.middlePoint((PointF)paramList.get(35), (PointF)paramList.get(57));
    paramList.add(new PointF(localPointF5.x, localPointF5.y));
    localPointF5 = AlgoUtils.middlePoint((PointF)paramList.get(45), (PointF)paramList.get(61));
    paramList.add(new PointF(localPointF5.x, localPointF5.y));
    localPointF5 = (PointF)paramList.get(43);
    PointF localPointF6 = (PointF)paramList.get(55);
    localPointF6 = (PointF)paramList.get(41);
    PointF localPointF7 = (PointF)paramList.get(37);
    f1 = AlgoUtils.getDistance(localPointF4, localPointF3);
    AlgoUtils.getDistance(localPointF6, localPointF7);
    f3 = f1 / 50.0F;
    int i = 35;
    if (i < 39)
    {
      localPointF3 = (PointF)paramList.get(i);
      f2 = (float)(Math.sin((2.0F - Math.abs(i - 37)) * 3.141592653589793D / 4.0D) * 0.3D);
      if (i == 35)
      {
        f2 = (localPointF3.y - localPointF5.y) / (localPointF3.x - localPointF5.x);
        f1 = localPointF3.x + (localPointF3.x - localPointF5.x) * 0.9F;
        f2 = (f1 - localPointF5.x) * f2 + localPointF5.y;
        label2395:
        if ((i != 35) || (f1 >= ((PointF)paramList.get(0)).x)) {
          break label3606;
        }
        f1 = ((PointF)paramList.get(0)).x;
      }
    }
    label3072:
    label3603:
    label3606:
    for (;;)
    {
      paramList.add(new PointF(f1, f2));
      i += 1;
      break;
      f4 = (float)Math.toRadians(60.0F * (i - 37));
      f1 = (float)(localPointF3.x + 10.0F * f3 * (1.0F + f2) * Math.sin(f4 + 0.0D));
      f2 = (float)(localPointF3.y + 10.0F * f3 * (f2 + 1.0F) * Math.cos(f4 + 0.0D));
      break label2395;
      localPointF3 = AlgoUtils.middlePoint((PointF)paramList.get(39), (PointF)paramList.get(55));
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      int j = paramList.size();
      i = 40;
      while (i < 43)
      {
        localPointF3 = (PointF)paramList.get(i);
        f1 = (float)Math.toRadians(60.0F * (i - 41));
        f2 = (float)(Math.sin((3.0F - Math.abs(i - 41)) * 3.141592653589793D / 2.0D) * 0.3D);
        paramList.add(new PointF((float)(localPointF3.x - 16.0F * f3 * (1.0F + f2) * Math.sin(f1 + 0.0D)), (float)(localPointF3.y - 16.0F * f3 * (f2 + 1.0F) * Math.cos(f1 + 0.0D))));
        i += 1;
      }
      localPointF5 = (PointF)paramList.get(j);
      localPointF3 = (PointF)paramList.get(j + 1);
      localPointF4 = (PointF)paramList.get(j + 2);
      localPointF5 = AlgoUtils.middlePoint(localPointF5, localPointF3);
      localPointF3 = AlgoUtils.middlePoint(localPointF4, localPointF3);
      paramList.add(new PointF(localPointF5.x, localPointF5.y));
      paramList.add(new PointF(localPointF3.x, localPointF3.y));
      localPointF4 = (PointF)paramList.get(51);
      localPointF5 = (PointF)paramList.get(47);
      localPointF3 = (PointF)paramList.get(54);
      localPointF6 = (PointF)paramList.get(63);
      f1 = AlgoUtils.getDistance(localPointF2, localPointF1);
      AlgoUtils.getDistance(localPointF4, localPointF5);
      f3 = f1 / 50.0F;
      i = 45;
      if (i < 49)
      {
        localPointF1 = (PointF)paramList.get(i);
        f2 = (float)(Math.sin((2.0F - Math.abs(i - 47)) * 3.141592653589793D / 4.0D) * 0.3D);
        if (i == 45)
        {
          f2 = (localPointF1.y - localPointF3.y) / (localPointF1.x - localPointF3.x);
          f1 = localPointF1.x + (localPointF1.x - localPointF3.x) * 0.9F;
          f2 = (f1 - localPointF3.x) * f2 + localPointF3.y;
          if ((i != 45) || (f1 <= ((PointF)paramList.get(18)).x)) {
            break label3603;
          }
          f1 = ((PointF)paramList.get(18)).x;
        }
      }
      for (;;)
      {
        paramList.add(new PointF(f1, f2));
        i += 1;
        break;
        f4 = (float)Math.toRadians(60.0F * (i - 47));
        f1 = (float)(localPointF1.x + 10.0F * f3 * (1.0F + f2) * Math.sin(0.0D - f4));
        f2 = (float)(localPointF1.y + 10.0F * f3 * (f2 + 1.0F) * Math.cos(0.0D - f4));
        break label3072;
        localPointF1 = AlgoUtils.middlePoint((PointF)paramList.get(49), (PointF)paramList.get(63));
        paramList.add(new PointF(localPointF1.x, localPointF1.y));
        j = paramList.size();
        i = 50;
        while (i < 53)
        {
          localPointF1 = (PointF)paramList.get(i);
          f1 = (float)Math.toRadians(60.0F * (i - 51));
          f2 = (float)(Math.sin((3.0F - Math.abs(i - 51)) * 3.141592653589793D / 2.0D) * 0.3D);
          paramList.add(new PointF((float)(localPointF1.x - 16.0F * f3 * (1.0F + f2) * Math.sin(0.0D - f1)), (float)(localPointF1.y - 16.0F * f3 * (f2 + 1.0F) * Math.cos(0.0D - f1))));
          i += 1;
        }
        localPointF3 = (PointF)paramList.get(j);
        localPointF1 = (PointF)paramList.get(j + 1);
        localPointF2 = (PointF)paramList.get(j + 2);
        localPointF3 = AlgoUtils.middlePoint(localPointF3, localPointF1);
        localPointF1 = AlgoUtils.middlePoint(localPointF2, localPointF1);
        paramList.add(new PointF(localPointF3.x, localPointF3.y));
        paramList.add(new PointF(localPointF1.x, localPointF1.y));
        localMatrix.reset();
        localMatrix.postTranslate(-((PointF)localObject).x, -((PointF)localObject).y);
        localMatrix.postRotate((float)Math.toDegrees(d1));
        localMatrix.postTranslate(((PointF)localObject).x, ((PointF)localObject).y);
        return AlgoUtils.mapPoints(paramList, localMatrix);
      }
    }
  }
  
  public static List<PointF> getFullCoords_v2(List<PointF> paramList, float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramList.size() < 90)) {
      localObject = new ArrayList();
    }
    do
    {
      return localObject;
      if (paramList.size() > 97) {
        paramList.subList(97, paramList.size()).clear();
      }
      if (paramList.size() == 90) {
        break;
      }
      localObject = paramList;
    } while (paramList.size() != 97);
    float f1 = ((PointF)paramList.get(41)).x;
    f1 = (((PointF)paramList.get(51)).x + f1) / 2.0F;
    float f2 = ((PointF)paramList.get(41)).y;
    PointF localPointF1 = new PointF(f1, (((PointF)paramList.get(51)).y + f2) / 2.0F);
    f1 = ((PointF)paramList.get(9)).x;
    f2 = ((PointF)paramList.get(84)).x;
    float f3 = -((PointF)paramList.get(9)).y;
    float f4 = ((PointF)paramList.get(84)).y;
    double d1 = Math.atan2(f1 - f2, f4 + f3) + 3.141592653589793D;
    Matrix localMatrix = new Matrix();
    localMatrix.reset();
    localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
    localMatrix.postRotate((float)Math.toDegrees(-d1));
    localMatrix.postTranslate(localPointF1.x, localPointF1.y);
    List localList = AlgoUtils.mapPoints(paramList, localMatrix);
    if (localList.size() == 90)
    {
      f1 = AlgoUtils.getDistance((PointF)localList.get(0), (PointF)localList.get(1));
      paramList = new PointF((float)(((PointF)localList.get(1)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)localList.get(1)).y - 2.0F * f1 * Math.cos(0.0D)));
      localList.add(paramList);
      f1 = AlgoUtils.getDistance((PointF)localList.get(17), (PointF)localList.get(18));
      localPointF2 = new PointF((float)(((PointF)localList.get(17)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)localList.get(17)).y - 2.0F * f1 * Math.cos(0.0D)));
      localList.add(localPointF2);
      f1 = AlgoUtils.getDistance((PointF)localList.get(59), localPointF1);
      localObject = new PointF((float)(((PointF)localList.get(59)).x + 2.0F * f1 * Math.sin(0.0D)), (float)(((PointF)localList.get(59)).y - 2.0F * f1 * Math.cos(0.0D)));
      i = 2;
      double d2;
      double d3;
      double d4;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF3 = new PointF();
        localPointF3.x = ((float)(((PointF)localObject).x - (((PointF)localObject).x - localPointF2.x) * Math.cos(d2)));
        d3 = localPointF2.y;
        d4 = localPointF2.y - ((PointF)localObject).y;
        localPointF3.y = ((float)(d3 - Math.sin(d2) * d4));
        localList.add(localPointF3);
        i -= 1;
      }
      i = 3;
      while (i >= 1)
      {
        d2 = Math.toRadians(i * 30.0F);
        localPointF2 = new PointF();
        localPointF2.x = ((float)(((PointF)localObject).x - (((PointF)localObject).x - paramList.x) * Math.cos(d2)));
        d3 = paramList.y;
        d4 = paramList.y - ((PointF)localObject).y;
        localPointF2.y = ((float)(d3 - Math.sin(d2) * d4));
        localList.add(localPointF2);
        i -= 1;
      }
    }
    localList.add(EMPTY_POINT);
    localList.add(EMPTY_POINT);
    paramList = (PointF)localList.get(64);
    Object localObject = (PointF)localList.get(54);
    localObject = (PointF)localList.get(44);
    PointF localPointF2 = new PointF(((PointF)localList.get(18)).x - ((PointF)localList.get(0)).x, ((PointF)localList.get(18)).y - ((PointF)localList.get(0)).y);
    localObject = new PointF(-localPointF2.y, localPointF2.x);
    if (((PointF)localObject).y < 0.0F)
    {
      ((PointF)localObject).x = (-((PointF)localObject).x);
      ((PointF)localObject).y = (-((PointF)localObject).y);
    }
    f1 = AlgoUtils.getDistance(localPointF2, new PointF(0.0F, 0.0F));
    f2 = AlgoUtils.getDistance((PointF)localObject, new PointF(0.0F, 0.0F));
    localPointF2.x /= f1;
    localPointF2.y /= f1;
    ((PointF)localObject).x /= f2;
    ((PointF)localObject).y /= f2;
    PointF localPointF3 = (PointF)localList.get(56);
    PointF localPointF4 = (PointF)localList.get(62);
    PointF localPointF5 = (PointF)localList.get(17);
    PointF localPointF6 = (PointF)localList.get(1);
    PointF localPointF7 = (PointF)localList.get(9);
    PointF localPointF8 = (PointF)localList.get(87);
    f1 = localPointF2.x;
    f2 = localPointF5.x;
    f3 = localPointF3.x;
    f4 = localPointF2.y;
    f2 = Math.abs((localPointF5.y - localPointF3.y) * f4 + f1 * (f2 - f3));
    f1 = localPointF2.x;
    f3 = localPointF6.x;
    f4 = localPointF4.x;
    float f5 = localPointF2.y;
    f1 = -Math.abs(f1 * (f3 - f4) + (localPointF6.y - localPointF4.y) * f5);
    f3 = Math.abs(((PointF)localObject).x * (localPointF7.x - paramList.x) + ((PointF)localObject).y * (localPointF7.y - paramList.y));
    f4 = -Math.abs(((PointF)localObject).x * (localPointF8.x - paramList.x) + ((PointF)localObject).y * (localPointF8.y - paramList.y));
    localList.add(new PointF(paramList.x + localPointF2.x * f1 * paramFloat1 + ((PointF)localObject).x * f4 * paramFloat1, paramList.y + localPointF2.y * f1 * paramFloat1 + ((PointF)localObject).y * f4 * paramFloat1));
    localList.add(new PointF(paramList.x + localPointF2.x * f1 * paramFloat1, paramList.y + localPointF2.y * f1 * paramFloat1));
    localList.add(new PointF(paramList.x + localPointF2.x * f1 * paramFloat1 + ((PointF)localObject).x * f3 * paramFloat1, paramList.y + localPointF2.y * f1 * paramFloat1 + ((PointF)localObject).y * f3 * paramFloat1));
    localList.add(new PointF(paramList.x + ((PointF)localObject).x * f3 * paramFloat1, paramList.y + ((PointF)localObject).y * f3 * paramFloat1));
    f5 = paramList.x;
    float f6 = localPointF2.x;
    float f7 = ((PointF)localObject).x;
    float f8 = paramList.y;
    float f9 = localPointF2.y;
    localList.add(new PointF(f5 + f6 * f2 * paramFloat1 + f7 * f3 * paramFloat1, f3 * ((PointF)localObject).y * paramFloat1 + (f8 + f9 * f2 * paramFloat1)));
    localList.add(new PointF(paramList.x + localPointF2.x * f2 * paramFloat1, paramList.y + localPointF2.y * f2 * paramFloat1));
    localList.add(new PointF(paramList.x + localPointF2.x * f2 * paramFloat1 + ((PointF)localObject).x * f4 * paramFloat1, paramList.y + localPointF2.y * f2 * paramFloat1 + ((PointF)localObject).y * f4 * paramFloat1));
    localList.add(new PointF(paramList.x + ((PointF)localObject).x * f4 * paramFloat1, paramList.y + f4 * ((PointF)localObject).y * paramFloat1));
    paramList = (PointF)localList.get(3);
    paramList = (PointF)localList.get(15);
    localPointF3 = (PointF)localList.get(65);
    localObject = (PointF)localList.get(66);
    if (paramFloat2 < 0.0F)
    {
      paramFloat1 = localPointF3.x;
      f3 = localPointF2.x;
      f4 = localPointF3.y;
      localPointF4 = new PointF(paramFloat1 + f3 * f1 * 10.0F, f1 * localPointF2.y * 10.0F + f4);
      i = 0;
      if (i >= 9) {
        break label6288;
      }
      paramList = AlgoUtils.getCrossPoint(localPointF3, localPointF4, (PointF)localList.get(i), (PointF)localList.get(i + 1));
      if (paramList != null) {
        if (paramBoolean)
        {
          paramFloat1 = 0.0F;
          label2035:
          paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(65), paramFloat1);
          localList.add(new PointF(paramList.x, paramList.y));
        }
      }
    }
    label2305:
    label6276:
    label6279:
    label6283:
    label6285:
    label6288:
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        paramFloat1 = 3.4028235E+38F;
        paramList = (PointF)localList.get(2);
        i = 0;
        label2103:
        if (i < 9)
        {
          f1 = AlgoUtils.distanceOfPoint2Line(localPointF4, localPointF3, AlgoUtils.getDistance(localPointF4, localPointF3), (PointF)localList.get(i));
          if (f1 >= paramFloat1) {
            break label6285;
          }
          paramList = (PointF)localList.get(i);
          paramFloat1 = f1;
        }
      }
      label2584:
      label2712:
      label3117:
      label6065:
      for (;;)
      {
        i += 1;
        break label2103;
        paramFloat1 = Math.min(1.8F - (float)(1.8D * Math.cos(paramFloat2)), 0.5F);
        break label2035;
        i += 1;
        break;
        if (paramBoolean)
        {
          paramFloat1 = 0.0F;
          paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(65), paramFloat1);
          localList.add(new PointF(paramList.x, paramList.y));
        }
        label3762:
        for (;;)
        {
          if (paramFloat2 < 0.0F)
          {
            localPointF2 = new PointF(((PointF)localObject).x + localPointF2.x * f2 * 10.0F, ((PointF)localObject).y + localPointF2.y * f2 * 10.0F);
            i = 9;
            if (i >= 18) {
              break label6270;
            }
            paramList = AlgoUtils.getCrossPoint((PointF)localObject, localPointF2, (PointF)localList.get(i), (PointF)localList.get(i + 1));
            if (paramList != null)
            {
              paramFloat1 = (float)(4.0D * Math.cos(paramFloat2) - 4.0D);
              paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(66), paramFloat1);
              localList.add(new PointF(paramList.x, paramList.y));
              i = 1;
              label2409:
              if (i != 0) {
                break label2912;
              }
              paramFloat1 = 3.4028235E+38F;
              paramList = (PointF)localList.get(16);
              i = 9;
              for (;;)
              {
                if (i < 18)
                {
                  f1 = AlgoUtils.distanceOfPoint2Line(localPointF2, (PointF)localObject, AlgoUtils.getDistance(localPointF2, (PointF)localObject), (PointF)localList.get(i));
                  if (f1 >= paramFloat1) {
                    break label6267;
                  }
                  paramList = (PointF)localList.get(i);
                  paramFloat1 = f1;
                  label2493:
                  i += 1;
                  continue;
                  paramFloat1 = Math.min(1.8F - (float)(1.8D * Math.cos(paramFloat2)), 0.5F);
                  break;
                  paramFloat1 = localPointF3.x;
                  f3 = localPointF2.x;
                  f4 = localPointF3.y;
                  localPointF4 = new PointF(paramFloat1 + f3 * f1 * 10.0F, f1 * localPointF2.y * 10.0F + f4);
                  i = 0;
                  if (i >= 9) {
                    break label6279;
                  }
                  paramList = AlgoUtils.getCrossPoint(localPointF3, localPointF4, (PointF)localList.get(i), (PointF)localList.get(i + 1));
                  if (paramList != null)
                  {
                    paramFloat1 = (float)(4.0D * Math.cos(paramFloat2) - 4.0D);
                    paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(65), paramFloat1);
                    localList.add(new PointF(paramList.x, paramList.y));
                  }
                }
              }
            }
          }
          label3641:
          for (i = 1;; i = 0)
          {
            if (i != 0) {
              break label6283;
            }
            paramFloat1 = 3.4028235E+38F;
            paramList = (PointF)localList.get(2);
            i = 0;
            if (i < 9)
            {
              f1 = AlgoUtils.distanceOfPoint2Line(localPointF4, localPointF3, AlgoUtils.getDistance(localPointF4, localPointF3), (PointF)localList.get(i));
              if (f1 >= paramFloat1) {
                break label6276;
              }
              paramList = (PointF)localList.get(i);
              paramFloat1 = f1;
            }
            label3524:
            label4940:
            for (;;)
            {
              i += 1;
              break label2712;
              i += 1;
              break label2584;
              paramFloat1 = (float)(4.0D * Math.cos(paramFloat2) - 4.0D);
              paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(65), paramFloat1);
              localList.add(new PointF(paramList.x, paramList.y));
              break;
              i += 1;
              break label2305;
              paramFloat1 = (float)(4.0D * Math.cos(paramFloat2) - 4.0D);
              paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(66), paramFloat1);
              localList.add(new PointF(paramList.x, paramList.y));
              label2912:
              label3318:
              label6265:
              for (;;)
              {
                paramList = (PointF)localList.get(2);
                paramList = (PointF)localList.get(16);
                localPointF2 = (PointF)localList.get(39);
                paramList = (PointF)localList.get(49);
                localObject = (PointF)localList.get(57);
                localObject = (PointF)localList.get(61);
                localPointF3 = (PointF)localList.get(35);
                localObject = (PointF)localList.get(45);
                if (paramFloat2 < 0.0F) {
                  if (paramBoolean)
                  {
                    paramFloat1 = 0.0F;
                    localPointF4 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), paramFloat1);
                    localPointF5 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), 0.1F);
                    localList.add(new PointF(localPointF4.x, localPointF5.y));
                    if (paramFloat2 >= 0.0F) {
                      break label4209;
                    }
                    paramFloat1 = (float)(3.0D * Math.cos(paramFloat2) - 3.0D);
                    localPointF4 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), paramFloat1);
                    localPointF5 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), 0.1F);
                    paramFloat1 = ((PointF)localList.get(18)).x;
                    f1 = ((PointF)localList.get(0)).x;
                    if ((((PointF)localList.get(18)).x - ((PointF)localList.get(62)).x) * (paramFloat1 - f1) > 0.0F) {
                      break label4181;
                    }
                    localList.add(new PointF(((PointF)localList.get(18)).x, ((PointF)localList.get(18)).y));
                    localPointF4 = (PointF)localList.get(43);
                    localPointF5 = (PointF)localList.get(55);
                    localPointF5 = (PointF)localList.get(41);
                    localPointF6 = (PointF)localList.get(37);
                    paramFloat1 = AlgoUtils.getDistance(localPointF3, localPointF2);
                    AlgoUtils.getDistance(localPointF5, localPointF6);
                    f2 = paramFloat1 / 50.0F;
                    i = 35;
                    for (;;)
                    {
                      if (i < 39)
                      {
                        localPointF2 = (PointF)localList.get(i);
                        f1 = (float)(Math.sin((2.0F - Math.abs(i - 37)) * 3.141592653589793D / 4.0D) * 0.3D);
                        if (i == 35)
                        {
                          f1 = (localPointF2.y - localPointF4.y) / (localPointF2.x - localPointF4.x);
                          paramFloat1 = localPointF2.x + (localPointF2.x - localPointF4.x) * 0.9F;
                          f1 = (paramFloat1 - localPointF4.x) * f1 + localPointF4.y;
                          if ((i != 35) || (paramFloat1 >= ((PointF)localList.get(0)).x)) {
                            break label6255;
                          }
                          paramFloat1 = ((PointF)localList.get(0)).x;
                          localList.add(new PointF(paramFloat1, f1));
                          i += 1;
                          continue;
                          localPointF2 = new PointF(((PointF)localObject).x + localPointF2.x * f2 * 10.0F, ((PointF)localObject).y + localPointF2.y * f2 * 10.0F);
                          i = 9;
                          if (i >= 18) {
                            break label6261;
                          }
                          paramList = AlgoUtils.getCrossPoint((PointF)localObject, localPointF2, (PointF)localList.get(i), (PointF)localList.get(i + 1));
                          if (paramList != null) {
                            if (paramBoolean)
                            {
                              paramFloat1 = 0.0F;
                              paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(66), paramFloat1);
                              localList.add(new PointF(paramList.x, paramList.y));
                            }
                          }
                        }
                      }
                    }
                  }
                }
                for (i = 1;; i = 0)
                {
                  if (i != 0) {
                    break label6265;
                  }
                  paramFloat1 = 3.4028235E+38F;
                  paramList = (PointF)localList.get(16);
                  i = 9;
                  if (i < 18)
                  {
                    f1 = AlgoUtils.distanceOfPoint2Line(localPointF2, (PointF)localObject, AlgoUtils.getDistance(localPointF2, (PointF)localObject), (PointF)localList.get(i));
                    if (f1 >= paramFloat1) {
                      break label6258;
                    }
                    paramList = (PointF)localList.get(i);
                    paramFloat1 = f1;
                  }
                  for (;;)
                  {
                    i += 1;
                    break label3762;
                    paramFloat1 = Math.min(1.8F - (float)(1.8D * Math.cos(paramFloat2)), 0.5F);
                    break label3692;
                    i += 1;
                    break label3641;
                    if (paramBoolean) {}
                    for (paramFloat1 = 0.0F;; paramFloat1 = Math.min(1.8F - (float)(1.8D * Math.cos(paramFloat2)), 0.5F))
                    {
                      paramList = AlgoUtils.getBetweenPoint(paramList, (PointF)localList.get(66), paramFloat1);
                      localList.add(new PointF(paramList.x, paramList.y));
                      break;
                    }
                    paramFloat1 = Math.min(1.2F - (float)(1.2D * Math.cos(paramFloat2)), 0.5F);
                    break label3032;
                    paramFloat1 = (float)(3.0D * Math.cos(paramFloat2) - 3.0D);
                    localPointF4 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), paramFloat1);
                    localPointF5 = AlgoUtils.getBetweenPoint((PointF)localList.get(0), (PointF)localList.get(56), 0.1F);
                    paramFloat1 = ((PointF)localList.get(18)).x;
                    f1 = ((PointF)localList.get(0)).x;
                    if ((((PointF)localList.get(56)).x - ((PointF)localList.get(0)).x) * (paramFloat1 - f1) <= 0.0F)
                    {
                      localList.add(new PointF(((PointF)localList.get(0)).x, ((PointF)localList.get(0)).y));
                      break label3117;
                    }
                    localList.add(new PointF(localPointF4.x, localPointF5.y));
                    break label3117;
                    localList.add(new PointF(localPointF4.x, localPointF5.y));
                    break label3318;
                    if (paramBoolean) {}
                    for (paramFloat1 = 0.0F;; paramFloat1 = Math.min(1.2F - (float)(1.2D * Math.cos(paramFloat2)), 0.5F))
                    {
                      localPointF4 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), paramFloat1);
                      localPointF5 = AlgoUtils.getBetweenPoint((PointF)localList.get(18), (PointF)localList.get(62), 0.1F);
                      localList.add(new PointF(localPointF4.x, localPointF5.y));
                      break;
                    }
                    f3 = (float)Math.toRadians(60.0F * (i - 37));
                    paramFloat1 = (float)(localPointF2.x + 10.0F * f2 * (1.0F + f1) * Math.sin(f3 + 0.0D));
                    f1 = (float)(localPointF2.y + 10.0F * f2 * (f1 + 1.0F) * Math.cos(f3 + 0.0D));
                    break label3524;
                    localPointF2 = AlgoUtils.middlePoint((PointF)localList.get(39), (PointF)localList.get(55));
                    localList.add(new PointF(localPointF2.x, localPointF2.y));
                    int j = localList.size();
                    i = 40;
                    while (i < 43)
                    {
                      localPointF2 = (PointF)localList.get(i);
                      paramFloat1 = (float)Math.toRadians(60.0F * (i - 41));
                      f1 = (float)(Math.sin((3.0F - Math.abs(i - 41)) * 3.141592653589793D / 2.0D) * 0.3D);
                      localList.add(new PointF((float)(localPointF2.x - 16.0F * f2 * (1.0F + f1) * Math.sin(paramFloat1 + 0.0D)), (float)(localPointF2.y - 16.0F * f2 * (f1 + 1.0F) * Math.cos(paramFloat1 + 0.0D))));
                      i += 1;
                    }
                    localPointF4 = (PointF)localList.get(j);
                    localPointF2 = (PointF)localList.get(j + 1);
                    localPointF3 = (PointF)localList.get(j + 2);
                    localPointF4 = AlgoUtils.middlePoint(localPointF4, localPointF2);
                    localPointF2 = AlgoUtils.middlePoint(localPointF3, localPointF2);
                    localList.add(new PointF(localPointF4.x, localPointF4.y));
                    localList.add(new PointF(localPointF2.x, localPointF2.y));
                    localPointF3 = (PointF)localList.get(51);
                    localPointF4 = (PointF)localList.get(47);
                    localPointF2 = (PointF)localList.get(54);
                    localPointF5 = (PointF)localList.get(63);
                    paramFloat1 = AlgoUtils.getDistance((PointF)localObject, paramList);
                    AlgoUtils.getDistance(localPointF3, localPointF4);
                    f2 = paramFloat1 / 50.0F;
                    i = 45;
                    if (i < 49)
                    {
                      paramList = (PointF)localList.get(i);
                      f1 = (float)(Math.sin((2.0F - Math.abs(i - 47)) * 3.141592653589793D / 4.0D) * 0.3D);
                      if (i == 45)
                      {
                        f1 = (paramList.y - localPointF2.y) / (paramList.x - localPointF2.x);
                        paramFloat1 = paramList.x + (paramList.x - localPointF2.x) * 0.9F;
                        f1 = (paramFloat1 - localPointF2.x) * f1 + localPointF2.y;
                        if ((i != 45) || (paramFloat1 <= ((PointF)localList.get(18)).x)) {
                          break label6252;
                        }
                        paramFloat1 = ((PointF)localList.get(18)).x;
                      }
                    }
                    for (;;)
                    {
                      localList.add(new PointF(paramFloat1, f1));
                      i += 1;
                      break;
                      f3 = (float)Math.toRadians(60.0F * (i - 47));
                      paramFloat1 = (float)(paramList.x + 10.0F * f2 * (1.0F + f1) * Math.sin(0.0D - f3));
                      f1 = (float)(paramList.y + 10.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D - f3));
                      break label4940;
                      paramList = AlgoUtils.middlePoint((PointF)localList.get(49), (PointF)localList.get(63));
                      localList.add(new PointF(paramList.x, paramList.y));
                      j = localList.size();
                      i = 50;
                      while (i < 53)
                      {
                        paramList = (PointF)localList.get(i);
                        paramFloat1 = (float)Math.toRadians(60.0F * (i - 51));
                        f1 = (float)(Math.sin((3.0F - Math.abs(i - 51)) * 3.141592653589793D / 2.0D) * 0.3D);
                        localList.add(new PointF((float)(paramList.x - 16.0F * f2 * (1.0F + f1) * Math.sin(0.0D - paramFloat1)), (float)(paramList.y - 16.0F * f2 * (f1 + 1.0F) * Math.cos(0.0D - paramFloat1))));
                        i += 1;
                      }
                      localPointF2 = (PointF)localList.get(j);
                      paramList = (PointF)localList.get(j + 1);
                      localObject = (PointF)localList.get(j + 2);
                      localPointF2 = AlgoUtils.middlePoint(localPointF2, paramList);
                      paramList = AlgoUtils.middlePoint((PointF)localObject, paramList);
                      localList.add(new PointF(localPointF2.x, localPointF2.y));
                      localList.add(new PointF(paramList.x, paramList.y));
                      localObject = (PointF)localList.get(109);
                      paramList = (PointF)localList.get(110);
                      localObject = AlgoUtils.getBetweenPoint((PointF)localObject, AlgoUtils.middlePoint((PointF)localList.get(56), (PointF)localList.get(62)), 0.5F);
                      paramList = AlgoUtils.getBetweenPoint(paramList, AlgoUtils.middlePoint((PointF)localList.get(56), (PointF)localList.get(62)), 0.5F);
                      localPointF2 = new PointF(((PointF)localObject).x, ((PointF)localObject).y);
                      localPointF3 = new PointF(paramList.x, paramList.y);
                      if (paramFloat2 < 0.0F)
                      {
                        paramList = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint((PointF)localList.get(45), (PointF)localList.get(61)), paramList, Math.max((float)Math.cos(paramFloat2) * 15.0F - 14.0F, 0.0F));
                        localList.add(new PointF(((PointF)localObject).x, ((PointF)localObject).y));
                        localList.add(new PointF(paramList.x, paramList.y));
                        localPointF4 = (PointF)localList.get(107);
                        localPointF5 = (PointF)localList.get(108);
                        localObject = AlgoUtils.getBetweenPoint(localPointF4, (PointF)localList.get(65), 0.5F);
                        paramList = AlgoUtils.getBetweenPoint(localPointF5, (PointF)localList.get(66), 0.5F);
                        if (paramFloat2 >= 0.0F) {
                          break label6065;
                        }
                        paramList = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint((PointF)localList.get(14), (PointF)localList.get(66)), paramList, Math.max((float)Math.cos(paramFloat2) * 12.0F - 11.0F, 0.0F));
                        localPointF2 = new PointF(((PointF)localList.get(110)).x - localPointF3.x, ((PointF)localList.get(110)).y - localPointF3.y);
                        paramFloat1 = paramList.x;
                        f1 = localPointF2.x;
                        f2 = paramList.y;
                        localList.set(108, AlgoUtils.getBetweenPoint(new PointF(paramFloat1 + 0.8F * f1, localPointF2.y * 0.8F + f2), localPointF5, Math.max((float)Math.cos(paramFloat2) * 8.0F - 7.0F, 0.0F)));
                      }
                      for (;;)
                      {
                        localList.add(new PointF(((PointF)localObject).x, ((PointF)localObject).y));
                        localList.add(new PointF(paramList.x, paramList.y));
                        localMatrix.reset();
                        localMatrix.postTranslate(-localPointF1.x, -localPointF1.y);
                        localMatrix.postRotate((float)Math.toDegrees(d1));
                        localMatrix.postTranslate(localPointF1.x, localPointF1.y);
                        return AlgoUtils.mapPoints(localList, localMatrix);
                        localObject = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint((PointF)localList.get(35), (PointF)localList.get(57)), (PointF)localObject, Math.max((float)Math.cos(-paramFloat2) * 15.0F - 14.0F, 0.0F));
                        break;
                        localObject = AlgoUtils.getBetweenPoint(AlgoUtils.middlePoint((PointF)localList.get(4), (PointF)localList.get(65)), (PointF)localObject, Math.max((float)Math.cos(-paramFloat2) * 12.0F - 11.0F, 0.0F));
                        localPointF2 = new PointF(((PointF)localList.get(109)).x - localPointF2.x, ((PointF)localList.get(109)).y - localPointF2.y);
                        paramFloat1 = ((PointF)localObject).x;
                        f1 = localPointF2.x;
                        f2 = ((PointF)localObject).y;
                        localList.set(107, AlgoUtils.getBetweenPoint(new PointF(paramFloat1 + 0.8F * f1, localPointF2.y * 0.8F + f2), localPointF4, Math.max((float)Math.cos(-paramFloat2) * 8.0F - 7.0F, 0.0F)));
                      }
                    }
                    break label3565;
                  }
                }
              }
              label3032:
              label3565:
              label4209:
              label6258:
              label6261:
              label6267:
              break label2493;
              label3692:
              label6252:
              label6255:
              label6270:
              i = 0;
              label4181:
              break label2409;
            }
          }
        }
      }
    }
  }
  
  public static float[] getFullOpacityForFaceOffFilter_v2(List<PointF> paramList, float paramFloat)
  {
    float[] arrayOfFloat = new float[''];
    Arrays.fill(arrayOfFloat, 1.0F);
    float f1;
    float f2;
    if (paramFloat < 0.0F) {
      if (paramFloat < -0.610865238198015D)
      {
        f1 = (float)(paramFloat * 180.0D / 3.141592653589793D);
        arrayOfFloat[27] *= Math.max(0.0F, Math.min(1.0F, (35.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[45] *= Math.max(0.0F, Math.min(1.0F, (35.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[28] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[34] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[46] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[52] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[18] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[17] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[16] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[15] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[14] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[13] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[12] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[11] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[10] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[88] *= Math.max(0.0F, Math.min(1.0F, (f1 + 40.0F) * 0.2F + 1.0F));
        arrayOfFloat[29] *= Math.max(0.0F, Math.min(1.0F, 0.1F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[33] *= Math.max(0.0F, Math.min(1.0F, 0.1F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[47] *= Math.max(0.0F, Math.min(1.0F, 0.1F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[51] *= Math.max(0.0F, Math.min(1.0F, 0.1F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[30] *= Math.max(0.0F, Math.min(1.0F, (50.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[31] *= Math.max(0.0F, Math.min(1.0F, (50.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[32] *= Math.max(0.0F, Math.min(1.0F, (50.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[48] *= Math.max(0.0F, Math.min(1.0F, (50.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[49] *= Math.max(0.0F, Math.min(1.0F, (50.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[50] *= Math.max(0.0F, Math.min(1.0F, (50.0F + f1) * 0.2F + 1.0F));
        arrayOfFloat[60] *= Math.max(0.0F, Math.min(1.0F, (f1 + 45.0F) * 0.2F + 1.0F));
        arrayOfFloat[61] *= Math.max(0.0F, Math.min(1.0F, 0.5F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[62] *= Math.max(0.0F, Math.min(1.0F, 0.1F * (55.0F + f1) + 1.0F));
        arrayOfFloat[63] *= Math.max(0.0F, Math.min(1.0F, 0.1F * (55.0F + f1) + 1.0F));
        arrayOfFloat[66] *= Math.max(0.0F, Math.min(1.0F, 0.5F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[71] *= Math.max(0.0F, Math.min(1.0F, 0.3F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[70] *= Math.max(0.0F, Math.min(1.0F, (f1 + 45.0F) * 0.2F + 1.0F));
        arrayOfFloat[78] *= Math.max(0.0F, Math.min(1.0F, (f1 + 45.0F) * 0.2F + 1.0F));
        arrayOfFloat[79] *= Math.max(0.0F, Math.min(1.0F, 0.3F * (f1 + 45.0F) + 1.0F));
        arrayOfFloat[72] *= Math.max(0.0F, Math.min(1.0F, 0.3F * (f1 + 45.0F) + 1.0F));
        f2 = arrayOfFloat[80];
        arrayOfFloat[80] = (Math.max(0.0F, Math.min(1.0F, (f1 + 45.0F) * 0.3F + 1.0F)) * f2);
      }
    }
    for (;;)
    {
      return calcFullProbability_v2(paramList, arrayOfFloat, paramFloat);
      if (paramFloat > 0.610865238198015D)
      {
        f1 = (float)(paramFloat * 180.0D / 3.141592653589793D);
        arrayOfFloat[19] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 35.0F) * 0.2F));
        arrayOfFloat[35] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 35.0F) * 0.2F));
        arrayOfFloat[20] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[26] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[36] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[42] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[0] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[1] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[2] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[3] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[4] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[5] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[6] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[7] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[8] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[86] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 40.0F) * 0.2F));
        arrayOfFloat[21] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.1F * (f1 - 45.0F)));
        arrayOfFloat[25] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.1F * (f1 - 45.0F)));
        arrayOfFloat[37] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.1F * (f1 - 45.0F)));
        arrayOfFloat[41] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.1F * (f1 - 45.0F)));
        arrayOfFloat[22] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 50.0F) * 0.2F));
        arrayOfFloat[23] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 50.0F) * 0.2F));
        arrayOfFloat[24] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 50.0F) * 0.2F));
        arrayOfFloat[38] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 50.0F) * 0.2F));
        arrayOfFloat[39] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 50.0F) * 0.2F));
        arrayOfFloat[40] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 50.0F) * 0.2F));
        arrayOfFloat[55] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.1F * (f1 - 55.0F)));
        arrayOfFloat[56] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.1F * (f1 - 55.0F)));
        arrayOfFloat[57] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.5F * (f1 - 42.0F)));
        arrayOfFloat[58] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 42.0F) * 0.2F));
        arrayOfFloat[65] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.5F * (f1 - 42.0F)));
        arrayOfFloat[67] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.3F * (f1 - 42.0F)));
        arrayOfFloat[68] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 42.0F) * 0.2F));
        arrayOfFloat[75] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.3F * (f1 - 42.0F)));
        arrayOfFloat[76] *= Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 42.0F) * 0.2F));
        arrayOfFloat[74] *= Math.max(0.0F, Math.min(1.0F, 1.0F - 0.3F * (f1 - 42.0F)));
        f2 = arrayOfFloat[82];
        arrayOfFloat[82] = (Math.max(0.0F, Math.min(1.0F, 1.0F - (f1 - 42.0F) * 0.3F)) * f2);
      }
    }
  }
  
  public static float[] getFullPointsOpacityForFaceOffFilter(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[''];
    int i = 0;
    while (i < 90)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i];
      i += 1;
    }
    arrayOfFloat[90] = arrayOfFloat[1];
    arrayOfFloat[91] = arrayOfFloat[17];
    arrayOfFloat[92] = 1.0F;
    arrayOfFloat[93] = 1.0F;
    arrayOfFloat[94] = 1.0F;
    arrayOfFloat[95] = 1.0F;
    arrayOfFloat[96] = 1.0F;
    arrayOfFloat[97] = 0.0F;
    arrayOfFloat[98] = 0.0F;
    arrayOfFloat[99] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[100] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[101] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[102] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[103] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[104] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[105] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[106] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[107] = arrayOfFloat[36];
    arrayOfFloat[108] = arrayOfFloat[46];
    arrayOfFloat[109] = arrayOfFloat[36];
    arrayOfFloat[110] = arrayOfFloat[46];
    arrayOfFloat[111] = arrayOfFloat[35];
    arrayOfFloat[112] = arrayOfFloat[36];
    arrayOfFloat[113] = arrayOfFloat[37];
    arrayOfFloat[114] = arrayOfFloat[38];
    arrayOfFloat[115] = arrayOfFloat[39];
    arrayOfFloat[116] = arrayOfFloat[40];
    arrayOfFloat[117] = arrayOfFloat[41];
    arrayOfFloat[118] = arrayOfFloat[42];
    arrayOfFloat[119] = ((arrayOfFloat[116] + arrayOfFloat[117]) / 2.0F);
    arrayOfFloat[120] = ((arrayOfFloat[117] + arrayOfFloat[118]) / 2.0F);
    arrayOfFloat[121] = arrayOfFloat[45];
    arrayOfFloat[122] = arrayOfFloat[46];
    arrayOfFloat[123] = arrayOfFloat[47];
    arrayOfFloat[124] = arrayOfFloat[48];
    arrayOfFloat[125] = arrayOfFloat[49];
    arrayOfFloat[126] = arrayOfFloat[50];
    arrayOfFloat[127] = arrayOfFloat[51];
    arrayOfFloat[''] = arrayOfFloat[52];
    arrayOfFloat[''] = ((arrayOfFloat[126] + arrayOfFloat[127]) / 2.0F);
    arrayOfFloat[''] = ((arrayOfFloat[127] + arrayOfFloat['']) / 2.0F);
    return arrayOfFloat;
  }
  
  public static float[] getFullPointsVisForFaceOffFilter(float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat = new float[''];
    int i = 0;
    while (i < 90)
    {
      arrayOfFloat[i] = paramArrayOfFloat[i];
      i += 1;
    }
    arrayOfFloat[90] = arrayOfFloat[1];
    arrayOfFloat[91] = arrayOfFloat[17];
    arrayOfFloat[92] = 1.0F;
    arrayOfFloat[93] = 1.0F;
    arrayOfFloat[94] = 1.0F;
    arrayOfFloat[95] = 1.0F;
    arrayOfFloat[96] = 1.0F;
    arrayOfFloat[97] = 0.0F;
    arrayOfFloat[98] = 0.0F;
    arrayOfFloat[99] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[100] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[101] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[102] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[103] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[104] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[105] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[106] = Math.min(Math.min(arrayOfFloat[44], arrayOfFloat[54]), arrayOfFloat[64]);
    arrayOfFloat[107] = ((arrayOfFloat[3] + arrayOfFloat[65]) / 2.0F);
    arrayOfFloat[108] = ((arrayOfFloat[15] + arrayOfFloat[66]) / 2.0F);
    arrayOfFloat[109] = ((arrayOfFloat[35] + arrayOfFloat[57]) / 2.0F);
    arrayOfFloat[110] = ((arrayOfFloat[45] + arrayOfFloat[61]) / 2.0F);
    arrayOfFloat[111] = arrayOfFloat[35];
    arrayOfFloat[112] = arrayOfFloat[36];
    arrayOfFloat[113] = arrayOfFloat[37];
    arrayOfFloat[114] = arrayOfFloat[38];
    arrayOfFloat[115] = arrayOfFloat[39];
    arrayOfFloat[116] = arrayOfFloat[40];
    arrayOfFloat[117] = arrayOfFloat[41];
    arrayOfFloat[118] = arrayOfFloat[42];
    arrayOfFloat[119] = ((arrayOfFloat[116] + arrayOfFloat[117]) / 2.0F);
    arrayOfFloat[120] = ((arrayOfFloat[117] + arrayOfFloat[118]) / 2.0F);
    arrayOfFloat[121] = arrayOfFloat[45];
    arrayOfFloat[122] = arrayOfFloat[46];
    arrayOfFloat[123] = arrayOfFloat[47];
    arrayOfFloat[124] = arrayOfFloat[48];
    arrayOfFloat[125] = arrayOfFloat[49];
    arrayOfFloat[126] = arrayOfFloat[50];
    arrayOfFloat[127] = arrayOfFloat[51];
    arrayOfFloat[''] = arrayOfFloat[52];
    arrayOfFloat[''] = ((arrayOfFloat[126] + arrayOfFloat[127]) / 2.0F);
    arrayOfFloat[''] = ((arrayOfFloat[127] + arrayOfFloat['']) / 2.0F);
    return arrayOfFloat;
  }
  
  public static float[] getFullPointsVisForFaceOffFilter_v2(List<PointF> paramList, float[] paramArrayOfFloat, float paramFloat)
  {
    return calcFullProbability_v2(paramList, paramArrayOfFloat, paramFloat);
  }
  
  public static Bitmap getGrayBitmap(FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    Bitmap localBitmap = null;
    if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.NO_EYE)) {
      localBitmap = BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NO_EYE, 2147483647, 2147483647);
    }
    do
    {
      return localBitmap;
      if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.HAS_EYE)) {
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_HAS_EYE, 2147483647, 2147483647);
      }
      if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.CRAZY_FACE)) {
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_CRAZY_FACE, 2147483647, 2147483647);
      }
      if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.FACE_HEAD_CROP)) {
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_CROP_HEAD_FACE, 2147483647, 2147483647);
      }
      if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.FACE_SKIN)) {
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_FACE_SKIN, 2147483647, 2147483647);
      }
      if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.MASK)) {
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_MASK, 2147483647, 2147483647);
      }
      if (paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.FACE_COS3D_MASK)) {
        return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_FACE_COS3D_MASK, 2147483647, 2147483647);
      }
    } while (!paramFEATURE_TYPE.equals(FaceOffUtil.FEATURE_TYPE.NOSE_MASK));
    return BitmapUtils.decodeSampleBitmap(AEModule.getContext(), GRAY_FILE_NOSE_MASK, 2147483647, 2147483647);
  }
  
  public static List<PointF> getGrayCoords(FaceOffUtil.FEATURE_TYPE paramFEATURE_TYPE)
  {
    switch (FaceOffUtil.1.$SwitchMap$com$tencent$ttpic$util$FaceOffUtil$FEATURE_TYPE[paramFEATURE_TYPE.ordinal()])
    {
    default: 
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    }
    for (;;)
    {
      return loadTexCoords(paramFEATURE_TYPE);
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/crazyface.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/faceheadcropgray.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/faceMask_skin.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
      continue;
      paramFEATURE_TYPE = "assets://camera/camera_video/faceOff/coords/nomouthgray.tsv";
    }
  }
  
  public static String getMaskBrushPointPath()
  {
    return DEFAULT_BRUSH_POINT;
  }
  
  public static List<PointF> getMaskCoords(List<Double> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size() - 1)
    {
      double d1 = ((Double)paramList.get(i)).doubleValue();
      double d2 = ((Double)paramList.get(i + 1)).doubleValue();
      localArrayList.add(new PointF((float)d1, (float)d2));
      i += 2;
    }
    return localArrayList;
  }
  
  public static List<PointF> getSelectedCorrectPoints(float[] paramArrayOfFloat, int[] paramArrayOfInt, int paramInt, List<PointF> paramList, float paramFloat)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < 83)
    {
      if (Select3DIndices[i] > 0) {
        localArrayList.add(new PointF(paramArrayOfFloat[(Select3DIndices[i] * 3)], paramInt - paramArrayOfFloat[(Select3DIndices[i] * 3 + 1)]));
      }
      for (;;)
      {
        i += 1;
        break;
        localArrayList.add(new PointF());
      }
    }
    if ((paramArrayOfInt != null) && (paramArrayOfInt.length >= 17)) {}
    i = 0;
    while (i <= 18)
    {
      localArrayList.set(i, new PointF(((PointF)paramList.get(i)).x, ((PointF)paramList.get(i)).y));
      i += 1;
    }
    float f1 = ((PointF)localArrayList.get(35)).x;
    f1 = (((PointF)localArrayList.get(39)).x + f1) / 2.0F;
    float f2 = ((PointF)localArrayList.get(35)).y;
    localArrayList.set(43, new PointF(f1, (((PointF)localArrayList.get(39)).y + f2) / 2.0F));
    localArrayList.set(44, new PointF(((PointF)localArrayList.get(43)).x, ((PointF)localArrayList.get(43)).y));
    f1 = ((PointF)localArrayList.get(45)).x;
    f1 = (((PointF)localArrayList.get(49)).x + f1) / 2.0F;
    f2 = ((PointF)localArrayList.get(45)).y;
    localArrayList.set(53, new PointF(f1, (((PointF)localArrayList.get(49)).y + f2) / 2.0F));
    localArrayList.set(54, new PointF(((PointF)localArrayList.get(53)).x, ((PointF)localArrayList.get(53)).y));
    paramArrayOfInt = getFullCoordsForFaceOffFilter(FaceDetectUtil.facePointf83to90(localArrayList), paramFloat);
    paramArrayOfInt.set(111, new PointF(paramArrayOfFloat[7968], paramInt - paramArrayOfFloat[7969]));
    paramArrayOfInt.set(112, new PointF(paramArrayOfFloat[7572], paramInt - paramArrayOfFloat[7573]));
    paramArrayOfInt.set(113, new PointF(paramArrayOfFloat[7488], paramInt - paramArrayOfFloat[7489]));
    paramArrayOfInt.set(114, new PointF(paramArrayOfFloat[7707], paramInt - paramArrayOfFloat[7708]));
    paramArrayOfInt.set(115, new PointF(paramArrayOfFloat[18045], paramInt - paramArrayOfFloat[18046]));
    paramArrayOfInt.set(116, new PointF(paramArrayOfFloat[18135], paramInt - paramArrayOfFloat[18136]));
    paramArrayOfInt.set(117, new PointF(paramArrayOfFloat[1728], paramInt - paramArrayOfFloat[1729]));
    paramArrayOfInt.set(118, new PointF(paramArrayOfFloat[7338], paramInt - paramArrayOfFloat[7339]));
    paramArrayOfInt.set(119, new PointF(paramArrayOfFloat[1734], paramInt - paramArrayOfFloat[1735]));
    paramArrayOfInt.set(120, new PointF(paramArrayOfFloat[1737], paramInt - paramArrayOfFloat[1738]));
    paramArrayOfInt.set(121, new PointF(paramArrayOfFloat[15609], paramInt - paramArrayOfFloat[15610]));
    paramArrayOfInt.set(122, new PointF(paramArrayOfFloat[15909], paramInt - paramArrayOfFloat[15910]));
    paramArrayOfInt.set(123, new PointF(paramArrayOfFloat[15714], paramInt - paramArrayOfFloat[15715]));
    paramArrayOfInt.set(124, new PointF(paramArrayOfFloat[15831], paramInt - paramArrayOfFloat[15832]));
    paramArrayOfInt.set(125, new PointF(paramArrayOfFloat[12843], paramInt - paramArrayOfFloat[12844]));
    paramArrayOfInt.set(126, new PointF(paramArrayOfFloat[15630], paramInt - paramArrayOfFloat[15631]));
    paramArrayOfInt.set(127, new PointF(paramArrayOfFloat[4056], paramInt - paramArrayOfFloat[4057]));
    paramArrayOfInt.set(128, new PointF(paramArrayOfFloat[3648], paramInt - paramArrayOfFloat[3649]));
    paramArrayOfInt.set(129, new PointF(paramArrayOfFloat[4062], paramInt - paramArrayOfFloat[4063]));
    paramArrayOfInt.set(130, new PointF(paramArrayOfFloat[15642], paramInt - paramArrayOfFloat[15643]));
    return paramArrayOfInt;
  }
  
  public static float[] initFaceLinePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 690) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
      paramArrayOfFloat[j] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 1)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      j += 12;
      i += 3;
    }
  }
  
  public static float[] initFaceLinePositions_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= NO_HOLE_TRIANGLE_COUNT_V2 * 3) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles_v2[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 2)]));
      paramArrayOfFloat[j] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 1)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      j += 12;
      i += 3;
    }
  }
  
  public static float[] initFaceNoseLastPositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1380))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 690) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(faceMeshNoseLastTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initFacePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return initFacePositions(paramList, paramInt1, paramInt2, paramArrayOfFloat, null);
  }
  
  public static float[] initFacePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat1 == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat1.length != 1380)) {
      paramList = new float[0];
    }
    float f1;
    float f2;
    do
    {
      do
      {
        return paramList;
        PointF[] arrayOfPointF = new PointF[3];
        int j = 0;
        f1 = 0.0F;
        f2 = 0.0F;
        int i = 0;
        while (i < 690)
        {
          arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
          arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
          arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
          int k = 0;
          while (k < 3)
          {
            paramArrayOfFloat1[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
            f2 += paramArrayOfFloat1[(k * 2 + j)];
            paramArrayOfFloat1[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
            f1 += paramArrayOfFloat1[(k * 2 + j + 1)];
            k += 1;
          }
          j += 6;
          i += 3;
        }
        paramList = paramArrayOfFloat1;
      } while (paramArrayOfFloat2 == null);
      paramList = paramArrayOfFloat1;
    } while (paramArrayOfFloat2.length < 2);
    paramArrayOfFloat2[0] = f2;
    paramArrayOfFloat2[1] = f1;
    return paramArrayOfFloat1;
  }
  
  public static float[] initFacePositionsBaseOnFaceRect(List<PointF> paramList, float paramFloat1, float paramFloat2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramFloat1 <= 0.0F) || (paramFloat2 <= 0.0F) || (paramArrayOfFloat.length != 1380))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    int j = paramList.size();
    float f1 = ((PointF)paramList.get(64)).x;
    float f2 = ((PointF)paramList.get(64)).y;
    int i = 0;
    while (i < j)
    {
      ((PointF)paramList.get(i)).x -= f1;
      ((PointF)paramList.get(i)).y -= f2;
      i += 1;
    }
    PointF[] arrayOfPointF = new PointF[3];
    i = 0;
    j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 690) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramFloat1 * 2.0F);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramFloat2 * 2.0F);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initFacePositionsFaceAverage(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1104))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int j = 0;
    int i = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 552) {
        break;
      }
      switch (paramInt3)
      {
      }
      for (;;)
      {
        int k = 0;
        while (k < 3)
        {
          paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
          paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
          k += 1;
        }
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 2)]));
        continue;
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 2)]));
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initFacePositions_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    return initFacePositions_v2(paramList, paramInt1, paramInt2, paramArrayOfFloat, null);
  }
  
  public static float[] initFacePositions_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat1 == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat1.length != NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2)) {
      paramList = new float[0];
    }
    float f2;
    float f1;
    do
    {
      do
      {
        return paramList;
        PointF[] arrayOfPointF = new PointF[3];
        f2 = 0.0F;
        f1 = 0.0F;
        int j = 0;
        int i = 0;
        while (i < NO_HOLE_TRIANGLE_COUNT_V2 * 3)
        {
          arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles_v2[i]));
          arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 1)]));
          arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 2)]));
          int k = 0;
          while (k < 3)
          {
            paramArrayOfFloat1[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1 * 2.0F - 1.0F);
            f2 += paramArrayOfFloat1[(k * 2 + j)];
            paramArrayOfFloat1[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2 * 2.0F - 1.0F);
            f1 += paramArrayOfFloat1[(k * 2 + j + 1)];
            k += 1;
          }
          j += 6;
          i += 3;
        }
        paramList = paramArrayOfFloat1;
      } while (paramArrayOfFloat2 == null);
      paramList = paramArrayOfFloat1;
    } while (paramArrayOfFloat2.length < 2);
    paramArrayOfFloat2[0] = f2;
    paramArrayOfFloat2[1] = f1;
    return paramArrayOfFloat1;
  }
  
  public static float[] initIrisLinePositions(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramInt1 <= 0) || (paramInt2 <= 0))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 24) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(IrisMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(IrisMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(IrisMeshTriangles[(i + 2)]));
      paramArrayOfFloat[j] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 1)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 2)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 3)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 4)] = (arrayOfPointF[1].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 5)] = (arrayOfPointF[1].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 6)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 7)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 8)] = (arrayOfPointF[2].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 9)] = (arrayOfPointF[2].y / paramInt2 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 10)] = (arrayOfPointF[0].x / paramInt1 * 2.0F - 1.0F);
      paramArrayOfFloat[(j + 11)] = (arrayOfPointF[0].y / paramInt2 * 2.0F - 1.0F);
      j += 12;
      i += 3;
    }
  }
  
  public static float[] initMaterialFaceNoseLastTexCoords(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1380))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 690) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(faceMeshNoseLastTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(faceMeshNoseLastTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initMaterialFaceTexCoords(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1380))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 690) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initMaterialFaceTexCoordsFaceAverage(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat, int paramInt3)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != 1104))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= 552) {
        break;
      }
      switch (paramInt3)
      {
      }
      for (;;)
      {
        int k = 0;
        while (k < 3)
        {
          paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
          paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
          k += 1;
        }
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverage[(i + 2)]));
        continue;
        arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[i]));
        arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 1)]));
        arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTrianglesFaceAverageForTypeOne[(i + 2)]));
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initMaterialFaceTexCoords_v2(List<PointF> paramList, int paramInt1, int paramInt2, float[] paramArrayOfFloat)
  {
    float[] arrayOfFloat;
    if ((CollectionUtils.isEmpty(paramList)) || (paramArrayOfFloat == null) || (paramInt1 <= 0) || (paramInt2 <= 0) || (paramArrayOfFloat.length != NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2))
    {
      arrayOfFloat = new float[0];
      return arrayOfFloat;
    }
    PointF[] arrayOfPointF = new PointF[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat = paramArrayOfFloat;
      if (i >= NO_HOLE_TRIANGLE_COUNT_V2 * 3) {
        break;
      }
      arrayOfPointF[0] = ((PointF)paramList.get(FaceMeshTriangles_v2[i]));
      arrayOfPointF[1] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 1)]));
      arrayOfPointF[2] = ((PointF)paramList.get(FaceMeshTriangles_v2[(i + 2)]));
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat[(k * 2 + j)] = (arrayOfPointF[k].x / paramInt1);
        paramArrayOfFloat[(k * 2 + j + 1)] = (arrayOfPointF[k].y / paramInt2);
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initPointVis(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat1;
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2.length != 1380))
    {
      arrayOfFloat1 = new float[0];
      return arrayOfFloat1;
    }
    float[] arrayOfFloat2 = new float[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat1 = paramArrayOfFloat2;
      if (i >= 690) {
        break;
      }
      arrayOfFloat2[0] = paramArrayOfFloat1[FaceMeshTriangles[i]];
      arrayOfFloat2[1] = paramArrayOfFloat1[FaceMeshTriangles[(i + 1)]];
      arrayOfFloat2[2] = paramArrayOfFloat1[FaceMeshTriangles[(i + 2)]];
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat2[(k * 2 + j)] = arrayOfFloat2[k];
        paramArrayOfFloat2[(k * 2 + j + 1)] = arrayOfFloat2[k];
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static float[] initPointVis_v2(float[] paramArrayOfFloat1, float[] paramArrayOfFloat2)
  {
    float[] arrayOfFloat1;
    if ((paramArrayOfFloat1 == null) || (paramArrayOfFloat2.length != NO_HOLE_TRIANGLE_COUNT_V2 * 3 * 2))
    {
      arrayOfFloat1 = new float[0];
      return arrayOfFloat1;
    }
    float[] arrayOfFloat2 = new float[3];
    int i = 0;
    int j = 0;
    for (;;)
    {
      arrayOfFloat1 = paramArrayOfFloat2;
      if (i >= NO_HOLE_TRIANGLE_COUNT_V2 * 3) {
        break;
      }
      arrayOfFloat2[0] = paramArrayOfFloat1[FaceMeshTriangles_v2[i]];
      arrayOfFloat2[1] = paramArrayOfFloat1[FaceMeshTriangles_v2[(i + 1)]];
      arrayOfFloat2[2] = paramArrayOfFloat1[FaceMeshTriangles_v2[(i + 2)]];
      int k = 0;
      while (k < 3)
      {
        paramArrayOfFloat2[(k * 2 + j)] = arrayOfFloat2[k];
        paramArrayOfFloat2[(k * 2 + j + 1)] = arrayOfFloat2[k];
        k += 1;
      }
      j += 6;
      i += 3;
    }
  }
  
  public static List<PointF> loadTexCoords(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return new ArrayList();
    }
    return loadTexCoords(paramString.substring(0, paramString.lastIndexOf(File.separator)), paramString.substring(paramString.lastIndexOf(File.separator) + 1));
  }
  
  private static List<PointF> loadTexCoords(String paramString1, String paramString2)
  {
    ArrayList localArrayList = new ArrayList();
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {}
    for (;;)
    {
      return localArrayList;
      paramString1 = FileUtils.load(AEModule.getContext(), paramString1, paramString2);
      if (paramString1 == null) {
        continue;
      }
      paramString1 = paramString1.trim().split("\\s+");
      int i = 0;
      try
      {
        while (i < paramString1.length / 2)
        {
          localArrayList.add(new PointF(Float.parseFloat(paramString1[(i * 2)]), Float.parseFloat(paramString1[(i * 2 + 1)])));
          i += 1;
        }
        return new ArrayList();
      }
      catch (NumberFormatException paramString1)
      {
        LogUtils.e(TAG, paramString1.toString());
      }
    }
  }
  
  public static native void nativeGetFullCoords(Object paramObject1, int paramInt, float paramFloat, Object paramObject2);
  
  public static void recycleCrazySkinMergeBitmap()
  {
    BitmapUtils.recycle(crazySkinMergeBitmap);
  }
  
  public static void scalePoints(List<PointF> paramList, double paramDouble)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        PointF localPointF = (PointF)paramList.next();
        localPointF.x = ((float)(localPointF.x * paramDouble));
        localPointF.y = ((float)(localPointF.y * paramDouble));
      }
    }
  }
  
  public static void setCrazyFacePath(String paramString)
  {
    GRAY_FILE_CRAZY_FACE = paramString;
  }
  
  public static void setCrazyMaskCos3DPath(String paramString)
  {
    GRAY_FILE_FACE_COS3D_MASK = paramString;
  }
  
  public static void setCrazyMaskPath(String paramString)
  {
    GRAY_FILE_MASK = paramString;
  }
  
  public static void setCropHeadFacePath(String paramString)
  {
    GRAY_FILE_CROP_HEAD_FACE = paramString;
  }
  
  public static void setFaceMaskSkinPath(String paramString)
  {
    GRAY_FILE_FACE_SKIN = paramString;
  }
  
  public static void setGrayFileNoseMask(String paramString)
  {
    GRAY_FILE_NOSE_MASK = paramString;
  }
  
  public static void setMaskBrushPointPath(String paramString)
  {
    DEFAULT_BRUSH_POINT = paramString;
  }
  
  public static void setNoEyeGrayImagePath(String paramString)
  {
    GRAY_FILE_HAS_EYE = paramString;
  }
  
  public static void setNoMouthGrayImagePath(String paramString)
  {
    GRAY_FILE_NO_EYE = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.ttpic.util.FaceOffUtil
 * JD-Core Version:    0.7.0.1
 */