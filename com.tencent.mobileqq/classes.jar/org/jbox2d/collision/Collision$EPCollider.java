package org.jbox2d.collision;

import org.jbox2d.collision.shapes.EdgeShape;
import org.jbox2d.collision.shapes.PolygonShape;
import org.jbox2d.common.MathUtils;
import org.jbox2d.common.Rot;
import org.jbox2d.common.Transform;
import org.jbox2d.common.Vec2;

class Collision$EPCollider
{
  private final Collision.ClipVertex[] clipPoints1 = new Collision.ClipVertex[2];
  private final Collision.ClipVertex[] clipPoints2 = new Collision.ClipVertex[2];
  private final Vec2 edge0 = new Vec2();
  private final Vec2 edge1 = new Vec2();
  private final Vec2 edge2 = new Vec2();
  private final Collision.EPAxis edgeAxis = new Collision.EPAxis();
  private final Collision.ClipVertex[] ie = new Collision.ClipVertex[2];
  final Vec2 m_centroidB = new Vec2();
  boolean m_front;
  final Vec2 m_lowerLimit = new Vec2();
  final Vec2 m_normal = new Vec2();
  final Vec2 m_normal0 = new Vec2();
  final Vec2 m_normal1 = new Vec2();
  final Vec2 m_normal2 = new Vec2();
  final Collision.TempPolygon m_polygonB = new Collision.TempPolygon();
  float m_radius;
  Collision.EPCollider.VertexType m_type1;
  Collision.EPCollider.VertexType m_type2;
  final Vec2 m_upperLimit = new Vec2();
  Vec2 m_v0 = new Vec2();
  Vec2 m_v1 = new Vec2();
  Vec2 m_v2 = new Vec2();
  Vec2 m_v3 = new Vec2();
  final Transform m_xf = new Transform();
  private final Vec2 n = new Vec2();
  private final Vec2 perp = new Vec2();
  private final Collision.EPAxis polygonAxis = new Collision.EPAxis();
  private final Collision.ReferenceFace rf = new Collision.ReferenceFace();
  private final Vec2 temp = new Vec2();
  
  public Collision$EPCollider()
  {
    int i = 0;
    while (i < 2)
    {
      this.ie[i] = new Collision.ClipVertex();
      this.clipPoints1[i] = new Collision.ClipVertex();
      this.clipPoints2[i] = new Collision.ClipVertex();
      i += 1;
    }
  }
  
  public void collide(Manifold paramManifold, EdgeShape paramEdgeShape, Transform paramTransform1, PolygonShape paramPolygonShape, Transform paramTransform2)
  {
    Transform.mulTransToOutUnsafe(paramTransform1, paramTransform2, this.m_xf);
    Transform.mulToOutUnsafe(this.m_xf, paramPolygonShape.m_centroid, this.m_centroidB);
    this.m_v0 = paramEdgeShape.m_vertex0;
    this.m_v1 = paramEdgeShape.m_vertex1;
    this.m_v2 = paramEdgeShape.m_vertex2;
    this.m_v3 = paramEdgeShape.m_vertex3;
    boolean bool1 = paramEdgeShape.m_hasVertex0;
    boolean bool2 = paramEdgeShape.m_hasVertex3;
    this.edge1.set(this.m_v2).subLocal(this.m_v1);
    this.edge1.normalize();
    this.m_normal1.set(this.edge1.y, -this.edge1.x);
    float f3 = Vec2.dot(this.m_normal1, this.temp.set(this.m_centroidB).subLocal(this.m_v1));
    int k = 0;
    float f1;
    if (bool1)
    {
      this.edge0.set(this.m_v1).subLocal(this.m_v0);
      this.edge0.normalize();
      this.m_normal0.set(this.edge0.y, -this.edge0.x);
      if (Vec2.cross(this.edge0, this.edge1) >= 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
      f1 = Vec2.dot(this.m_normal0, this.temp.set(this.m_centroidB).subLocal(this.m_v0));
      j = i;
    }
    else
    {
      j = 0;
      f1 = 0.0F;
    }
    float f2;
    if (bool2)
    {
      this.edge2.set(this.m_v3).subLocal(this.m_v2);
      this.edge2.normalize();
      this.m_normal2.set(this.edge2.y, -this.edge2.x);
      if (Vec2.cross(this.edge1, this.edge2) > 0.0F) {
        i = 1;
      } else {
        i = 0;
      }
      f2 = Vec2.dot(this.m_normal2, this.temp.set(this.m_centroidB).subLocal(this.m_v2));
    }
    else
    {
      i = 0;
      f2 = 0.0F;
    }
    if ((bool1) && (bool2))
    {
      if ((j != 0) && (i != 0))
      {
        if ((f1 < 0.0F) && (f3 < 0.0F) && (f2 < 0.0F)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = this.m_normal0.x;
          this.m_lowerLimit.y = this.m_normal0.y;
          this.m_upperLimit.x = this.m_normal2.x;
          this.m_upperLimit.y = this.m_normal2.y;
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = (-this.m_normal1.x);
          this.m_lowerLimit.y = (-this.m_normal1.y);
          this.m_upperLimit.x = (-this.m_normal1.x);
          this.m_upperLimit.y = (-this.m_normal1.y);
        }
      }
      else if (j != 0)
      {
        if ((f1 < 0.0F) && ((f3 < 0.0F) || (f2 < 0.0F))) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = this.m_normal0.x;
          this.m_lowerLimit.y = this.m_normal0.y;
          this.m_upperLimit.x = this.m_normal1.x;
          this.m_upperLimit.y = this.m_normal1.y;
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = (-this.m_normal2.x);
          this.m_lowerLimit.y = (-this.m_normal2.y);
          this.m_upperLimit.x = (-this.m_normal1.x);
          this.m_upperLimit.y = (-this.m_normal1.y);
        }
      }
      else if (i != 0)
      {
        if ((f2 < 0.0F) && ((f1 < 0.0F) || (f3 < 0.0F))) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = this.m_normal1.x;
          this.m_lowerLimit.y = this.m_normal1.y;
          this.m_upperLimit.x = this.m_normal2.x;
          this.m_upperLimit.y = this.m_normal2.y;
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = (-this.m_normal1.x);
          this.m_lowerLimit.y = (-this.m_normal1.y);
          this.m_upperLimit.x = (-this.m_normal0.x);
          this.m_upperLimit.y = (-this.m_normal0.y);
        }
      }
      else
      {
        if ((f1 >= 0.0F) && (f3 >= 0.0F) && (f2 >= 0.0F)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = this.m_normal1.x;
          this.m_lowerLimit.y = this.m_normal1.y;
          this.m_upperLimit.x = this.m_normal1.x;
          this.m_upperLimit.y = this.m_normal1.y;
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = (-this.m_normal2.x);
          this.m_lowerLimit.y = (-this.m_normal2.y);
          this.m_upperLimit.x = (-this.m_normal0.x);
          this.m_upperLimit.y = (-this.m_normal0.y);
        }
      }
    }
    else if (bool1)
    {
      if (j != 0)
      {
        if ((f1 < 0.0F) && (f3 < 0.0F)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = this.m_normal0.x;
          this.m_lowerLimit.y = this.m_normal0.y;
          this.m_upperLimit.x = (-this.m_normal1.x);
          this.m_upperLimit.y = (-this.m_normal1.y);
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = this.m_normal1.x;
          this.m_lowerLimit.y = this.m_normal1.y;
          this.m_upperLimit.x = (-this.m_normal1.x);
          this.m_upperLimit.y = (-this.m_normal1.y);
        }
      }
      else
      {
        if ((f1 >= 0.0F) && (f3 >= 0.0F)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = this.m_normal1.x;
          this.m_lowerLimit.y = this.m_normal1.y;
          this.m_upperLimit.x = (-this.m_normal1.x);
          this.m_upperLimit.y = (-this.m_normal1.y);
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = this.m_normal1.x;
          this.m_lowerLimit.y = this.m_normal1.y;
          this.m_upperLimit.x = (-this.m_normal0.x);
          this.m_upperLimit.y = (-this.m_normal0.y);
        }
      }
    }
    else if (bool2)
    {
      if (i != 0)
      {
        if ((f3 < 0.0F) && (f2 < 0.0F)) {
          bool1 = false;
        } else {
          bool1 = true;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = (-this.m_normal1.x);
          this.m_lowerLimit.y = (-this.m_normal1.y);
          this.m_upperLimit.x = this.m_normal2.x;
          this.m_upperLimit.y = this.m_normal2.y;
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = (-this.m_normal1.x);
          this.m_lowerLimit.y = (-this.m_normal1.y);
          this.m_upperLimit.x = this.m_normal1.x;
          this.m_upperLimit.y = this.m_normal1.y;
        }
      }
      else
      {
        if ((f3 >= 0.0F) && (f2 >= 0.0F)) {
          bool1 = true;
        } else {
          bool1 = false;
        }
        this.m_front = bool1;
        if (this.m_front)
        {
          this.m_normal.x = this.m_normal1.x;
          this.m_normal.y = this.m_normal1.y;
          this.m_lowerLimit.x = (-this.m_normal1.x);
          this.m_lowerLimit.y = (-this.m_normal1.y);
          this.m_upperLimit.x = this.m_normal1.x;
          this.m_upperLimit.y = this.m_normal1.y;
        }
        else
        {
          this.m_normal.x = (-this.m_normal1.x);
          this.m_normal.y = (-this.m_normal1.y);
          this.m_lowerLimit.x = (-this.m_normal2.x);
          this.m_lowerLimit.y = (-this.m_normal2.y);
          this.m_upperLimit.x = this.m_normal1.x;
          this.m_upperLimit.y = this.m_normal1.y;
        }
      }
    }
    else
    {
      if (f3 >= 0.0F) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      this.m_front = bool1;
      if (this.m_front)
      {
        this.m_normal.x = this.m_normal1.x;
        this.m_normal.y = this.m_normal1.y;
        this.m_lowerLimit.x = (-this.m_normal1.x);
        this.m_lowerLimit.y = (-this.m_normal1.y);
        this.m_upperLimit.x = (-this.m_normal1.x);
        this.m_upperLimit.y = (-this.m_normal1.y);
      }
      else
      {
        this.m_normal.x = (-this.m_normal1.x);
        this.m_normal.y = (-this.m_normal1.y);
        this.m_lowerLimit.x = this.m_normal1.x;
        this.m_lowerLimit.y = this.m_normal1.y;
        this.m_upperLimit.x = this.m_normal1.x;
        this.m_upperLimit.y = this.m_normal1.y;
      }
    }
    this.m_polygonB.count = paramPolygonShape.m_count;
    int i = 0;
    while (i < paramPolygonShape.m_count)
    {
      Transform.mulToOutUnsafe(this.m_xf, paramPolygonShape.m_vertices[i], this.m_polygonB.vertices[i]);
      Rot.mulToOutUnsafe(this.m_xf.q, paramPolygonShape.m_normals[i], this.m_polygonB.normals[i]);
      i += 1;
    }
    this.m_radius = 0.02F;
    paramManifold.pointCount = 0;
    computeEdgeSeparation(this.edgeAxis);
    if (this.edgeAxis.type == Collision.EPAxis.Type.UNKNOWN) {
      return;
    }
    if (this.edgeAxis.separation > this.m_radius) {
      return;
    }
    computePolygonSeparation(this.polygonAxis);
    if ((this.polygonAxis.type != Collision.EPAxis.Type.UNKNOWN) && (this.polygonAxis.separation > this.m_radius)) {
      return;
    }
    if (this.polygonAxis.type == Collision.EPAxis.Type.UNKNOWN) {
      paramEdgeShape = this.edgeAxis;
    } else if (this.polygonAxis.separation > this.edgeAxis.separation * 0.98F + 0.001F) {
      paramEdgeShape = this.polygonAxis;
    } else {
      paramEdgeShape = this.edgeAxis;
    }
    paramTransform2 = this.ie;
    paramTransform1 = paramTransform2[0];
    paramTransform2 = paramTransform2[1];
    if (paramEdgeShape.type == Collision.EPAxis.Type.EDGE_A)
    {
      paramManifold.type = Manifold.ManifoldType.FACE_A;
      f1 = Vec2.dot(this.m_normal, this.m_polygonB.normals[0]);
      i = 1;
      j = 0;
      while (i < this.m_polygonB.count)
      {
        f3 = Vec2.dot(this.m_normal, this.m_polygonB.normals[i]);
        f2 = f1;
        if (f3 < f1)
        {
          j = i;
          f2 = f3;
        }
        i += 1;
        f1 = f2;
      }
      i = j + 1;
      if (i >= this.m_polygonB.count) {
        i = 0;
      }
      paramTransform1.v.set(this.m_polygonB.vertices[j]);
      paramTransform1.id.indexA = 0;
      paramTransform1.id.indexB = ((byte)j);
      paramTransform1.id.typeA = ((byte)ContactID.Type.FACE.ordinal());
      paramTransform1.id.typeB = ((byte)ContactID.Type.VERTEX.ordinal());
      paramTransform2.v.set(this.m_polygonB.vertices[i]);
      paramTransform2.id.indexA = 0;
      paramTransform2.id.indexB = ((byte)i);
      paramTransform2.id.typeA = ((byte)ContactID.Type.FACE.ordinal());
      paramTransform2.id.typeB = ((byte)ContactID.Type.VERTEX.ordinal());
      if (this.m_front)
      {
        paramTransform1 = this.rf;
        paramTransform1.i1 = 0;
        paramTransform1.i2 = 1;
        paramTransform1.v1.set(this.m_v1);
        this.rf.v2.set(this.m_v2);
        this.rf.normal.set(this.m_normal1);
      }
      else
      {
        paramTransform1 = this.rf;
        paramTransform1.i1 = 1;
        paramTransform1.i2 = 0;
        paramTransform1.v1.set(this.m_v2);
        this.rf.v2.set(this.m_v1);
        this.rf.normal.set(this.m_normal1).negateLocal();
      }
    }
    else
    {
      paramManifold.type = Manifold.ManifoldType.FACE_B;
      paramTransform1.v.set(this.m_v1);
      paramTransform1.id.indexA = 0;
      paramTransform1.id.indexB = ((byte)paramEdgeShape.index);
      paramTransform1.id.typeA = ((byte)ContactID.Type.VERTEX.ordinal());
      paramTransform1.id.typeB = ((byte)ContactID.Type.FACE.ordinal());
      paramTransform2.v.set(this.m_v2);
      paramTransform2.id.indexA = 0;
      paramTransform2.id.indexB = ((byte)paramEdgeShape.index);
      paramTransform2.id.typeA = ((byte)ContactID.Type.VERTEX.ordinal());
      paramTransform2.id.typeB = ((byte)ContactID.Type.FACE.ordinal());
      this.rf.i1 = paramEdgeShape.index;
      paramTransform1 = this.rf;
      if (paramTransform1.i1 + 1 < this.m_polygonB.count) {
        i = this.rf.i1 + 1;
      } else {
        i = 0;
      }
      paramTransform1.i2 = i;
      this.rf.v1.set(this.m_polygonB.vertices[this.rf.i1]);
      this.rf.v2.set(this.m_polygonB.vertices[this.rf.i2]);
      this.rf.normal.set(this.m_polygonB.normals[this.rf.i1]);
    }
    this.rf.sideNormal1.set(this.rf.normal.y, -this.rf.normal.x);
    this.rf.sideNormal2.set(this.rf.sideNormal1).negateLocal();
    paramTransform1 = this.rf;
    paramTransform1.sideOffset1 = Vec2.dot(paramTransform1.sideNormal1, this.rf.v1);
    paramTransform1 = this.rf;
    paramTransform1.sideOffset2 = Vec2.dot(paramTransform1.sideNormal2, this.rf.v2);
    if (Collision.clipSegmentToLine(this.clipPoints1, this.ie, this.rf.sideNormal1, this.rf.sideOffset1, this.rf.i1) < 2) {
      return;
    }
    if (Collision.clipSegmentToLine(this.clipPoints2, this.clipPoints1, this.rf.sideNormal2, this.rf.sideOffset2, this.rf.i2) < 2) {
      return;
    }
    if (paramEdgeShape.type == Collision.EPAxis.Type.EDGE_A)
    {
      paramManifold.localNormal.set(this.rf.normal);
      paramManifold.localPoint.set(this.rf.v1);
    }
    else
    {
      paramManifold.localNormal.set(paramPolygonShape.m_normals[this.rf.i1]);
      paramManifold.localPoint.set(paramPolygonShape.m_vertices[this.rf.i1]);
    }
    int j = 0;
    i = k;
    while (i < 2)
    {
      k = j;
      if (Vec2.dot(this.rf.normal, this.temp.set(this.clipPoints2[i].v).subLocal(this.rf.v1)) <= this.m_radius)
      {
        paramTransform1 = paramManifold.points[j];
        if (paramEdgeShape.type == Collision.EPAxis.Type.EDGE_A)
        {
          Transform.mulTransToOutUnsafe(this.m_xf, this.clipPoints2[i].v, paramTransform1.localPoint);
          paramTransform1.id.set(this.clipPoints2[i].id);
        }
        else
        {
          paramTransform1.localPoint.set(this.clipPoints2[i].v);
          paramTransform1.id.typeA = this.clipPoints2[i].id.typeB;
          paramTransform1.id.typeB = this.clipPoints2[i].id.typeA;
          paramTransform1.id.indexA = this.clipPoints2[i].id.indexB;
          paramTransform1.id.indexB = this.clipPoints2[i].id.indexA;
        }
        k = j + 1;
      }
      i += 1;
      j = k;
    }
    paramManifold.pointCount = j;
  }
  
  public void computeEdgeSeparation(Collision.EPAxis paramEPAxis)
  {
    paramEPAxis.type = Collision.EPAxis.Type.EDGE_A;
    paramEPAxis.index = (this.m_front ^ true);
    paramEPAxis.separation = 3.4028235E+38F;
    float f1 = this.m_normal.x;
    float f2 = this.m_normal.y;
    int i = 0;
    while (i < this.m_polygonB.count)
    {
      Vec2 localVec2 = this.m_polygonB.vertices[i];
      float f3 = (localVec2.x - this.m_v1.x) * f1 + (localVec2.y - this.m_v1.y) * f2;
      if (f3 < paramEPAxis.separation) {
        paramEPAxis.separation = f3;
      }
      i += 1;
    }
  }
  
  public void computePolygonSeparation(Collision.EPAxis paramEPAxis)
  {
    paramEPAxis.type = Collision.EPAxis.Type.UNKNOWN;
    paramEPAxis.index = -1;
    paramEPAxis.separation = -3.402824E+038F;
    this.perp.x = (-this.m_normal.y);
    this.perp.y = this.m_normal.x;
    int i = 0;
    while (i < this.m_polygonB.count)
    {
      Vec2 localVec21 = this.m_polygonB.normals[i];
      Vec2 localVec22 = this.m_polygonB.vertices[i];
      this.n.x = (-localVec21.x);
      this.n.y = (-localVec21.y);
      float f1 = localVec22.x;
      float f2 = this.m_v1.x;
      float f3 = localVec22.y;
      float f4 = this.m_v1.y;
      float f5 = this.n.x;
      float f6 = this.n.y;
      float f7 = localVec22.x;
      float f8 = this.m_v2.x;
      float f9 = localVec22.y;
      float f10 = this.m_v2.y;
      f1 = MathUtils.min(f5 * (f1 - f2) + f6 * (f3 - f4), this.n.x * (f7 - f8) + this.n.y * (f9 - f10));
      if (f1 > this.m_radius)
      {
        paramEPAxis.type = Collision.EPAxis.Type.EDGE_B;
        paramEPAxis.index = i;
        paramEPAxis.separation = f1;
        return;
      }
      if (this.n.x * this.perp.x + this.n.y * this.perp.y >= 0.0F ? Vec2.dot(this.temp.set(this.n).subLocal(this.m_upperLimit), this.m_normal) >= -0.03490659F : Vec2.dot(this.temp.set(this.n).subLocal(this.m_lowerLimit), this.m_normal) >= -0.03490659F) {
        if (f1 > paramEPAxis.separation)
        {
          paramEPAxis.type = Collision.EPAxis.Type.EDGE_B;
          paramEPAxis.index = i;
          paramEPAxis.separation = f1;
        }
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.jbox2d.collision.Collision.EPCollider
 * JD-Core Version:    0.7.0.1
 */